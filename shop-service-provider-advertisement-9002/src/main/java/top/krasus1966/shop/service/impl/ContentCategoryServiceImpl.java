package top.krasus1966.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.shop.mapper.ContentCategoryMapper;
import top.krasus1966.shop.entity.ContentCategory;
import top.krasus1966.shop.service.IContentCategoryService;

/**
 * @author Krasus1966
 * @date 2020/8/6 22:19
 **/
@Service
public class ContentCategoryServiceImpl extends ServiceImpl<ContentCategoryMapper, ContentCategory> implements IContentCategoryService {
}
