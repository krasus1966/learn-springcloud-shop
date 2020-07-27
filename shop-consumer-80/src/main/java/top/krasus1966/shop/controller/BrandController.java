package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.domain.Brand;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.service.BrandService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Krasus1966
 * @date 2020/7/19 11:16
 **/
@Api(tags = "商品品牌管理相关接口")
@RestController
@RequestMapping("/consumer/admin/brand")
public class BrandController {

    @Resource
    protected BrandService brandService;

    @ApiOperation("增加品牌")
    @GetMapping("/insert")
    public CommonResult<Brand> insertBrand(Brand brand) {
        return brandService.insertBrand(brand);
    }

    @ApiOperation("通过id删除品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "通过传入id删除对应品牌")
    })
    @GetMapping("/delete")
    public CommonResult<Brand> deleteBrand(@RequestParam("id") Long id) {
        return brandService.deleteBrand(id);
    }

    @ApiOperation("获取所有品牌")
    @GetMapping("/getAll")
    public CommonResult<List<Brand>> getAllBrand() {
        return brandService.getAllBrand();
    }

    @ApiOperation("分页查询品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "品牌信息",name = "brand"),
            @ApiImplicitParam(value = "页码",name = "current"),
            @ApiImplicitParam(value = "每页条数",name = "size")
    })
    @GetMapping("/queryPage")
    public Page<Brand> queryPage(@RequestParam("current")Integer current, @RequestParam("size")Integer size){
        return brandService.queryPage(current,size);
    }

    @ApiOperation("通过id修改品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "品牌id"),
            @ApiImplicitParam(name = "name",value = "品牌名称"),
            @ApiImplicitParam(name = "image",value = "品牌图片"),
            @ApiImplicitParam(name = "firstChar",value = "品牌大写首字母"),
    })
    @PostMapping("/update")
    public CommonResult<Brand> updateBrand(Brand brand){
        return brandService.updateBrand(brand);
    }
}
