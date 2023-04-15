package ${package.Service};

import ${package.Entity}.${entity};
<#if baseMethods?seq_contains("findByPage")>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
</#if>
<#if baseMethods?seq_contains("findAll")>
import java.util.List;
</#if>

/**
 * @author ${author}
 * @date ${date}
 */
public interface ${table.serviceName} {

<#if baseMethods?seq_contains("add")>
    void add(${entity} ${entityName});
</#if>

<#if baseMethods?seq_contains("update")>
    void update(${entity} ${entityName});
</#if>

<#if baseMethods?seq_contains("delete")>
    void delete(String id);
</#if>

<#if baseMethods?seq_contains("get")>
    ${entity} get(String id);
</#if>

<#if baseMethods?seq_contains("findByPage")>
    Page<${entity}> findByPage(Map<String,Object> params, Integer page, Integer size);
</#if>

<#if baseMethods?seq_contains("findAll")>
    List<${entity}> findAll();
</#if>
}
