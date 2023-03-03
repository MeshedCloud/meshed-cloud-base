package cn.meshed.cloud.cqrs;

/**
 * <h1>查询执行器顶层父类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface QueryExecute<C,R> {

    /**
     * <h1>查询执行器</h1>
     * @param cmd 执行器 {@link C}
     * @return {@link R}
     */
    R execute(C cmd);
}
