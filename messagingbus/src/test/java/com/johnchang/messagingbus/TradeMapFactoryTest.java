package com.johnchang.messagingbus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TradeMapFactoryTest {

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Mock
    private Trade.SerializationProxy serializationProxy1;

    @Mock
    private Trade.SerializationProxy serializationProxy2;

    @Mock
    private Trade.SerializationProxy serializationProxy3;

    @Mock
    private Random rand;

    @Test
    public void when_proxy_is_given_then_createMap() {
        when(rand.nextInt(anyInt())).thenReturn(1, 2,3);
        TradeMapFactory tradeMapFactory = new TradeMapFactory(serializationProxy1, serializationProxy2, serializationProxy3, rand);
        Map<Trade.SerializationProxy, Double> actualMap = tradeMapFactory.createMap();
        assertEquals(actualMap.get(serializationProxy1), (Double) 1.0);
        assertEquals(actualMap.get(serializationProxy2), (Double) 2.0);
        assertEquals(actualMap.get(serializationProxy3), (Double) 3.0);
    }
}
