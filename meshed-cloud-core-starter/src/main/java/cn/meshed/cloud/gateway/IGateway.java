package cn.meshed.cloud.gateway;

import com.alibaba.cola.dto.PageQuery;

/**
 * <h1>网关</h1>
 * C: 命令数据（新增或修改数据）,Q（查询参数）,V（返回数据【列表】）,VI（返回数据【项】）,I （id类型）
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGateway<C,Q extends PageQuery,V,VI> extends IGatewaySaveUpdate<C,VI>,
        IGatewayBatchSaveUpdate<C,VI>,
        IGatewayPageList<Q,V>,
        IGatewayOneById<VI>,
        IGatewayDelete,
        IGatewayBatchDelete{
}
