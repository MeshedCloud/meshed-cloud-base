package cn.meshed.cloud.gateway;

import com.alibaba.cola.dto.PageQuery;

/**
 * <h1>简单网关</h1>
 * C: 命令数据（新增或修改数据）,Q（查询参数）,V（返回数据【列表】）,I （id类型）
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISimpleGateway<C,Q extends PageQuery,V,I extends Comparable> extends IGateway<C,Q,V,V> {
}
