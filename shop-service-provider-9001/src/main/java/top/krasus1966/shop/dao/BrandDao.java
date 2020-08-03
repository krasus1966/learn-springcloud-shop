package top.krasus1966.shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.shop.domain.Brand;

/**
 * 品牌相关Dao
 * @author Krasus1966
 * @date 2020/7/17 22:16
 **/
@Mapper
public interface BrandDao extends BaseMapper<Brand> {

}
