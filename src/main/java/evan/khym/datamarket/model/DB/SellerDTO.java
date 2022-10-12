package evan.khym.datamarket.model.DB;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "seller")
public class SellerDTO {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

}
