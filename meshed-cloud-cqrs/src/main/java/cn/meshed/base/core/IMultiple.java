package cn.meshed.base.core;


import com.alibaba.cola.dto.PageResponse;

import java.util.List;

/**
 * <h1>通用批量增删改查</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IMultiple<S, V, O, D, R>
        extends IPageList<S, PageResponse<V>>, IBatchSave<O, R>, IBatchUpdate<O, R>, IDelete<List<D>, R> {
}
