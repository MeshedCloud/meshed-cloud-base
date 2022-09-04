package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;


/**
 * <h1>通用列表接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IList<T,V> {

    /**
     * <h2>查询</h2>
     * @param qry 查询参数
     * @return
     */
    Response searchList(T qry);
}
