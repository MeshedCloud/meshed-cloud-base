package cn.meshed.cloud.core;

/**
 * <h1>批量更新对象</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IBatchUpdate<C,R> {

    /**
     * <h1>批量更新对象</h1>
     * @param  {@link C}
     * @return {@link R}
     */
    R updateBatch(C cmd);
}
