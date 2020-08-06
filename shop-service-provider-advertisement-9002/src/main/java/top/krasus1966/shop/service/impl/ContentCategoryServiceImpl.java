package top.krasus1966.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.shop.dao.ContentCategoryDao;
import top.krasus1966.shop.domain.ContentCategory;
import top.krasus1966.shop.service.ContentCategoryService;

/**
 * @author Krasus1966
 * @date 2020/8/6 22:19
 **/
@Service
public class ContentCategoryServiceImpl extends ServiceImpl<ContentCategoryDao, ContentCategory> implements ContentCategoryService {
}
