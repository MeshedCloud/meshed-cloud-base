package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IUpdateState<T> {

    /**
     * 切换状态
     *
     * @param id ID
     */
    Response updateState(T id);

}