package cn.meshed.cloud.core;

/**
 * <h1>查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IQuery<C,R> {

    /**
     * 查询
     * @param cmd 参数
     * @return {@link R}
     */
    R query(C cmd);

}
