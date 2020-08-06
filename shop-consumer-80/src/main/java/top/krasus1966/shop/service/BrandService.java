package top.krasus1966.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.shop.domain.Brand;
import top.krasus1966.shop.domain.vo.CommonResult;

import java.util.List;

/**
 * Feign客户端，与服务端-品牌服务进行交互
 *
 * @author Krasus1966
 * @date 2020/7/19 11:16
 **/
@Api(tags = "Feign客户端-品牌接口")
@Component
@FeignClient(value = "shop-service-provider-brand")
@RequestMapping("/provider/admin/brand")
public interface BrandService {

    @ApiOperation("新增品牌请求")
    @PostMapping("/insert")
    CommonResult<Brand> insertBrand(@RequestBody Brand brand);

    @ApiOperation("通过id删除品牌请求")
    @PostMapping("/delete")
    CommonResult<Brand> deleteBrand(@RequestParam("id") Long id);

    @ApiOperation("查询所有品牌请求")
    @PostMapping("/getAll")
    CommonResult<List<Brand>> getAllBrand();

    @ApiOperation("分页查询品牌列表请求")
    @PostMapping("/queryPage")
    Page<Brand> queryPage(@RequestParam("current") Integer current, @RequestParam("size") Integer size);

    @ApiOperation("通过id更新品牌请求")
    @PostMapping("/update")
    CommonResult<Brand> updateBrand(@RequestBody Brand brand);
}
