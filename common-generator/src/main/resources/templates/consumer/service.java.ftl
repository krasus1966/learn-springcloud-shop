package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${package.Entity}.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
<#if swagger2>
    import io.swagger.annotations.Api;
    import io.swagger.annotations.ApiOperation;
</#if>

/**
 * ${table.comment!} 服务类
 *
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
@Api("Feign客户端-${table.comment!}接口")
@Component
@FeignClient(value = "服务地址")
@RequestMapping(value = "/consumer/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public interface ${entity}Service {
    /**
    * 新增${table.comment!}数据
    *
    * @param ${table.entityPath}
    * @return {code,msg,data}
    */
    @ApiOperation("新增${table.comment!}数据")
    @PostMapping("/insert")
    CommonResult<${entity}> insert(${entity} ${table.entityPath});

    /**
    * 通过id删除${table.comment!}数据
    *
    * @param id ${table.comment!} id
    * @return {code,msg,data}
    */
    @ApiOperation("删除${table.comment!}数据")
    @DeleteMapping("/delete")
    CommonResult<${entity}> deleteById(Long id);

    /**
    * 通过id更新${table.comment!}信息
    *
    * @param ${table.entityPath} ${table.comment!}
    * @return {code,msg,data}
    */
    @ApiOperation("通过id更新${table.comment!}信息")
    @PutMapping("/update")
    CommonResult<${entity}> updateById(${entity} ${table.entityPath});

    /**
    * 通过id查看${table.comment!}信息
    *
    * @param id ${table.comment!} id
    * @return {code,msg,data}
    */
    @ApiOperation("通过id查看${table.comment!}信息")
    @PostMapping("/getById")
    CommonResult<${entity}> getById(Long id);

    /**
    * 分页查询${table.comment!}
    *
    * @param current 页码
    * @param size    每页条数
    * @return {code,msg,data}
    */
    @ApiOperation("分页查询${table.comment!}")
    @PostMapping("/queryPage")
    CommonResult <Page<${entity}>> queryPage(@RequestParam("current") Integer current,@RequestParam("size") Integer size);
}
</#if>
