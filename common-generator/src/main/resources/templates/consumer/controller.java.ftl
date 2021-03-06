package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import ${package.Entity}.vo.CommonResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>
import ${package.Service}.${entity}Service;
import ${package.Entity}.${entity};

import javax.annotation.Resource;

/**
* ${table.comment!} 前端控制器
*
* @author ${author}
* @date ${date}
*/
@Api(tags = "${table.comment!}管理接口")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/consumer/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>
    @Resource
    private ${entity}Service ${table.entityPath}Service;
    /**
    * 新增${table.comment!}数据
    *
    * @param ${table.entityPath}
    * @return {code,msg,data}
    */
    @ApiOperation("新增${table.comment!}数据")
    @PostMapping("/insert")
    public CommonResult<${entity}> insert(@RequestBody ${entity} ${table.entityPath}){
    return ${table.entityPath}Service.insert(${table.entityPath});
    }

    /**
    * 通过id删除${table.comment!}数据
    *
    * @param id ${table.comment!} id
    * @return {code,msg,data}
    */
    @ApiOperation("删除${table.comment!}数据")
    @DeleteMapping("/delete")
    public CommonResult<${entity}> deleteById(@RequestParam("id") Long id){
    return ${table.entityPath}Service.deleteById(id);
    }

    /**
    * 通过id更新${table.comment!}信息
    *
    * @param ${table.entityPath} ${table.comment!}
    * @return {code,msg,data}
    */
    @ApiOperation("通过id更新${table.comment!}信息")
    @PutMapping("/update")
    public CommonResult<${entity}> updateById(@RequestBody ${entity} ${table.entityPath}){
    return ${table.entityPath}Service.updateById(${table.entityPath});
    }

    /**
    * 通过id查看${table.comment!}信息
    *
    * @param id ${table.comment!} id
    * @return {code,msg,data}
    */
    @ApiOperation("通过id查看${table.comment!}信息")
    @PostMapping("/getById")
    public CommonResult<${entity}> getById(@RequestParam("id") Long id){
        return ${table.entityPath}Service.getById(id);
    }

    /**
    * 分页查询${table.comment!}
    *
    * @param current 页码
    * @param size    每页条数
    * @return {code,msg,data}
    */
    @ApiOperation("分页查询${table.comment!}")
    @PostMapping("/queryPage")
    public CommonResult <Page<${entity}>> queryPage(
        @RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
        @RequestParam(value = "size", defaultValue = "10", required = false) Integer size);
    }
}
</#if>