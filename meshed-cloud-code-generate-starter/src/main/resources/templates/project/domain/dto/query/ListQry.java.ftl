package ${classPackage}.${domainName}.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
* <h1>${domainTip}查询列表参数</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class ${Class}ListQry extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;
<#if qrys??>
<#list qrys as qry>
    /**
    * ${qry.tip!""}
    */
    <#if qry.annotation??  && qry.annotation != "">
        ${qry.annotation}
    </#if>
    private ${qry.javaType} ${qry.javaField};
</#list>
</#if>

}
