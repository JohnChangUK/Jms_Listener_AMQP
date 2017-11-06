package com.johnchang.messagingbus;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class TradeConsumerTest {

    private TradeConsumer tradeConsumer;

    @Before
    public void setUp() {
        tradeConsumer = new TradeConsumer();
        TradeConsumer.ReceiverTrade receiver = new TradeConsumer.ReceiverTrade();
        initMocks(this);
    }

    @Bean
    ConnectionFactory rabbitMQConnectionFactory() {
        return new RMQConnectionFactory();
    }

    @Test
    public void WHEN_bean_jmsListener_is_called_THEN_messageListenerContainer_is_returned() {
//        tradeConsumer.btcJmsListener(rabbitMQConnectionFactory());
        assertThat(tradeConsumer.btcJmsListener(rabbitMQConnectionFactory()), is(instanceOf(DefaultMessageListenerContainer.class)));
    }
}