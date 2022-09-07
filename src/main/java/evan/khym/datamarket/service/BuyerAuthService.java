package evan.khym.datamarket.service;

import evan.khym.datamarket.model.DB.BuyerDTO;
import evan.khym.datamarket.repository.BuyerRepo;
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
public class BuyerAuthService implements UserDetailsService {

    private final BuyerRepo buyerRepo;

    public BuyerAuthService(BuyerRepo buyerRepo) {
        this.buyerRepo = buyerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println(id);
//        BuyerDTO buyerDTO = buyerRepo.findById(id);
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        return new User(buyerDTO.getId(), buyerDTO.getPassword(), authorityList);
        return null;
    }

    @Transactional
    public Integer save(BuyerDTO buyerDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        buyerDTO.setPassword(passwordEncoder.encode(buyerDTO.getPassword()));
//        return buyerRepo.create1(buyerDTO);
        return null;
    }

}
