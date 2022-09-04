package ${classPackage}.${domainName}.executor.query;

import cn.meshed.cloud.executor.query.PageListCmdExe;
import ${classPackage}.${domainName}.dto.query.${Class}ListQry;
import ${classPackage}.${domainName}.dto.vo.${Class}VO;
import ${classPackage}.${domainName}.gateway.${Class}Gateway;
import org.springframework.stereotype.Component;

/**
 * <h1>${domainTip}列表查询命令执行</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
//@RequiredArgsConstructor
@Component
public class ${Class}ListQryExe extends PageListCmdExe<${Class}Gateway, ${Class}ListQry, ${Class}VO> {

}
