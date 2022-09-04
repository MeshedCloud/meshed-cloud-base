package cn.meshed.cloud.executor.query;

import cn.meshed.cloud.api.CommandExecute;
import cn.meshed.cloud.gateway.IGatewayPageList;
import com.alibaba.cola.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class PageListCmdExe<G extends IGatewayPageList<T,V>,T,V> implements CommandExecute<T> {

    @Autowired
    private G gateway;

    @Override
    public Response execute(T qry) {
        return gateway.searchPageList(qry);
    }
}
