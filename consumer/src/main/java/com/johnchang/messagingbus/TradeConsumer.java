package com.johnchang.messagingbus;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;
import java.io.*;

import org.springframework.stereotype.Component;

@Component
public class TradeConsumer {
    private static final Log log = LogFactory.getLog(TradeConsumer.class);

    @Bean
    ConnectionFactory rabbitMQConnectionFactory() {
        return new RMQConnectionFactory();
    }

    @Bean
    public DefaultMessageListenerContainer btcJmsListener(ConnectionFactory connectionFactory) {

        DefaultMessageListenerContainer btcJmsListener = new DefaultMessageListenerContainer();
        btcJmsListener.setConnectionFactory(connectionFactory);
        btcJmsListener.setDestinationName("btc");
        btcJmsListener.setPubSubDomain(true);

        MessageListenerAdapter btcAdapter = new MessageListenerAdapter(new ReceiverTrade());
        btcAdapter.setDefaultListenerMethod("receiveMessageBitcoin");

        btcJmsListener.setMessageListener(btcAdapter);
        return btcJmsListener;
    }

    @Bean
    public DefaultMessageListenerContainer neoJmsListener(ConnectionFactory connectionFactory) {

        DefaultMessageListenerContainer neoJmsListener = new DefaultMessageListenerContainer();
        neoJmsListener.setConnectionFactory(connectionFactory);
        neoJmsListener.setDestinationName("neo");
        neoJmsListener.setPubSubDomain(true);

        MessageListenerAdapter neoAdapter = new MessageListenerAdapter(new ReceiverTrade());
        neoAdapter.setDefaultListenerMethod("receiveMessageNeo");

        neoJmsListener.setMessageListener(neoAdapter);
        return neoJmsListener;
    }

    @Bean
    public DefaultMessageListenerContainer ethJmsListener(ConnectionFactory connectionFactory) {

        DefaultMessageListenerContainer ethJmsListener = new DefaultMessageListenerContainer();
        ethJmsListener.setConnectionFactory(connectionFactory);
        ethJmsListener.setDestinationName("ethereum");
        ethJmsListener.setPubSubDomain(true);

        MessageListenerAdapter ethAdapter = new MessageListenerAdapter(new ReceiverTrade());
        ethAdapter.setDefaultListenerMethod("receiveMessageEth");

        ethJmsListener.setMessageListener(ethAdapter);
        return ethJmsListener;
    }

    static class ReceiverTrade {

        void receiveMessageBitcoin(Trade trade) throws IOException, ClassNotFoundException {
            log.info("Deserialized Bitcoin: " + trade +
                    "trade Currency is: $" + trade.getCurrency());
        }

        void receiveMessageNeo(Trade trade) {
            log.info("Deserialized Neo: " + trade +
                    "trade Currency is: $" + trade.getCurrency());
        }

        void receiveMessageEth(Trade trade) {
            log.info("Deserialized Ethereum: " + trade
            + "trade Currency is: $" + trade.getCurrency());
        }
    }
}
