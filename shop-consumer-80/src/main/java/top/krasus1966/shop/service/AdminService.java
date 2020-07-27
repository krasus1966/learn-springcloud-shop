package top.krasus1966.shop.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.krasus1966.shop.domain.Admin;
import top.krasus1966.shop.domain.vo.CommonResult;

/**
 * @author Krasus1966
 * @date 2020/7/22 22:15
 **/
@Api(value = "Feign客户端-管理员接口")
@Component
@FeignClient(value = "SHOP-ADMIN-PROVIDER-EUREKA")
@RequestMapping("/provider/admin/")
public interface AdminService {

    @ApiOperation(value = "请求登录信息")
    @PostMapping("/login")
    CommonResult<Admin> toLogin(@RequestBody Admin admin);
}
