package com.johnchang.messagingbus;

import com.johnchang.messagingbus.Trade.SerializationProxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class TradeMapFactory {

    private static Map<SerializationProxy, Double> lastTrade = new HashMap<>();

    private final SerializationProxy serializeBtc;
    private final SerializationProxy serializeNeo;
    private final SerializationProxy serializeEth;
    private final Random rand;

    TradeMapFactory(SerializationProxy serializeBtc, SerializationProxy serializeNeo,
                    SerializationProxy serializeEth, Random rand) {
        this.serializeBtc = serializeBtc;
        this.serializeNeo = serializeNeo;
        this.serializeEth = serializeEth;
        this.rand = rand;
    }

    Map<SerializationProxy, Double> createMap() {
        lastTrade.put(serializeBtc, (double) rand.nextInt(1200 * 5));
        lastTrade.put(serializeNeo, (double) rand.nextInt(69 * 4));
        lastTrade.put(serializeEth, (double) rand.nextInt(340 * 2));
        return lastTrade;
    }
}
