package cn.meshed.cloud.code.generate.config;

import cn.meshed.cloud.code.generate.data.TableEntity;
import lombok.Data;

import java.util.List;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */
@Data
public class ProjectConfig {

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 领域名称
     */
    private String domainName;

    /**
     * 领域名称中文名称
     */
    private String domainTip;

    /**
     * 基础包
     */
    private String basePackage = "cn.meshed.cloud";

    /**
     * 版本
     */
    private String version = "1.0";


    /**
     * 作者
     */
    private String author = "Vincent Vic";

    /**
     * 作者
     */
    private String groupId = "cn.meshed.cloud";

    /**
     * 类名称
     */
    private String clazz = "work";

    /**
     * 对应的数据表
     */
    private String tableName;

    /**
     * 对应的数据表
     */
    private String tableIdField;

    /**
     * 对应的数据表
     */
    private String tableIdType;

    /**
     * 数据表映射类
     */
    private List<TableEntity> entitys;


}
