package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
 * @date 2020/7/17 22:22
 **/
@RestController
@Api(value = "BrandController",tags = "商品品牌管理相关接口")
@RequestMapping("/provider/admin/brand")
public class BrandController {

    @Resource
    protected BrandService brandService;

    @ApiOperation("增加品牌")
    @PostMapping("/insert")
    public CommonResult<Brand> insertBrand(@RequestBody Brand brand) {
        String msg = brandService.save(brand) ? "更新成功":"更新失败";
        return CommonResult.parse(1, msg);
    }

    @ApiOperation("通过id删除品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "通过传入的id删除对应品牌",name = "id")
    })
    @PostMapping("/delete")
    public CommonResult<Brand> deleteBrand(@RequestParam("id")Long id){
        String msg = brandService.removeById(id) ? "删除成功":"删除失败";
        return CommonResult.parse(1,msg);
    }

    @ApiOperation("查询所有品牌")
    @PostMapping("/getAll")
    public CommonResult<List<Brand>> getAllBrand(){
        List<Brand> brands =  brandService.list();
        return CommonResult.parse(1,"查询成功",brands);
    }

    @ApiOperation("分页查询品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name = "current"),
            @ApiImplicitParam(value = "每页条数",name = "size")
    })
    @PostMapping("/queryPage")
    public IPage<Brand> queryPage( @RequestParam("current")Integer current, @RequestParam("size")Integer size){
        return brandService.page(new Page<>(current,size),new QueryWrapper<>());
    }

    @ApiOperation("通过id更新品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "品牌id"),
            @ApiImplicitParam(name = "name",value = "品牌名称"),
            @ApiImplicitParam(name = "image",value = "品牌图片"),
            @ApiImplicitParam(name = "firstChar",value = "品牌大写首字母"),
    })
    @PostMapping("/update")
    public CommonResult<Brand> updateBrand(Brand brand){
        String msg = brandService.updateById(brand) ? "更新成功":"更新失败";
        return CommonResult.parse(200,msg);
    }
}
