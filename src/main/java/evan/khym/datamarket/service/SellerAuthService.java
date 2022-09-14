package evan.khym.datamarket.service;

import evan.khym.datamarket.model.DB.SellerDTO;
import evan.khym.datamarket.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerAuthService implements UserDetailsService {

    private final SellerRepo sellerRepo;

    public SellerAuthService(SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        SellerDTO sellerDTO = sellerRepo.findByName(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(sellerDTO.getName(), sellerDTO.getPassword(), authorityList);
    }

    @Transactional
    public Integer save(SellerDTO sellerDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        sellerDTO.setPassword(passwordEncoder.encode(sellerDTO.getPassword()));
//        return sellerRepo.create1(sellerDTO) ;
        return null;
    }
}
