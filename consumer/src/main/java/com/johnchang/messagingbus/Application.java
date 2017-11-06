package com.johnchang.messagingbus;

import com.johnchang.messagingbus.TradeConsumer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private static final Log log = LogFactory.getLog(TradeConsumer.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TradeConsumer.class, args);
        log.info("connectionFactory => " + ctx.getBean("rabbitMQConnectionFactory"));
    }
}
