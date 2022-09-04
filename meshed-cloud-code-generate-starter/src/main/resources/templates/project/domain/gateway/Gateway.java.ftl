package ${classPackage}.${domainName}.gateway;

import ${classPackage}.gateway.IGateway;
import ${classPackage}.gateway.IGatewayBatchSave;
import ${classPackage}.${domainName}.dto.cmd.${Class}AddCmd;
import ${classPackage}.${domainName}.dto.query.${Class}ListQry;
import ${classPackage}.${domainName}.dto.vo.${Class}VO;

import java.util.List;

/**
 * <h1>${domainTip}网关</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ${Class}Gateway extends
    IGateway<${Class}AddCmd, ${Class}ListQry, ${Class}VO, ${Class}VO>,
    IGatewayBatchSave<${Class}AddCmd, ${Class}VO> {


}
