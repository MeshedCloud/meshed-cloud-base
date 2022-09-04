package cn.meshed.cloud.gateway;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface IGatewayUpdateState<T> {

    /**
     * 切换状态
     *
     * @param id ID
     */
    void updateState(T id);

}
