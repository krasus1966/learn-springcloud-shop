package top.krasus1966.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.shop.dao.ContentDao;
import top.krasus1966.shop.domain.Content;
import top.krasus1966.shop.service.ContentService;

/**
 * @author Krasus1966
 * @date 2020/8/8 22:52
 **/
@Service
public class ContentServiceImpl extends ServiceImpl<ContentDao, Content> implements ContentService {
}
