<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>meshed-cloud</artifactId>
        <groupId>cn.meshed.cloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>${systemName}-${moduleName}</artifactId>
    <packaging>pom</packaging>
    <description></description>
    <modules>
        <module>${systemName}-${moduleName}-start</module>
        <module>${systemName}-${moduleName}-app</module>
        <module>${systemName}-${moduleName}-domain</module>
        <module>${systemName}-${moduleName}-infrastructure</module>
        <module>${systemName}-${moduleName}-adapter</module>
    </modules>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>${groupId}</groupId>
                <artifactId>${systemName}-${moduleName}-adapter</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>
            <dependency>
                <groupId>${groupId}</groupId>
                <artifactId>${systemName}-${moduleName}-app</artifactId>
                <version>${r'${project.version}'}</version>
                <exclusions>
                    <exclusion>
                        <groupId>${groupId}</groupId>
                        <artifactId>${systemName}-${moduleName}-domain</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>${groupId}</groupId>
                <artifactId>${systemName}-${moduleName}-domain</artifactId>
                <version>${r'${project.version}'}</version>
            </dependency>
            <dependency>
                <groupId>${groupId}</groupId>
                <artifactId>${systemName}-${moduleName}-infrastructure</artifactId>
                <version>${r'${project.version}'}</version>
                <exclusions>
                    <exclusion>
                        <groupId>${groupId}</groupId>
                        <artifactId>${systemName}-${moduleName}-domain</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>