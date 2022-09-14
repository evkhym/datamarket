package evan.khym.datamarket.model.DB;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SellerDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;

}
