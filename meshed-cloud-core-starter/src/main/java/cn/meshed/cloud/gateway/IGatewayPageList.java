package cn.meshed.cloud.gateway;

import com.alibaba.cola.dto.PageResponse;

/**
 * <h1>通用分页查询接口接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayPageList<T,V> {

    /**
     * <h2>查询</h2>
     * @param qry 查询参数
     * @return
     */
    PageResponse<V> searchPageList(T qry);
}
