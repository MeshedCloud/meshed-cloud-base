package cn.meshed.cloud.executor.query;

import cn.meshed.cloud.api.CommandExecute;
import cn.meshed.cloud.gateway.IGatewayOneById;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class GetOneCmdExe<G extends IGatewayOneById<V>,T,V,I extends Comparable> implements CommandExecute<T> {

    @Autowired
    private G gateway;

    @Override
    public Response execute(T qry) {
        Serializable id = getId(qry);
        return SingleResponse.of(gateway.getOneById(id));
    }

    /**
     * 外部指定ID
     * @param qry
     * @return
     */
    protected abstract Serializable getId(T qry);
}
