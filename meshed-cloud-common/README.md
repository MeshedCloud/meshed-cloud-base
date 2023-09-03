# meshed-cloud-common

推送制品库
```shell
mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -DskipTests
```

[![Meshed-Cloud-Base](https://github-readme-stats.vercel.app/api/pin/?username=meshed-cloud&repo=meshed-cloud-base)](https://github.com/meshed-cloud)



## 通用组件

```xml
<dependency>
    <groupId>cn.meshed.cloud</groupId>
    <artifactId>meshed-cloud-common</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

| 工具类             | 解释            |
|-----------------|---------------|
| AssertUtils     | 断言工具，如果非真抛出异常 |
| Base64Converter | Base64加密工具    |
| GzipUtils       | 压缩工具          |
| CopyUtils       | Bean拷贝工具      |
| IdUtils         | UUID生成工具      |
| ResultUtils     | 返回工具          |

## 常量

```xml
<dependency>
    <groupId>cn.meshed.cloud</groupId>
    <artifactId>meshed-cloud-constant</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

[详见源码](https://github.com/meshed-cloud/meshed-cloud-base/tree/master/meshed-cloud-constant)


## 标准化

项目为了简化业务开发过程中常规接口定义，抽象设计CURD的接口，用户可以根据业务需求单独继承和继承整体，减少接口的定义的开发。同时为CQRS显式化事件提供了操作的顶层接口设计

```xml
<dependency>
    <groupId>cn.meshed.cloud</groupId>
    <artifactId>meshed-cloud-cqrs</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
目录
```shell
├─ability
│      Ability
│      BaseAbility
│      CommandAbility
│      ListAbility
│      PageAbility
│      QueryAbility
├─core
│      IBatchDelete
│      IBatchSave
│      IBatchUpdate
│      IDelete
│      IDetails
│      IList
│      IMultiple
│      IPageList
│      IQuery
│      ISave
│      ISearchList
│      ISelect
│      ISingle
│      IUpdate
├─cqrs
│      Command
│      CommandExecute
│      EventExecute
│      Query
│      QueryExecute
└─gateway
        BaseGateway
        CommandGateway
        Gateway
        ListGateway
        PageGateway
        QueryGateway
```

## 传输模型

主要依赖COLA DTO,扩展MQ事件Event和安全事件SecurityEvent父类，包装提示包装结构TipResponse

```xml
<dependency>
    <groupId>cn.meshed.cloud</groupId>
    <artifactId>meshed-cloud-dto</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

[详见源码](https://github.com/meshed-cloud/meshed-cloud-base/tree/master/meshed-cloud-dto)

## 异常

主要依赖COLA DTO，扩展安全类目异常AuthenticationException，SysSecurityException

```xml
<dependency>
    <groupId>cn.meshed.cloud</groupId>
    <artifactId>meshed-cloud-exception</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

[详见源码](https://github.com/meshed-cloud/meshed-cloud-base/tree/master/meshed-cloud-exception)

## 序列化

基于ObjectMapper提供JsonUtils工具

```xml
<dependency>
    <groupId>cn.meshed.cloud</groupId>
    <artifactId>meshed-cloud-json</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

[详见源码](https://github.com/meshed-cloud/meshed-cloud-base/tree/master/meshed-cloud-json)

