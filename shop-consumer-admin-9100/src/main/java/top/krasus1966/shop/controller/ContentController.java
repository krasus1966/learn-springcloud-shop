package top.krasus1966.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.entity.Content;
import top.krasus1966.shop.entity.vo.CommonResult;
import top.krasus1966.shop.service.ContentService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/8/8 22:57
 **/
@Api("广告管理接口")
@RestController
@RequestMapping("/consumer/admin/content")
public class ContentController {
    @Resource
    private ContentService contentService;

    /**
     * 分页查询广告
     *
     * @param current 页码
     * @param size    每页条数
     * @return {code,msg,data}
     */
    @ApiOperation("分页查询广告")
    @PostMapping("/queryPage")
    public CommonResult<Page<Content>> queryPage(
            @RequestParam("current") Integer current,
            @RequestParam("size") Integer size) {
        return contentService.queryPage(current, size);
    }

    /**
     * 新增广告
     *
     * @param content 广告
     * @return {code,msg,data}
     */
    @ApiOperation("新增广告")
    @PostMapping("/insert")
    public CommonResult<Content> insert(Content content) {
        return contentService.insert(content);
    }

    /**
     * 删除广告
     *
     * @param id 广告id
     * @return {code,msg,data}
     */
    @ApiOperation("删除广告")
    @DeleteMapping("/delete")
    public CommonResult<Content> delete(@RequestParam("id") Long id) {
        return contentService.delete(id);
    }

    /**
     * 修改广告
     *
     * @param content 广告
     * @return {code,msg,data}
     */
    @ApiOperation("修改广告")
    @PutMapping("/update")
    public CommonResult<Content> update(Content content) {
        return contentService.update(content);
    }
}
