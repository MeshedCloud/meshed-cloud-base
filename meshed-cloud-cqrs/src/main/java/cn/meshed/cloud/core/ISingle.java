package cn.meshed.cloud.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.exception.SysException;

/**
 * <h1>通用单一增删改查</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISingle<S, V, O, D, R>
        extends IPageList<S, PageResponse<V>>, ISave<O, R>, IUpdate<O, R>, IDelete<D, R>, IQuery<D, R> {

    /**
     * <h1>删除对象</h1>
     *
     * @param cmd {@link D} 命令
     * @return {@link R}
     */
    @Override
    default R delete(D cmd){
        throw new SysException("System not implemented");
    }

    /**
     * <h1>分页搜索</h1>
     *
     * @param param {@link S} 参数
     * @return {@link R}
     */
    @Override
    default PageResponse<V> searchPageList(S param){
        throw new SysException("System not implemented");
    }

    /**
     * <h1>保存对象</h1>
     *
     * @param cmd {@link O} 命令
     * @return {@link R}
     */
    @Override
    default R save(O cmd){
        throw new SysException("System not implemented");
    }

    /**
     * <h1>更新</h1>
     *
     * @param cmd {@link O} 命令
     * @return {@link R}
     */
    @Override
    default R update(O cmd) {
        return IUpdate.super.update(cmd);
    }

    /**
     *  <h1>查询</h1>
     *
     * @param cmd 参数
     * @return {@link V}
     */
    @Override
    default R query(D cmd){
        throw new SysException("System not implemented");
    }
}
