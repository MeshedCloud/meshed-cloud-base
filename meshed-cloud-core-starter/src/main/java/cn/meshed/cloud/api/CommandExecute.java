package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

/**
 * <h1>命令模式基类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface CommandExecute<T> {

    public Response execute(T cmd);
}
