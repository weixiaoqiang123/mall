package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
<#if baseMethods?seq_contains("findByPage")>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
</#if>
<#if baseMethods?seq_contains("findAll")>
import java.util.List;
</#if>
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
import ${commonResultClass};
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * @author ${author}
 * @date ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${serviceBeanName};

    <#if baseMethods?seq_contains("add")>
    @PostMapping
    public ${commonReturnType} add(@RequestBody ${entity} ${entityName}) {
        ${serviceBeanName}.add(${entityName});
        return <#if commonReturnType == "Object">new ResponseEntity<>(HttpStatus.CREATED)<#else>${commonResultType}.success()</#if>;
    }
    </#if>

    <#if baseMethods?seq_contains("update")>
    @PutMapping
    public ${commonReturnType} update(@RequestBody ${entity} ${entityName}) {
        ${serviceBeanName}.update(${entityName});
        return <#if commonReturnType == "Object">new ResponseEntity<>(HttpStatus.Ok)<#else>${commonResultType}.success()</#if>;
    }
    </#if>

    <#if baseMethods?seq_contains("delete")>
    @DeleteMapping("/{id}")
    public ${commonReturnType} delete(@PathVariable String id) {
        ${serviceBeanName}.delete(id);
        return <#if commonReturnType == "Object">new ResponseEntity<>(HttpStatus.NO_CONTENT)<#else>${commonResultType}.success()</#if>;
    }
    </#if>

    <#if baseMethods?seq_contains("get")>
    @GetMapping("/{id}")
    public ${commonReturnType} get(@PathVariable String id) {
        ${entity} entity = ${serviceBeanName}.get(id);
        return <#if commonReturnType == "Object">new ResponseEntity<>(entity, HttpStatus.Ok)<#else>${commonResultType}.success(entity)</#if>;
    }
    </#if>

    <#if baseMethods?seq_contains("findByPage")>
    @GetMapping("/findByPage")
    public ${commonReturnType} findByPage(@RequestParam Map<String,Object> params,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        Page<${entity}> pageModel = ${serviceBeanName}.findByPage(params, page, size);
        return <#if commonReturnType == "Object">new ResponseEntity<>(pageModel, HttpStatus.Ok)<#else>${commonResultType}.success(pageModel)</#if>;
    }
    </#if>

    <#if baseMethods?seq_contains("findAll")>
    @GetMapping("/findAll")
    public ${commonReturnType} findAll() {
        List<${entity}> data = ${serviceBeanName}.findAll();
        return <#if commonReturnType == "Object">new ResponseEntity<>(data, HttpStatus.Ok)<#else>${commonResultType}.success(data)</#if>;
    }
    </#if>
}
</#if>
