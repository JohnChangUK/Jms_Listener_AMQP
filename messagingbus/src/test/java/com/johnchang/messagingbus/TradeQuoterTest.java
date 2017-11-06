package com.johnchang.messagingbus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Session;
import java.util.*;

import static com.johnchang.messagingbus.Trade.*;
import static com.johnchang.messagingbus.TradeEnum.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TradeQuoterTest {

    private Trade btc;
    private Trade neo;
    private Trade eth;
    private SerializationProxy serializeBtc;
    private SerializationProxy serializeNeo;
    private SerializationProxy serializeEth;

    private MessageCreator neoMessageCreator;
    private MessageCreator ethereumMessageCreator;

    @InjectMocks
    private TradeQuoter tradeQuoter = new TradeQuoter();

    @Mock
    private MessageCreator btcMessageCreator;

    @Mock
    private MessageCreator ethMessageCreator;

    @Mock
    private Map<SerializationProxy, Double> lastTrade;

    @Mock
    private Session session;

    public TradeQuoterTest() throws JMSException {
    }

    @Before
    public void setUp() {
//        lastTrade = new HashMap<>();
//        btc = TradeFactory.createTrade(BTC);
//        neo = TradeFactory.createTrade(ETH);
//        eth = TradeFactory.createTrade(NEO);
//        serializeBtc = new Trade.SerializationProxy(btc);
//        serializeNeo = new Trade.SerializationProxy(neo);
//        serializeEth = new Trade.SerializationProxy(eth);
//        btcMessageCreator = tradeQuoter.getMessageCreator(serializeBtc);
    }

    @Test
    public void producerTest() throws JMSException {
       // verify(ethMessageCreator, times(1)).createMessage(session);
    }
}
