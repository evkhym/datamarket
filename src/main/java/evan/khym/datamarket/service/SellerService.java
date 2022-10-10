package evan.khym.datamarket.service;

import evan.khym.datamarket.model.DB.SellerDTO;
import evan.khym.datamarket.repository.SellerRepo;
import org.springframework.stereotype.Service;



@Service
public class SellerService {

    private final SellerRepo sellerRepo;

    public SellerService(SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    public SellerDTO getUserByName(String username) {
        return this.sellerRepo.findByName(username);
    }

    public SellerDTO getUserById(Integer id) {
        return this.sellerRepo.findById(id);
    }
}
