package cn.meshed.cloud.core;

/**
 * <h1>删除对象</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IDelete<C,R> {

    /**
     * <h1>删除对象</h1>
     * @param  {@link C}
     * @return {@link R}
     */
    R delete(C cmd);
}
