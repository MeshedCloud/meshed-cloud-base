package ${classPackage}.${domainName}.serviceimpl;

import ApiImpl;
import ${classPackage}.${domainName}.api.${Class}Service;
import ${classPackage}.${domainName}.dto.cmd.${Class}AddCmd;
import ${classPackage}.${domainName}.dto.cmd.${Class}DelCmd;
import ${classPackage}.${domainName}.dto.query.${Class}ByIdQry;
import ${classPackage}.${domainName}.dto.query.${Class}ListQry;
import ${classPackage}.${domainName}.executor.${Class}AddCmdExe;
import ${classPackage}.${domainName}.executor.${Class}DelCmdExe;
import ${classPackage}.${domainName}.executor.${Class}UpdateCmdExe;
import ${classPackage}.${domainName}.executor.query.${Class}ByIdQryExe;
import ${classPackage}.${domainName}.executor.query.${Class}ListQryExe;
import CopyUtils;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>${domainTip}} 服务实现类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class ${Class}ServiceImpl extends ApiImpl<${Class}AddCmd, ${Class}DelCmd,
        ${Class}ListQry, ${Class}ByIdQry, ${Class}ListQryExe, ${Class}ByIdQryExe,
        ${Class}AddCmdExe, ${Class}UpdateCmdExe, ${Class}DelCmdExe> implements ${Class}Service {



}
