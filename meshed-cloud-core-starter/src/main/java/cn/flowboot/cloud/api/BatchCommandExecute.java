package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

import java.util.List;

/**
 * <h1>命令模式基类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface BatchCommandExecute<T> {

    public Response execute(List<T> cmd);
}
