package cn.meshed.cloud.resources.web.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
@RestController
public @interface RestApi {

    @AliasFor(
        annotation = RestController.class
    )
    String value() default "";


    @AliasFor(
        annotation = RequestMapping.class
    )
    String path() default "";

    String prefix() default "";
}
