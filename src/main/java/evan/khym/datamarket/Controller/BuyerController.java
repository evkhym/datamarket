package evan.khym.datamarket.Controller;

import evan.khym.datamarket.model.DB.BuyerDTO;
import evan.khym.datamarket.service.BuyerAuthService;
import evan.khym.datamarket.service.BuyerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    private final BuyerService buyerService;

    private final BuyerAuthService buyerAuthService;

    public BuyerController(BuyerAuthService buyerAuthService, BuyerService buyerService) {
        this.buyerAuthService = buyerAuthService;
        this.buyerService = buyerService;
    }

    @GetMapping("/info")
    public int buyer() {
        System.out.println("buyer");
        return 0;
    }

    @PostMapping("/signup")
    public int buyerJoinActivity(@ModelAttribute BuyerDTO buyerDTO) {
        System.out.println("buyerJoinActivity");
        return 0;
    }

}
