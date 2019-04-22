# SpringCloudInAction
SpringCloud相关组件（Eureka、Zuul、Ribbon）学习项目

## 相关源码介绍
1. eureka-server:服务注册中心， 监控 `localhost:8761` 进行注册服务和发现服务。
2. zuul-api-gateway:API网关， 监听 `localhost:8083` 进行相关API调用。 
3. services-node-1:微服务节点1， 直接访问 `localhost:8081/node1/hello` 返回node1节点问候。 
4. services-node-2:微服务节点2， 直接访问 `localhost:8082/node2/hey` 返回node2节点问候。

## 运行方式
在每一个子源码包中，运行 `mvn clean package` 打包好 `jar` 文件，然后运行 `java -jar *.jar` ， 或者在源码包中运行 `mvn spring-boot:run` ,来启动。<br>
> **服务启动顺序** :先启动eureka-server, 再启动 zuul-api-gateway, 再启动 services-node-1 和 services-node-2 。

## 试一下
1. 打开 `localhost:8761` ，查看服务监控面板。
2. 打开 `/localhost:8083/services-node1/node1/hello` 获得来自微服务节点1的问候（该请求是发送给API网关之后经过转发得到的）。
3. 同理，打开 `localhost:8083/services-node2/node2/hey` 获得来自微服务节点2的问候。

## End


