- Using JMS as an abstraction over an AMQP, such as RabbitMQ. 
- This is to support maintenance of code, by allowing engineers to only change the AMQP, such as RabbitMQ to ActiveMQ or Kafka.
- This reinforces the idea of 'Loose Coupling' and 'High Cohesion' 

Given: That the application needs updates,
When: The app has subscribed to the JMS Messaging Queue, 
Then: The app is able to receive messages and updates from the Messaging Queue

Given: that information needs to be sent to the Bus,
When: The app receives messages and updates from JMS Messaging Queue,
Then: The data is sent to the Bus
