package cn.meshed.cloud.gateway;

/**
 * <h1>通用保存接口</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewaySave<T,V> {

    V save(T data);
}
