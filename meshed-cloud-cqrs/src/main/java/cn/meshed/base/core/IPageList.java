package cn.meshed.base.core;

import com.alibaba.cola.dto.PageResponse;

/**
 * <h1>分页查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IPageList<P,R> {

    /**
     * <h1>分页搜索</h1>
     * @param   {@link P} 命令
     * @return {@link R}
     */
    R searchPageList(P param);
}
