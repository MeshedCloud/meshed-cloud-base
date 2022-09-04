package cn.meshed.cloud.api;

import com.alibaba.cola.dto.PageQuery;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IApi<C,D,QL extends PageQuery,QI> extends IPageList<QL>,
        ISave<C>,IUpdate<C>,IDelete<D>, IOneById<QI>{
}
