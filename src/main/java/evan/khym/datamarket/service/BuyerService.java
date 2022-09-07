package evan.khym.datamarket.service;

import evan.khym.datamarket.model.DB.BuyerDTO;
import evan.khym.datamarket.model.Query.QBuyerDTO;
import evan.khym.datamarket.repository.BuyerRepo;
import evan.khym.datamarket.repository.SellerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuyerService {

    private final BuyerRepo buyerRepo;

    public BuyerService(BuyerRepo buyerRepo) {
        this.buyerRepo = buyerRepo;
    }

    public BuyerDTO getUserById(String id) {
        return this.buyerRepo.findById(id);
    }

}
