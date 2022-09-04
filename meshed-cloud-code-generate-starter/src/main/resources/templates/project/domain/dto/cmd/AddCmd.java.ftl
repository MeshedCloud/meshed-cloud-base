package ${classPackage}.${domainName}.dto.cmd;

import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <h1>${domainTip}添加命令</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@Data
@ApiModel("${domainTip}参数")
@EqualsAndHashCode(callSuper = false)
public class ${Class}AddCmd implements Serializable {

    private static final long serialVersionUID = 1L;
<#if cmds??>
<#list cmds as cmd>
    /**
    * ${cmd.tip!""}
    */
    @ApiModelProperty("${vo.tip!""}")
    <#if cmd.annotation??  && cmd.annotation != "">
    ${cmd.annotation}
    </#if>
    private ${cmd.javaType} ${cmd.javaField};
</#list>
</#if>

}
