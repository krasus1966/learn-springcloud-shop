package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.entity.ContentCategory;
import top.krasus1966.shop.entity.vo.CommonResult;
import top.krasus1966.shop.enums.CommonEnum;
import top.krasus1966.shop.service.ContentCategoryService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/8/6 22:21
 **/
@Api(tags = "广告分类管理接口")
@RestController
@RequestMapping(value = "/provider/admin/contentCategory")
public class ContentCategoryController {

    @Resource
    private ContentCategoryService contentCategoryService;

    /**
     * 分页查询广告分类
     *
     * @param contentCategory 广告分类
     * @param current         页码
     * @param size            每页条数
     * @return {code,msg,data}
     */
    @ApiOperation("分页查询广告分类列表")
    @PostMapping("/queryPage")
    public CommonResult<Page<ContentCategory>> queryPage(
            @RequestBody(required = false) ContentCategory contentCategory,
            @RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        return CommonResult.parse(CommonEnum.QUERY_OK, contentCategoryService.page(new Page<>(current, size)));
    }

    /**
     * 新增广告分类
     *
     * @param contentCategory 广告分类
     * @return {code,msg,data}
     */
    @ApiOperation("新增广告分类")
    @PostMapping("/insert")
    public CommonResult<ContentCategory> insert(@RequestBody ContentCategory contentCategory) {
        return CommonResult.parse(contentCategoryService.save(contentCategory) ? CommonEnum.INSERT_OK : CommonEnum.INSERT_ERR, contentCategory.selectById());
    }

    /**
     * 删除广告分类
     *
     * @param id 广告分类id
     * @return {code,msg,data}
     */
    @ApiOperation("删除广告分类")
    @DeleteMapping("/delete")
    public CommonResult<ContentCategory> delete(@RequestParam("id") Long id) {
        return CommonResult.parse(contentCategoryService.removeById(id) ? CommonEnum.DELETE_OK : CommonEnum.DELETE_ERR);
    }

    /**
     * 修改广告分类
     *
     * @param contentCategory 广告分类
     * @return {code,msg,data}
     */
    @ApiOperation("修改广告分类")
    @PutMapping("/update")
    public CommonResult<ContentCategory> update(@RequestBody ContentCategory contentCategory) {
        return CommonResult.parse(contentCategoryService.updateById(contentCategory) ? CommonEnum.UPDATE_OK : CommonEnum.UPDATE_ERR, contentCategory.selectById());
    }
}
