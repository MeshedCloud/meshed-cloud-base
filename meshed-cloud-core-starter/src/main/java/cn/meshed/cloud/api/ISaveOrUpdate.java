package cn.meshed.cloud.api;

import com.alibaba.cola.dto.Response;

/**
 * <h1>通用更新或新增</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ISaveOrUpdate<T> {

    /**
     * 保存或更新
     * @param cmd 数据
     * @return
     */
    Response saveOrUpdate(T cmd);
}
