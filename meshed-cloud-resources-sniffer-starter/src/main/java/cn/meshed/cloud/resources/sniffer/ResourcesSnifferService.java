package cn.meshed.cloud.resources.sniffer;

import java.util.Map;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface ResourcesSnifferService {

    void handlerResources(Map<String, Object> beansWithAnnotation);
}
