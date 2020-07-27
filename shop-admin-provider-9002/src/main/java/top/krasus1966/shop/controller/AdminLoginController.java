package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.domain.Admin;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.enums.AdminOperationEnum;
import top.krasus1966.shop.exception.CustomizeErrorCode;
import top.krasus1966.shop.exception.CustomizeException;
import top.krasus1966.shop.service.AdminService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/22 22:03
 **/
@RestController
@RequestMapping("/provider/admin")
public class AdminLoginController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public CommonResult<Admin> toLogin(@RequestBody Admin admin){
        if(null==adminService.getOne(new QueryWrapper<>(admin))){
            return CommonResult.parse(AdminOperationEnum.ADMIN_LOGIN_WRONG);
        }
        return  CommonResult.parse(AdminOperationEnum.ADMIN_LOGIN_RIGHT,admin);
    }

    @PostMapping("/page_not_fount")
    public CommonResult pageNotFount(@RequestParam("id")String id){
        if ("".equals(id)||null == id){
            throw new CustomizeException(CustomizeErrorCode.PAGE_NOT_FOUND);
        }else{
            throw new CustomizeException(CustomizeErrorCode.SERVICE_GOT_WRONG);
        }
    }
}
