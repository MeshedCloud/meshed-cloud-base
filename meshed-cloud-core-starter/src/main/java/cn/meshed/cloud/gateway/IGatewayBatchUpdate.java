package cn.meshed.cloud.gateway;

import java.util.Collection;
import java.util.List;

/**
 * <h1>通用保存接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayBatchUpdate<T,V> {

    /**
     * 批量保存
     * @param datas 保存列表
     * @return
     */
    List<V> batchUpdateById(Collection<T> datas);
}
