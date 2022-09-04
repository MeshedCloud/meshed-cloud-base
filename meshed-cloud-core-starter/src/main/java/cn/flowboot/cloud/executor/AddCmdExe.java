package cn.meshed.cloud.executor;

import cn.meshed.cloud.api.CommandExecute;
import cn.meshed.cloud.gateway.IGatewaySave;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class AddCmdExe<G extends IGatewaySave<T,V>,T,V> implements CommandExecute<T> {

    @Autowired
    private G gateway;

    @Override
    public Response execute(T cmd) {
        //检测名称和key是否已经存在
        checkData(cmd);
        //保存
        V save = gateway.save(cmd);
        return SingleResponse.of(save);
    }

    public abstract void checkData(T cmd);

    public G getGateway() {
        return gateway;
    }
}
