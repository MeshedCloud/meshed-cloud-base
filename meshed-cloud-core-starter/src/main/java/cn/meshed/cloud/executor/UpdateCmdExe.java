package cn.meshed.cloud.executor;

import cn.meshed.cloud.api.CommandExecute;
import cn.meshed.cloud.gateway.IGatewayUpdate;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class UpdateCmdExe<G extends IGatewayUpdate<T,V>,T,V> implements CommandExecute<T> {

    @Autowired
    private G gateway;

    @Override
    public Response execute(T cmd) {
        //检测名称和key是否已经存在
        checkData(cmd);
        //更新
        V update = gateway.update(cmd);
        return SingleResponse.of(update);
    }

    public abstract void checkData(T cmd);

    public G getGateway() {
        return gateway;
    }
}
