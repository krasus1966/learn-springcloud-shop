package top.krasus1966.shop.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.krasus1966.shop.entity.Admin;
import top.krasus1966.shop.entity.vo.CommonResult;

/**
 * Feign客户端-与管理端交互
 *
 * @author Krasus1966
 * @date 2020/7/22 22:15
 **/
@Api(tags = "Feign客户端-管理员接口")
@Component
@FeignClient(value = "shop-service-provider-admin")
@RequestMapping("/provider/admin")
public interface AdminService {

    /**
     * 发送登录请求
     *
     * @param admin 管理员用户名与密码
     * @return {code,msg,data}
     */
    @ApiOperation("发送登录请求")
    @PostMapping("/login")
    CommonResult<Admin> toLogin(@RequestBody Admin admin);
}
