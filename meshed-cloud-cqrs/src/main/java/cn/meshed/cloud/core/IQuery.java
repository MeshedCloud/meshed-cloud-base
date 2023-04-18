package cn.meshed.cloud.core;

/**
 * <h1>查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IQuery<Q,R> {

    /**
     * <h2>查询</h2>
     *
     * @param qyr 查询参数
     * @return {@link R}
     */
    R query(Q qyr);

}
