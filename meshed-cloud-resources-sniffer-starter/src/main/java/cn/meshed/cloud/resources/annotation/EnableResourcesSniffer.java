package cn.meshed.cloud.resources.annotation;

import cn.meshed.cloud.resources.sniffer.ResourcesSnifferConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ResourcesSnifferConfiguration.class})
public @interface EnableResourcesSniffer {
}
