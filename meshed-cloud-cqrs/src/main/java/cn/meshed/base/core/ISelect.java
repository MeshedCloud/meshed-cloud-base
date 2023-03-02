package cn.meshed.base.core;

/**
 * <h1>选项查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISelect<P,R> {

    /**
     * <h1>选项查询</h1>
     * @param  {@link P}
     * @return {@link R}
     */
    R select(P param);
}
