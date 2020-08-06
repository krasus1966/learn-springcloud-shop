package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.shop.domain.Admin;
import top.krasus1966.shop.domain.AdminLoginLog;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.enums.AdminOperationEnum;
import top.krasus1966.shop.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Krasus1966
 * @date 2020/7/22 22:03
 **/
@Api(tags = "管理员登录相关接口")
@RestController
@RequestMapping("/provider/admin")
public class AdminLoginController {
    @Resource
    private AdminService adminService;

    @ApiOperation("管理员登录接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "用户名", name = "username"),
//            @ApiImplicitParam(value = "密码", name = "password")
//    })
    @PostMapping("/login")
    public CommonResult<Admin> toLogin(@RequestBody Admin admin, HttpServletRequest request) {
        if (null == adminService.getOne(new QueryWrapper<>(admin))) {
            return CommonResult.parse(AdminOperationEnum.ADMIN_LOGIN_ERROR);
        }
        new AdminLoginLog(null, request.getRemoteAddr(), admin.getUsername(), null, "").insert();
        return CommonResult.parse(AdminOperationEnum.ADMIN_LOGIN_RIGHT, admin.selectOne(new QueryWrapper<>(admin)));
    }
}
