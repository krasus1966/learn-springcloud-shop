package top.krasus1966.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.entity.Content;
import top.krasus1966.shop.entity.vo.CommonResult;

/**
 * @author Krasus1966
 * @date 2020/8/8 22:55
 **/
@Api("Feign客户端-广告管理接口")
@Component
@FeignClient(value = "shop-service-provider-advertisement")
@RequestMapping(value = "/provider/admin/content")
public interface ContentService {
    /**
     * 分页查询广告
     *
     * @param current 页码
     * @param size    每页条数
     * @return {code,msg,data}
     */
    @ApiOperation("分页查询广告列表")
    @PostMapping("/queryPage")
    CommonResult<Page<Content>> queryPage(
            @RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size);

    /**
     * 新增广告
     *
     * @param content 广告
     * @return {code,msg,data}
     */
    @ApiOperation("新增广告")
    @PostMapping("/insert")
    CommonResult<Content> insert(@RequestBody Content content);

    /**
     * 删除广告
     *
     * @param id 广告id
     * @return {code,msg,data}
     */
    @ApiOperation("删除广告")
    @DeleteMapping("/delete")
    CommonResult<Content> delete(@RequestParam("id") Long id);

    /**
     * 修改广告
     *
     * @param content 广告
     * @return {code,msg,data}
     */
    @ApiOperation("修改广告")
    @PutMapping("/update")
    CommonResult<Content> update(@RequestBody Content content);
}
