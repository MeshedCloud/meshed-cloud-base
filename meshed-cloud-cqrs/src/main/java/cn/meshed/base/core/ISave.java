package cn.meshed.base.core;

/**
 * <h1>保存对象</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISave<C,R> {

    /**
     * <h1>保存对象</h1>
     * @param  {@link C}
     * @return {@link R}
     */
    R save(C cmd);
}
