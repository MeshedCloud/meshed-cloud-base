package cn.meshed.base.core;

import com.alibaba.cola.exception.SysException;

/**
 * <h1>分页查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IUpdate<C,R> {

    /**
     * <h1>更新</h1>
     * @param  {@link C}
     * @return {@link R}
     */
    default R update(C cmd){
        throw new SysException("System not implemented");
    }
}
