package evan.khym.datamarket.repository;

import evan.khym.datamarket.model.DB.BuyerDTO;
import evan.khym.datamarket.model.DB.SellerDTO;
import evan.khym.datamarket.model.Query.QBuyerDTO;
import evan.khym.datamarket.model.Query.QSellerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuyerRepo {
    public BuyerDTO findById(@Param("id") String id);
}
