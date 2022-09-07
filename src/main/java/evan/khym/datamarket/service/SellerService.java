package evan.khym.datamarket.service;

import evan.khym.datamarket.model.DB.SellerDTO;
import evan.khym.datamarket.model.Query.QSellerDTO;
import evan.khym.datamarket.repository.SellerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
