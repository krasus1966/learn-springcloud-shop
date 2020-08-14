package top.krasus1966.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.shop.mapper.AdminDao;
import top.krasus1966.shop.entity.Admin;
import top.krasus1966.shop.service.IAdminService;

/**
 * @author Krasus1966
 * @date 2020/7/22 21:52
 **/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements IAdminService {

}
