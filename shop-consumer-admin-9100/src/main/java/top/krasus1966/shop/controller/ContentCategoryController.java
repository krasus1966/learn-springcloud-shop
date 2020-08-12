package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.entity.ContentCategory;
import top.krasus1966.shop.entity.vo.CommonResult;
import top.krasus1966.shop.service.ContentCategoryService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/8/8 20:08
 **/
@Api("广告分类管理接口")
@RestController
@RequestMapping("/consumer/admin/contentCategory")
public class ContentCategoryController {
    @Resource
    private ContentCategoryService contentCategoryService;

    /**
     * 新增广告分类
     *
     * @param contentCategory 广告分类
     * @return {code,msg,data}
     */
    @ApiOperation("新增广告分类")
    @PostMapping("/insert")
    public CommonResult<ContentCategory> insert(ContentCategory contentCategory) {
        return contentCategoryService.insert(contentCategory);
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
        return contentCategoryService.delete(id);
    }

    /**
     * 修改广告分类
     *
     * @param contentCategory 广告分类
     * @return {code,msg,data}
     */
    @ApiOperation("修改广告分类")
    @PutMapping("/update")
    public CommonResult<ContentCategory> update(ContentCategory contentCategory) {
        return contentCategoryService.update(contentCategory);
    }

    /**
     * 通过id查询广告分类信息
     *
     * @param id 广告分类id
     * @return {code,msg,data}
     */
    @ApiOperation("通过id查询广告分类信息")
    @PostMapping("/getById")
    public CommonResult<ContentCategory> getById(@RequestParam("id") Long id) {
        return contentCategoryService.getById(id);
    }

    /**
     * 分页查询广告分类
     *
     * @param current         页码
     * @param size            每页条数
     * @return {code,msg,data}
     */
    @ApiOperation("分页查询广告分类")
    @PostMapping("/queryPage")
    public CommonResult<Page<ContentCategory>> queryPage(
            @RequestParam("current") Integer current,
            @RequestParam("size") Integer size) {

        return contentCategoryService.queryPage(current, size);
    }
}
