package cn.meshed.cloud.executor;

import cn.meshed.cloud.api.CommandExecute;
import cn.meshed.cloud.gateway.IGatewayDelete;
import com.alibaba.cola.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class DeleteCmdExe<G extends IGatewayDelete,T,I extends Comparable> implements CommandExecute<T> {

    @Autowired
    private G gateway;

    @Override
    public Response execute(T cmd) {
        Serializable id = getId(cmd);
        gateway.deleteById(id);
        return Response.buildSuccess();
    }

    /**
     * 外部指定ID
     * @param qry
     * @return
     */
    protected abstract Serializable getId(T qry);
}
