package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

/**
 * <h1>通用删除接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IDelete<T> {

    /**
     * 删除
     * @param cmd 删除数据
     */
    Response delete(T cmd);
}
