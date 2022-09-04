package cn.meshed.cloud.resources.domain.dto;

import java.util.List;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class ResourcesDTO {

    private String name;
    private String description;
    private String uri;
    private String code;

    private String model;

    private String className;
    private String methodName;
    private String requestType;

    private List<ResourcesDTO> resources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public List<ResourcesDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesDTO> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ResourcesDTO{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", uri='" + uri
            + '\'' + ", code='" + code + '\'' + ", model='" + model + '\'' + ", className='" + className + '\''
            + ", methodName='" + methodName + '\'' + ", requestType='" + requestType + '\'' + ", resources=" + resources
            + '}';
    }
}
