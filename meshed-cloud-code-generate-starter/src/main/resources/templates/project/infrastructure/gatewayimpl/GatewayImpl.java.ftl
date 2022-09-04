package ${classPackage}.${domainName}.gatewayimpl;

import ${classPackage}.gateway.database.GatewayImpl;
import ${classPackage}.${domainName}.dto.cmd.${Class}AddCmd;
import ${classPackage}.${domainName}.dto.query.${Class}ListQry;
import ${classPackage}.${domainName}.dto.vo.${Class}VO;
import ${classPackage}.${domainName}.gateway.${Class}Gateway;
import ${classPackage}.${domainName}.gatewayimpl.database.dataobject.${Class};
import cn.meshed.cloud.utils.CopyUtils;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>${domainTip}网关实现类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Service
public class ${Class}GatewayImpl
    extends GatewayImpl<${Class}, ${Class}AddCmd, ${Class}ListQry, ${Class}VO, ${Class}VO>
    implements ${Class}Gateway {



    /**
     * 处理查询条件
     *
     * @param wrapper 查询包装类
     * @param qry 查询对象
     */
    @Override
    public void handlePageWrapper(LambdaQueryWrapper<${Class}> wrapper, ${Class}ListQry qry) {

    }

    /**
     * 保存数据处理
     *
     * @param model
     * @param cmd   传递的参数
     */
    @Override
    public void handleSave(${Class} model, ${Class}AddCmd cmd) {

    }

    /**
     * 更新数据处理
     *
     * @param model 数据库对应数据
     * @param cmd   传递的参数
     */
    @Override
    public void handleUpadte(${Class} model, ${Class}AddCmd cmd) {

    }
}
