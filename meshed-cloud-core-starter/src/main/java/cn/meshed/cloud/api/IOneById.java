package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

/**
 * <h1>通用查询单个对象接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IOneById<T> {

    /**
     * 根据ID查询一个元素
     * @param data
     * @return
     */
    Response getOneById(T data);
}
