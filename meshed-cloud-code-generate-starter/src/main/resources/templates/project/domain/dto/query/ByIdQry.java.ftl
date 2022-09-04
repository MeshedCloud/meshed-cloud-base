package ${classPackage}.${domainName}.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
* <h1>${domainTip}根据ID查询参数</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class ${Class}ByIdQry extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
<#if tableIdField??  && tableIdField != "">
    /**
    * ID
    */
    private ${tableIdType!"Integer"} id;
</#if>

}
