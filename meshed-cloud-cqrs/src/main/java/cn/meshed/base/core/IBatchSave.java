package cn.meshed.base.core;

/**
 * <h1>批量保存对象</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IBatchSave<C,R> {

    /**
     * <h1>批量保存对象</h1>
     * @param  {@link C}
     * @return {@link R}
     */
    R saveBatch(C cmd);
}
