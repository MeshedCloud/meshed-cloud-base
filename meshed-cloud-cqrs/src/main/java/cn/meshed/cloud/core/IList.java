package cn.meshed.cloud.core;

/**
 * <h1>分页查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IList<P,R> {

    /**
     * <h1>分页搜索</h1>
     * @param  {@link P}
     * @return {@link R}
     */
    R searchList(P param);
}
