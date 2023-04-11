package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
<#if mapperAnnotation>
import org.apache.ibatis.annotations.Mapper;
</#if>
<#if baseMethods?seq_contains("findByPage")>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
</#if>
<#if baseMethods?seq_contains("findAll")>
import java.util.List;
</#if>

/**
 * @author ${author}
 * @date ${date}
 */
<#if mapperAnnotation>
@Mapper
</#if>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

<#if baseMethods?seq_contains("findByPage")>
    Page<${entity}> findByPage(Page<${entity}> page, @Param("params") Map<String, Object> params);
</#if>

<#if baseMethods?seq_contains("findAll")>
    List<${entity}> findAll();
</#if>
}
