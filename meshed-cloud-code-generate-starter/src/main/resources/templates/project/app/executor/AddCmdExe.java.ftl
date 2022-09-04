package ${classPackage}.${domainName}.executor;

import AddCmdExe;
import ${classPackage}.${domainName}.dto.cmd.${Class}AddCmd;
import ${classPackage}.${domainName}.dto.vo.${Class}VO;
import ${classPackage}.${domainName}.gateway.${Class}Gateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <h1>${domainTip}新增命令执行</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class ${Class}AddCmdExe extends AddCmdExe<${Class}Gateway, ${Class}AddCmd, ${Class}VO> {


    /**
     * 检查数据
     * @param cmd
     */
    public void checkData(${Class}AddCmd cmd) {


    }
}
