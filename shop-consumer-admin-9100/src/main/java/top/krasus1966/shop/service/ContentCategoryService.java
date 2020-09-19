package top.krasus1966.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.entity.ContentCategory;
import top.krasus1966.shop.entity.vo.CommonResult;

import java.util.List;

/**
 * Feign客户端-与广告服务端交互
 *
 * @author Krasus1966
 * @date 2020/8/6 22:55
 **/
@Api("Feign客户端-广告分类管理接口")
@Component
@FeignClient(value = "shop-service-provider-advertisement")
@RequestMapping(value = "/provider/admin/contentCategory")
public interface ContentCategoryService {

    /**
     * 新增广告分类
     *
     * @param contentCategory 新增的广告分类
     * @return {code,msg}
     */
    @ApiOperation("新增广告分类")
    @PostMapping("/insert")
    CommonResult<ContentCategory> insert(@RequestBody ContentCategory contentCategory);

    /**
     * 通过id删除广告分类
     *
     * @param id 广告分类id
     * @return {code,msg}
     */
    @ApiOperation("通过id删除广告分类")
    @DeleteMapping("/delete")
    CommonResult<ContentCategory> delete(@RequestParam("id") Long id);

    /**
     * 更新广告分类请求
     *
     * @param contentCategory 需要更新的广告分类
     * @return {code,msg,data}
     */
    @ApiOperation("更新广告分类请求")
    @PutMapping("/update")
    CommonResult<ContentCategory> update(@RequestBody ContentCategory contentCategory);

    /**
     * 通过id查询广告分类信息
     *
     * @param id 广告分类id
     * @return {code,msg,data}
     */
    @ApiOperation("通过id查询广告分类信息")
    @PostMapping("/getById")
    CommonResult<ContentCategory> getById(@RequestParam("contentCategoryId") Long id);

    /**
     * 分页查询广告分类信息
     *
     * @param current 页码
     * @param size    每页条数
     * @return {code,msg,data}
     */
    @ApiOperation("分页查询广告分类信息")
    @PostMapping("/queryPage")
    CommonResult<Page<ContentCategory>> queryPage(
            @RequestParam(value = "current", defaultValue = "1") Integer current,
            @RequestParam(value = "size", defaultValue = "10") Integer size);

    /**
     * 列表查询广告分类信息
     *
     * @return {code,msg,data}
     */
    @ApiOperation("分页查询广告分类信息")
    @PostMapping("/query")
    CommonResult<List<ContentCategory>> query();
}
