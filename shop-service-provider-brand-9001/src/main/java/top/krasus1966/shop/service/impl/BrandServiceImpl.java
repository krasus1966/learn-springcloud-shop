package top.krasus1966.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.shop.dao.BrandDao;
import top.krasus1966.shop.entity.Brand;
import top.krasus1966.shop.service.BrandService;

/**
 * 品牌相关Service
 * @author Krasus1966
 * @date 2020/7/17 22:17
 **/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements BrandService {
}
