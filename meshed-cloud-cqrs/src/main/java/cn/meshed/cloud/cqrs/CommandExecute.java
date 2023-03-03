package cn.meshed.cloud.cqrs;

/**
 * <h1>执行器顶层父类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface CommandExecute<C,R> {

    /**
     * <h1>执行器</h1>
     * @param cmd 执行器 {@link C}
     * @return {@link R}
     */
    R execute(C cmd);
}
