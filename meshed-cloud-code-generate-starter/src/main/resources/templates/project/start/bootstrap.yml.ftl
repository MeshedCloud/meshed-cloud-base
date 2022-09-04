server:
  port: ${port!8080}
  servlet:
    context-path: /${moduleName}-${systemName}

spring:
  application:
    name: ${moduleName}-${systemName}
  cloud:
    nacos:
      #服务发现
      discovery:
        enabled: true
        server-addr: 127.0.0.1:8848
        namespace: meshed-cloud
        metadata:
          management:
            context-path: ${r'${server.servlet.context-path}'}/actuator
      #服务配置
      ## nacos 文件名：${r'${spring.application.name}'}- ${r'${spring.profiles.active}'}.${r'${spring.cloud.nacos.config.file-extension}'}
      config:
        enabled: true
        # 配置中心地址
        server-addr: 127.0.0.1:8848
        # 配置文件格式
        file-extension: yaml
        # 服务命名空间
        namespace: meshed-cloud
        #启动刷新
        refresh-enabled: true
        # 支持多个共享 Data Id 的配置，优先级小于extension-configs,自定义 Data Id 配置 属性是个集合
        # 内部由 Config POJO 组成。Config 有 3 个属性，分别是 dataId, group 以及 refresh
        shared-configs[0]:
          data-id: meshed-cloud-common.yaml # 配置文件名-Data Id
          group: DEFAULT_GROUP   # 默认为DEFAULT_GROUP
          refresh: true   # 是否动态刷新，默认为false
        shared-configs[1]:
          data-id: meshed-cloud-mybatis-common.yaml # 配置文件名-Data Id
          group: DEFAULT_GROUP   # 默认为DEFAULT_GROUP
          refresh: true   # 是否动态刷新，默认为false
        shared-configs[2]:
          data-id: meshed-cloud-security.yaml # 配置文件名-Data Id
          group: DEFAULT_GROUP   # 默认为DEFAULT_GROUP
          refresh: true   # 是否动态刷新，默认为false
  profiles:
    active: dev

#开启日志
logging:
  level:
    root: INFO

dubbo:
  protocol:
    name: dubbo
    port: -1
    check: false
  registry:
    address: nacos://${r'${spring.cloud.nacos.config.server-addr}'}
  application:
    name: ${moduleName}-dubbo
    register-consumer: true
  consumer:
    check: false
    timeout: 5000
    retries: 2
  reference:
    check: false
