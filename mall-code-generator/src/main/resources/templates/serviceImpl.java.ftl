package ${package.ServiceImpl};

import javax.annotation.Resource;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
<#if baseMethods?seq_contains("findAll")>
import java.util.List;
</#if>
<#if baseMethods?seq_contains("findByPage")>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
</#if>

/**
 * @author ${author}
 * @date ${date}
 */
@Service
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Resource
    private ${table.mapperName} ${mapperBeanName};

<#if baseMethods?seq_contains("add")>
    @Override
    public void add(${entity} ${entityName}) {
        ${mapperBeanName}.insert(${entityName});
    }
</#if>

<#if baseMethods?seq_contains("update")>
    @Override
    public void update(${entity} ${entityName}) {
        ${mapperBeanName}.updateById(${entityName});
    }
</#if>

<#if baseMethods?seq_contains("delete")>
    @Override
    public void delete(String id) {
        ${mapperBeanName}.deleteById(id);
    }
</#if>

<#if baseMethods?seq_contains("get")>
    @Override
    public ${entity} get(String id) {
        return ${mapperBeanName}.selectById(id);
    }
</#if>

<#if baseMethods?seq_contains("findByPage")>
    @Override
    public Page<${entity}> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return ${mapperBeanName}.findByPage(new Page<>(page, size), params);
    }
</#if>

<#if baseMethods?seq_contains("findAll")>
    @Override
    public List<${entity}> findAll() {
        return ${mapperBeanName}.selectList(null);
    }
</#if>
}
