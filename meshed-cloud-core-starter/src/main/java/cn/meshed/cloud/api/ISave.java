package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

/**
 * <h1>通用保存接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISave<T> {

    Response save(T data);
}
