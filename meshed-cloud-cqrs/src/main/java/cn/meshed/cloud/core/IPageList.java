package cn.meshed.cloud.core;

/**
 * <h1>分页查询</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IPageList<P,R> {

    /**
     * <h1>分页列表</h1>
     * @param pageQry 分页查询 {@link P}
     * @return {@link R}
     */
    R searchPageList(P pageQry);
}
