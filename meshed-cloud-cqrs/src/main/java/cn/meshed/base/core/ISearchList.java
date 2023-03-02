package cn.meshed.base.core;

/**
 * <h1>搜索列表</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISearchList<P,R> {

    /**
     * <h1>搜索列表</h1>
     * @param  {@link P}
     * @return {@link R}
     */
    R searchList(P param);
}
