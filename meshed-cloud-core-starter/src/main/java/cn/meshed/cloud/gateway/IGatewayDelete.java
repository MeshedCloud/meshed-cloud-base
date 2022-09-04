package cn.meshed.cloud.gateway;

import java.io.Serializable;

/**
 * <h1>通用删除接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayDelete {

    /**
     * 删除
     * @param id id
     */
    void deleteById(Serializable id);
}
