package ${classPackage}.${domainName}.executor.query;

import GetOneCmdExe;
import ${classPackage}.${domainName}.dto.query.${Class}ByIdQry;
import ${classPackage}.${domainName}.dto.vo.${Class}VO;
import ${classPackage}.${domainName}.gateway.${Class}Gateway;
import org.springframework.stereotype.Component;

/**
 * <h1>${domainTip}根据ID命令执行</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Component
public class ${Class}ByIdQryExe
        extends GetOneCmdExe<${Class}Gateway, ${Class}ByIdQry, ${Class}VO,Integer> {


    /**
     * 外部指定ID
     *
     * @param qry
     * @return
     */
    @Override
    protected Integer getId(${Class}ByIdQry qry) {
        return qry.getId();
    }
}
