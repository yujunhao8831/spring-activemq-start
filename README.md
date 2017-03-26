# spring-activemq-start
## Spring ActiveMq 生产消费者示例项目

### activemq-producer(生产者项目)

MailQueueMessageListenerTest 启动后进行监听

### activemq-consumer(消费者项目)
MailServiceTest 方法进行测试发送消息到队列


#### 配置文件在 resources/properties 目录下
 + activemq.url=tcp://127.0.0.1:61616
 + activemq.password=admin
 + activemq.username=admin
 + activemq.queue.name=activemq.demo
#### 依赖ActiveMQ服务