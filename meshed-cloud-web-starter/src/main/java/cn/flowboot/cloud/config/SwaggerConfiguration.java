package cn.meshed.cloud.config;

import cn.meshed.cloud.properties.Knife4jProperties;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */

@RequiredArgsConstructor
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {

    private final Knife4jProperties knife4jProperties;
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(apis())
//            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        String descHtml = "<div style='%s'>%s</div>";
        String description = String.format(descHtml, knife4jProperties.descriptionStyle, knife4jProperties.description);
        return new ApiInfoBuilder()
            .title(knife4jProperties.getTitle())
            .description(description)
            .license("署名-非商用-相同方式共享 4.0转载请保留原文链接及作者")
            .termsOfServiceUrl(knife4jProperties.getServiceUrl())
            .contact(new Contact(knife4jProperties.getAuthor(),
                knife4jProperties.getUrl(), knife4jProperties.getAuthor()))
            .version(knife4jProperties.getVersion())
            .build();
    }

    private Predicate<RequestHandler> apis() {
//        String basePackage = knife4jProperties.getBasePackage();
        // 默认通过扫描`ApiOperation`如果配置了包扫描路径，使用配置的包扫描路径
        return withClassAnnotation(Api.class);
    }


    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                    .filter(mapping -> mapping.getPatternParser() == null)
                    .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }

            @SuppressWarnings("unchecked")
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
}

