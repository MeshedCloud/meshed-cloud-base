package ${classPackage}.${domainName}.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
* <h1>${domainTip} 实体</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("${tableName}")
public class ${Class} implements Serializable {

    private static final long serialVersionUID = 1L;


<#if tableIdField??  && tableIdField != "">
    /**
    * id
    */
    @TableId(value = "${tableIdField}",type = IdType.AUTO)
    private ${tableIdType!"Integer"} id;
</#if>

<#if entitys??>
<#list entitys as entity>
    /**
    * ${entity.tip!""}
    */
    @TableField("${entity.sqlField}")
    private ${entity.javaType} ${entity.javaField};
</#list>
</#if>

}
