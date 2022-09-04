package cn.meshed.cloud.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <h1>knife4j 配置</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Data
@Component
@ConfigurationProperties(value = "knife4j")
public class Knife4jProperties {

    /** 标题 */
    public String title = "meshed Cloud";

    /** 详情 */
    public String description = "meshed Cloud doc";
    /** 详情样式 */
    public String descriptionStyle = "font-size:14px;color:red;";

    /** 服务网址 */
    public String serviceUrl;

    /** 版本*/
    public String version = "1.0";

    /** 作者 */
    public String author = "Vincent Vic";
    /** 网址 */
    public String url = "https://github.com/Vincent-Vic/meshed-cloud";
    /** 邮箱 */
    public String email = "vic.coding@gmail.com";

}
