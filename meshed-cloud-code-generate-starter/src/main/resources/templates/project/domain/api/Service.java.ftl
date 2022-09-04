package ${classPackage}.${domainName}.api;

import IApi;
import ${classPackage}.${domainName}.dto.cmd.${Class}AddCmd;
import ${classPackage}.${domainName}.dto.cmd.${Class}DelCmd;
import ${classPackage}.${domainName}.dto.query.${Class}ByIdQry;
import ${classPackage}.${domainName}.dto.query.${Class}ListQry;
import com.alibaba.cola.dto.Response;

/**
 * <h1>${domainTip}应用层服务</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ${Class}Service extends
    IApi<${Class}AddCmd, ${Class}DelCmd, ${Class}ListQry, ${Class}ByIdQry> {


}
