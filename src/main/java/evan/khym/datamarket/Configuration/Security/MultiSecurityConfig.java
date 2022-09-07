package evan.khym.datamarket.Configuration.Security;

import evan.khym.datamarket.service.BuyerAuthService;
import evan.khym.datamarket.service.SellerAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class MultiSecurityConfig {

    public CorsConfigurationSource getCorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Configuration
    @Order(1)
    public class SellerSecurityConfig extends WebSecurityConfigurerAdapter {
        private final SellerAuthService sellerAuthService;


        public SellerSecurityConfig(SellerAuthService sellerAuthService) {
            this.sellerAuthService = sellerAuthService;
        }

        // CORS 허용 적용
        public CorsConfigurationSource corsConfigurationSource1() {
            return getCorsConfigurationSource();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/seller/**")
                    .cors().configurationSource(corsConfigurationSource1()).and().csrf().disable()
                    .authorizeRequests()
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .antMatchers("/seller/signup").permitAll()
                    .antMatchers("/seller/info").permitAll()
                    .antMatchers("/seller/val/**").permitAll()
                    .antMatchers("/seller/login").permitAll()
                    .antMatchers("/seller/**").hasRole("USER")
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/seller/login")
                    .successHandler(new CustomLoginSuccessHandler())
                    .failureHandler(new CustomLoginFailureHandler())
                    .usernameParameter("id")
                    .passwordParameter("password")
                    .and()
                    .logout()
                    .logoutUrl("/seller/logout")
                    .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and()
                    .rememberMe()
                    .key("uniqueAndSecretKey")
                    .rememberMeParameter("remember-me")
                    .tokenValiditySeconds(30 * 24 * 3600)
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(new CustomAccessDeniedHandler())
                    .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(sellerAuthService).passwordEncoder(passwordEncoderSeller());
        }

        @Bean
        public PasswordEncoder passwordEncoderSeller() {
            return new BCryptPasswordEncoder();
        }
    }

    @Configuration
    @Order(2)
    public class BuyerSecurityConfig extends WebSecurityConfigurerAdapter {
        private final BuyerAuthService buyerAuthService;


        public BuyerSecurityConfig(BuyerAuthService buyerAuthService) {
            this.buyerAuthService = buyerAuthService;
        }

        // CORS 허용 적용
        public CorsConfigurationSource corsConfigurationSource2() {
            return getCorsConfigurationSource();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/buyer/**")
                    .cors().configurationSource(corsConfigurationSource2()).and().csrf().disable()
                    .authorizeRequests()
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .antMatchers("/buyer/signup").permitAll()
                    .antMatchers("/buyer/info").permitAll()
                    .antMatchers("/buyer/val/**").permitAll()
                    .antMatchers("/buyer/login").permitAll()
                    .antMatchers("/buyer/**").hasRole("USER")
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/buyer/login")
                    .successHandler(new CustomLoginSuccessHandler())
                    .failureHandler(new CustomLoginFailureHandler())
                    .usernameParameter("id")
                    .passwordParameter("password")
                    .and()
                    .logout()
                    .logoutUrl("/buyer/logout")
                    .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and()
                    .rememberMe()
                    .key("uniqueAndSecretKey")
                    .rememberMeParameter("remember-me")
                    .tokenValiditySeconds(30 * 24 * 3600)
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(new CustomAccessDeniedHandler())
                    .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(buyerAuthService).passwordEncoder(passwordEncoderBuyer());
        }


        @Bean
        public PasswordEncoder passwordEncoderBuyer() {
            return new BCryptPasswordEncoder();
        }
    }

}
