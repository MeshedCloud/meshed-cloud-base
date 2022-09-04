package cn.meshed.cloud.gateway;

import java.util.List;

/**
 * <h1>通用列表接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayList<T,V> {

    /**
     * <h2>查询</h2>
     * @param qry 查询参数
     * @return
     */
    List<V> searchList(T qry);
}
