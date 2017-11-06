package com.johnchang.messagingbus;

import static com.johnchang.messagingbus.TradeEnum.*;

class TradeFactory {

    static Trade createTrade(TradeEnum type) {

        if (type == BTC) {
            return new BtcTrade();
        } else if (type == NEO) {
            return new NeoTrade();
        } else if (type == ETH) {
            return new EthTrade();
        } else {
            return null;
        }
    }
}
