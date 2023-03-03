package cn.meshed.cloud.core;

/**
 * <h1>详情</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IDetails<C,V> {

    /**
     * 详情
     * @param cmd
     * @return
     */
    V details(C cmd);

}
