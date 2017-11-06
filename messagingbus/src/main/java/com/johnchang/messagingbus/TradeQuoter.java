package com.johnchang.messagingbus;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.*;

import com.johnchang.messagingbus.Trade.SerializationProxy;

import static com.johnchang.messagingbus.TradeEnum.*;

@SpringBootApplication
@EnableScheduling
public class TradeQuoter {
    private static final Log log = LogFactory.getLog(TradeQuoter.class);

    private Trade btc = TradeFactory.createTrade(BTC);
    private Trade neo = TradeFactory.createTrade(ETH);
    private Trade eth = TradeFactory.createTrade(NEO);
    private SerializationProxy serializeBtc = new SerializationProxy(btc);
    private SerializationProxy serializeNeo = new SerializationProxy(neo);
    private SerializationProxy serializeEth = new SerializationProxy(eth);
    private Random rand = new Random();


    private TradeMapFactory tradeMapFactory = new TradeMapFactory(serializeBtc, serializeNeo,
            serializeEth, rand);

    private MessageCreator btcMessageCreator = getMessageCreator(serializeBtc);
    private MessageCreator neoMessageCreator = getMessageCreator(serializeNeo);
    private MessageCreator ethereumMessageCreator = getMessageCreator(serializeEth);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Bean
    ConnectionFactory rabbitMQConnectionFactory() {
        return new RMQConnectionFactory();
    }

    @Scheduled(fixedRate = 3000L)
    public void publishTradetoConsumer() {

        jmsTemplate.send("btc", btcMessageCreator);
        jmsTemplate.send("neo", neoMessageCreator);
        jmsTemplate.send("ethereum", ethereumMessageCreator);
    }

    MessageCreator getMessageCreator(SerializationProxy trade) {
        return new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(trade);
            }
        };
    }

//    [TradeMapFactory] <- [TraderWriter]
//
//    class TraderWriter {
//        TradeMapFactory tradeMapFactory;
//
//        public void write("filename.txt", trade) {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
//            objectOutputStream.writeObject(trade);
//            objectOutputStream.close();
//        }
//    }

//    private static void serialization(String file, Map<SerializationProxy, Double> trade) throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
//        objectOutputStream.writeObject(trade);
//        objectOutputStream.close();
//    }
//
//    private void serializeTrade() {
//        try {
//            TradeQuoter.serialization("trade.txt", lastTrade);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}