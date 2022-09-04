package cn.meshed.cloud.executor;

import cn.meshed.cloud.api.BatchCommandExecute;
import cn.meshed.cloud.gateway.IGatewayBatchSave;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class BatchAddCmdExe<G extends IGatewayBatchSave<T,V>,T,V> implements BatchCommandExecute<T> {

    @Autowired
    private G gateway;

    @Override
    public Response execute(List<T> cmds) {
        //检测名称和key是否已经存在
        checkData(cmds);
        //保存
        List<V> save = gateway.batchSave(cmds);
        return SingleResponse.of(save);
    }

    public abstract void checkData(List<T> cmd);

    public G getGateway() {
        return gateway;
    }
}
