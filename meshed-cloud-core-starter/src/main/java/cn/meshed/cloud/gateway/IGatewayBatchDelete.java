package cn.meshed.cloud.gateway;

import java.io.Serializable;
import java.util.Collection;

/**
 * <h1>通用批量删除接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayBatchDelete {

    /**
     * 删除
     * @param ids ids
     */
    void batchDeleteByIds(Collection<Serializable> ids);
}
