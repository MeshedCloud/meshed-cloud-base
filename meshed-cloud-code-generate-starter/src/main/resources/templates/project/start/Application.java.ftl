package ${classPackage};


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* <h1>${domainTip}启动类</h1>
*
* @author Vincent Vic
* @version 1.0
*/
@EnableDubbo(scanBasePackages = {"${classPackage}.${domainName}.dubbo.api","${classPackage}.${domainName}.dubbo"})
@SpringBootApplication(scanBasePackages = {"${classPackage}","com.alibaba.cola"})
public class ${Class}Application {

    public static void main(String[] args) {
        SpringApplication.run(${Class}Application.class,args);
    }
}
