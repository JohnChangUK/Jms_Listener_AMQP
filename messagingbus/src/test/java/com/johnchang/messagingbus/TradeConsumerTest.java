//package com.johnchang.messagingbus;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.listener.DefaultMessageListenerContainer;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TradeConsumerTest {
//    @InjectMocks
//    private TradeConsumer tradeconsumer = new TradeConsumer();
//
//    private DefaultMessageListenerContainer btcJmsListener = new DefaultMessageListenerContainer();
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
////    @Test
////    public void btcJmsListener() throws Exception {
////        btcJmsListener.setDestinationName("btc");
////        verify()
////    }
//
//}