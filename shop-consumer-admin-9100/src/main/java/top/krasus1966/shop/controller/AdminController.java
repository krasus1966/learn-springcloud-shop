package top.krasus1966.shop.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.shop.domain.Admin;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.enums.AdminOperationEnum;
import top.krasus1966.shop.exception.CustomizeException;
import top.krasus1966.shop.fallback.CommonFallback;
import top.krasus1966.shop.handler.CommonHander;
import top.krasus1966.shop.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Krasus1966
 * @date 2020/7/22 22:20
 **/
@Api(tags = "管理员操作相关接口")
@RestController
@RequestMapping("/consumer/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 发送登录请求
     *
     * @param admin 管理员用户名与密码
     * @return {code,msg,data}
     */
    @ApiOperation("管理员登录接口")
    @PostMapping(value = "/toLogin")
    @SentinelResource(value = "toLogin",
            blockHandlerClass = CommonHander.class,
            blockHandler = "commonHandlerException",
            fallbackClass = CommonFallback.class,
            fallback = "handlerFallback",
            exceptionsToIgnore = {CustomizeException.class}
            //需要忽略抛出的异常 请使用 exceptionsToIgnore = {需要忽略的异常类型}
    )
    public CommonResult<Admin> toLogin(Admin admin, HttpSession httpSession) {
        Admin user = adminService.toLogin(admin).getData();
        if (null == user) {
            return CommonResult.parse(AdminOperationEnum.ADMIN_LOGIN_ERROR);
        }
        if (user.getStatus() == 1) {
            return CommonResult.parse(AdminOperationEnum.ADMIN_LOCKDOWN);
        }
        httpSession.setAttribute("loginUser", user);
        return CommonResult.parse(AdminOperationEnum.ADMIN_LOGIN_RIGHT, user);
    }
}
