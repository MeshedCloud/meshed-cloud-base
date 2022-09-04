package ${classPackage}.${domainName}.dto.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
* <h1>${domainTip}视图对象</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@Data
@ApiModel("${domainTip}")
@EqualsAndHashCode(callSuper = false)
public class ${Class}VO implements Serializable {

    private static final long serialVersionUID = 1L;
<#if vos??>
<#list vos as vo>
    /**
    * ${vo.tip!""}
    */
    @ApiModelProperty("${vo.tip!""}")
    <#if vo.annotation??  && vo.annotation != "">
        ${vo.annotation}
    </#if>
    private ${vo.javaType} ${vo.javaField};
</#list>
</#if>

}
