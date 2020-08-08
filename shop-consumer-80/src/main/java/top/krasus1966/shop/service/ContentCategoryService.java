package top.krasus1966.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.shop.domain.ContentCategory;
import top.krasus1966.shop.domain.vo.CommonResult;

/**
 * Feign客户端-与广告服务端交互
 * @author Krasus1966
 * @date 2020/8/6 22:55
 **/
@Component
@FeignClient(value = "shop-service-provider-advertisement")
@RequestMapping(value = "/provider/admin/contentCategory")
public interface ContentCategoryService {

    /**
     * 分页查询广告分类信息
     *
     * @param contentCategory 分页查询条件（未生效）
     * @param current 页码
     * @param size 每页条数
     * @return {code,msg,data}
     */
    @PostMapping("/queryPage")
    CommonResult<Page<ContentCategory>> queryPage(
            @RequestBody(required = false) ContentCategory contentCategory,
            @RequestParam("current") Integer current,
            @RequestParam("size") Integer size);

    /**
     * 新增广告分类
     *
     * @param contentCategory 新增的广告分类
     * @return {code,msg}
     */
    @PostMapping("/insert")
    CommonResult<ContentCategory> insert(@RequestBody ContentCategory contentCategory);

    /**
     * 通过id删除广告分类
     *
     * @param id 广告分类id
     * @return {code,msg}
     */
    @DeleteMapping("/delete")
    CommonResult<ContentCategory> delete(@RequestParam("id") Long id);

    /**
     * 更新广告分类请求
     *
     * @param contentCategory 需要更新的广告分类
     * @return {code,msg,data}
     */
    @PutMapping("/update")
    CommonResult<ContentCategory> update(@RequestBody ContentCategory contentCategory);
}