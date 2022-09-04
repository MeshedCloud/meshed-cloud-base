package cn.meshed.cloud.resources.sniffer;

import cn.meshed.cloud.resources.web.annotations.RestApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;


/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ResourcesSnifferConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private final ResourcesSnifferService resourcesSnifferService;

    @Value("${resources.sniffer.enable:true}")
    private Boolean enable;

    public ResourcesSnifferConfiguration(ResourcesSnifferService resourcesSnifferService) {
        this.resourcesSnifferService = resourcesSnifferService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //未开启拦截
        if (!enable){
            return;
        }
        ApplicationContext applicationContext = event.getApplicationContext();
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RestApi.class);
        resourcesSnifferService.handlerResources(beansWithAnnotation);
    }
}
