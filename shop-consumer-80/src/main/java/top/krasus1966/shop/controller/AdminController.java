package top.krasus1966.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.domain.Admin;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Krasus1966
 * @date 2020/7/22 22:20
 **/
@Api(value = "管理员操作接口")
@RestController
@RequestMapping("/consumer/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ApiOperation(value = "toLogin",tags = "管理员登录接口")
    @PostMapping("/toLogin")
    public CommonResult<Admin> toLogin(@RequestBody Admin admin, HttpSession httpSession) {
        Admin user = adminService.toLogin(admin).getData();
        if (null == user) {
            return CommonResult.parse(403, "登录失败");
        }
        httpSession.setAttribute("loginUser", user);
        return CommonResult.parse(200, "登录成功");
    }
}
