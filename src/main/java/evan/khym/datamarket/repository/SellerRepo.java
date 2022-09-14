package evan.khym.datamarket.repository;

import evan.khym.datamarket.model.DB.SellerDTO;
import evan.khym.datamarket.model.Query.QSellerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepo {
    public SellerDTO findByName(@Param("username") String username);

    public SellerDTO findById(@Param("id") Integer id);
}
