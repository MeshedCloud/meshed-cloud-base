package ${classPackage}.${domainName}.executor;

import DeleteCmdExe;
import ${classPackage}.${domainName}.dto.cmd.${Class}DelCmd;
import ${classPackage}.${domainName}.gateway.${Class}Gateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <h1>${domainTip}删除命令执行</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class ${Class}DelCmdExe extends DeleteCmdExe<${Class}Gateway, ${Class}DelCmd, Integer> {

    /**
     * 外部指定ID
     *
     * @param qry
     * @return
     */
    @Override
    protected Integer getId(${Class}DelCmd qry) {
<#if tableIdField??  && tableIdField != "">
        return qry.getId();
<#else>
        return null;
</#if>
    }
}
