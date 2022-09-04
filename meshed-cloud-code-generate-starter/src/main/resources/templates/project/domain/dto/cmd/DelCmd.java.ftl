package ${classPackage}.${domainName}.dto.cmd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
* <h1>${domainTip}删除命令</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class ${Class}DelCmd implements Serializable {

    private static final long serialVersionUID = 1L;

<#if tableIdField??  && tableIdField != "">
    /**
    * 删除ID
    */
    private ${tableIdType!"Integer"} id;
</#if>

}
