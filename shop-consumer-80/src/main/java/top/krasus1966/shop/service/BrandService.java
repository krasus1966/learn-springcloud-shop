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
 * @author Krasus1966
 * @date 2020/7/19 11:16
 **/
@Api(value = "Feign客户端-品牌接口")
@Component
@FeignClient(value = "shop-service-provider")
@RequestMapping("/provider/admin/brand")
public interface BrandService {

    @ApiOperation(value = "新增品牌")
    @PostMapping("/insert")
    CommonResult<Brand> insertBrand(@RequestBody Brand brand);

    @ApiOperation(value = "通过id删除品牌")
    @PostMapping("/delete")
    CommonResult<Brand> deleteBrand(@RequestParam("id")Long id);

    @ApiOperation(value = "查询所有品牌")
    @PostMapping("/getAll")
    CommonResult<List<Brand>> getAllBrand();

    @ApiOperation(value = "分页查询品牌列表")
    @PostMapping("/queryPage")
    Page<Brand> queryPage( @RequestParam("current")Integer current, @RequestParam("size")Integer size);

    @ApiOperation(value = "通过id更新品牌")
    @PostMapping("/update")
    CommonResult<Brand> updateBrand(@RequestBody Brand brand);
}
