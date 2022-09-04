package cn.meshed.cloud.resources.sniffer.impl;

import cn.meshed.cloud.resources.constant.ResourcesConstant;
import cn.meshed.cloud.resources.domain.dto.ResourcesDTO;
import cn.meshed.cloud.resources.sniffer.ResourcesSnifferService;
import cn.meshed.cloud.resources.web.annotations.OpenApi;
import cn.meshed.cloud.resources.web.annotations.RestApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Service
public class ResourcesSnifferServiceImpl implements ResourcesSnifferService {



    @Async
    @Override
    public void handlerResources(Map<String, Object> beansWithAnnotation) {
        List<ResourcesDTO> resources = getResources(beansWithAnnotation);
        resources.forEach(resourcesDTO -> {
            System.out.println(resourcesDTO);
            resourcesDTO.getResources().forEach(System.out::println);
        });
    }

    private List<ResourcesDTO> getResources(Map<String, Object> beansWithAnnotation) {
        List<ResourcesDTO> resources = beansWithAnnotation.entrySet().stream().map(bean -> {

            Object value = bean.getValue();
            if (value == null) {
                return null;
            }
            Class<?> aClass = value.getClass();
            //获取第一层
            ResourcesDTO resourcesRoot = getResourcesRoot(aClass);

            //获取方法接口
            Method[] methods = aClass.getMethods();
            if (methods.length <= 0) {
                return resourcesRoot;
            }
            //过滤出RESTful有效方法,其他方法不需要
            List<Method> collect =
                Arrays.stream(methods).filter(this::isRESTful).collect(Collectors.toList());

            List<ResourcesDTO> resourcesDTOList = collect.stream()
                .map(method -> getResourcesItem(resourcesRoot.getUri(),aClass, method))
                .collect(Collectors.toList());
            resourcesRoot.setResources(resourcesDTOList);

            return resourcesRoot;
        }).filter(Objects::nonNull).collect(Collectors.toList());

        return resources;
    }

    /**
     * 具体接口
     * @param aClass
     * @param method
     * @return
     */
    private ResourcesDTO getResourcesItem(String prefix,Class<?> aClass, Method method) {
        ResourcesDTO resourcesDTO = new ResourcesDTO();
        //获取路径和类型
        handlerUriAndType(method, resourcesDTO);
        //加上前缀
        if (StringUtils.isNotBlank(prefix)){
            String path = prefix + resourcesDTO.getUri();
            path = removeUriSlash(path);
            resourcesDTO.setUri(path);
        }
        //将路径转换为权限字符
        String code = resourcesDTO.getUri();
        if (StringUtils.isNotBlank(code)){
            code = code.replaceAll("\\*","")
                .replaceAll("/",":");
        }

        if (StringUtils.isNotBlank(code) && code.startsWith(":")){
            code = code.substring(1);
        }

        if (StringUtils.isNotBlank(code) && code.endsWith(":")){
            code = code.substring(0,code.length()-1);
        }

        resourcesDTO.setCode(code);
        //获取类名字和方法名字
        resourcesDTO.setClassName(aClass.getSimpleName());
        resourcesDTO.setMethodName(method.getName());
        //获取名字和详情
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        if (apiOperation != null){
            resourcesDTO.setName(apiOperation.value());
        }

        //优先级 : 类 > 方法
        //如果类是开放的不需要判断方法
        if (aClass.isAnnotationPresent(OpenApi.class)){
            resourcesDTO.setModel(ResourcesConstant.REST_OPENAPI_MODEL);
        } else if (method.isAnnotationPresent(OpenApi.class)){
            resourcesDTO.setModel(ResourcesConstant.REST_OPENAPI_MODEL);
        }{
            resourcesDTO.setModel(ResourcesConstant.REST_AUTH_MODEL);
        }

        return resourcesDTO;
    }

    /**
     * 获取控制器的资源对象
     * @param aClass
     * @return
     */
    private ResourcesDTO getResourcesRoot(Class<?> aClass) {
        RestApi restApi = aClass.getAnnotation(RestApi.class);
        //封装数据
        ResourcesDTO resourcesRoot = new ResourcesDTO();
        resourcesRoot.setClassName(aClass.getSimpleName());
        StringBuilder builder = new StringBuilder("/");
        if (StringUtils.isNotBlank(restApi.prefix())){
            builder.append(restApi.prefix()).append("/");
        }
        String path = builder.append(restApi.path()).append("/").toString();
        path = removeUriSlash(path);
        resourcesRoot.setUri(path);
        Api api = aClass.getAnnotation(Api.class);
        String tag = api.tags().length > 0 ? api.tags()[0]: null;
        resourcesRoot.setName(tag);

        //如果是开放接口就不需要登入
        if (aClass.isAnnotationPresent(OpenApi.class)){
            resourcesRoot.setModel(ResourcesConstant.REST_OPENAPI_MODEL);
        } else {
            resourcesRoot.setModel(ResourcesConstant.REST_AUTH_MODEL);
        }

        return resourcesRoot;
    }

    private void handlerUriAndType(Method method, ResourcesDTO resourcesDTO) {
        boolean flag = method.isAnnotationPresent(GetMapping.class);
        if (flag){
            GetMapping mapping = method.getAnnotation(GetMapping.class);
            hanlerMapping(resourcesDTO, mapping.value(),HttpMethod.GET.name());
            return;
        }
        flag = method.isAnnotationPresent(PostMapping.class);
        if (flag){
            PostMapping mapping = method.getAnnotation(PostMapping.class);
            hanlerMapping(resourcesDTO, mapping.value(),HttpMethod.POST.name());
            return;
        }

        flag = method.isAnnotationPresent(PutMapping.class);
        if (flag){
            PutMapping mapping = method.getAnnotation(PutMapping.class);
            hanlerMapping(resourcesDTO, mapping.value(),HttpMethod.PUT.name());
            return;
        }

        flag = method.isAnnotationPresent(DeleteMapping.class);
        if (flag){
            DeleteMapping mapping = method.getAnnotation(DeleteMapping.class);
            hanlerMapping(resourcesDTO, mapping.value(),HttpMethod.GET.name());
            return;
        }
        flag = method.isAnnotationPresent(PatchMapping.class);
        if (flag){
            PatchMapping mapping = method.getAnnotation(PatchMapping.class);
            hanlerMapping(resourcesDTO, mapping.value(),HttpMethod.PATCH.name());
        }
    }

    private void hanlerMapping(ResourcesDTO resourcesDTO, String[] value,String httpMethod) {
        Optional.of(value)
            .filter(val-> val.length >=1)
            .ifPresent(val -> {
                String uri = val[0].replaceAll("\\{.*\\}","**");
                //处理路径变量情况
                resourcesDTO.setUri(uri);
            });
        resourcesDTO.setRequestType(httpMethod);
    }

    private boolean isRESTful(Method method) {
        boolean flag = method.isAnnotationPresent(GetMapping.class);
        if (flag){
            return true;
        }
        flag = method.isAnnotationPresent(PostMapping.class);
        if (flag){
            return true;
        }

        flag = method.isAnnotationPresent(PutMapping.class);
        if (flag){
            return true;
        }

        flag = method.isAnnotationPresent(DeleteMapping.class);
        if (flag){
            return true;
        }
        flag = method.isAnnotationPresent(PatchMapping.class);
        if (flag){
            return true;
        }
        return false;
    }

    /**
     * 移除URI 多余的斜杠 “/”
     * @param uri
     * @return
     */
    public String removeUriSlash(String uri){
        return uri.replaceAll("/{2,10}","/");
    }



}
