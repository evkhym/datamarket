package evan.khym.datamarket.Controller;

import evan.khym.datamarket.model.DB.SellerDTO;
import evan.khym.datamarket.model.Query.QSellerDTO;
import evan.khym.datamarket.service.SellerAuthService;
import evan.khym.datamarket.service.SellerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    private final SellerAuthService sellerAuthService;

    public SellerController(SellerAuthService sellerAuthService, SellerService sellerService) {
        this.sellerAuthService = sellerAuthService;
        this.sellerService = sellerService;
    }


    @GetMapping("/info/{id}")
    public SellerDTO getMyInfo(@PathVariable String id) {
        System.out.println("sellerInfo");
        return sellerService.getUserByName(id);
    }

    @PostMapping("/signup")
    public int sellerJoinActivity(@ModelAttribute SellerDTO sellerDTO) {
        System.out.println("sellerJoinActivity");
        return 0;
    }
}
