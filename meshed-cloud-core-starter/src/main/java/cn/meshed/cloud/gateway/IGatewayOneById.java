package cn.meshed.cloud.gateway;

import java.io.Serializable;

/**
 * <h1>通用查询单个对象接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayOneById<V> {

    /**
     * 根据ID查询一个元素
     * @param data
     * @return
     */
    V getOneById(Serializable data);
}
