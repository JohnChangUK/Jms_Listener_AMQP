package com.johnchang.messagingbus;

import javax.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;

@Builder(toBuilder = true)
public class Trade implements Serializable {

    @NotNull
    private String notional;

    @NotNull
    private Double currency;

    public Trade(String notional, Double currency) {
        this.notional = notional;
        this.currency = currency;
    }

    public Trade() {
    }

    String getNotional() {
        return notional;
    }

    void setNotional(String notional) {
        this.notional = notional;
    }

    Double getCurrency() {
        return currency;
    }

    void setCurrency(Double currency) {
        this.currency = currency;
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    static class SerializationProxy implements Serializable {

        @NotNull
        private String notional;

        @NotNull
        private Double currency;

        private static final long serialVersionUID = 1L;

        SerializationProxy(Trade trade) {
            this.notional = trade.getNotional();
            this.currency = trade.getCurrency();
        }

        private Object readResolve() {
            return new Trade(notional, currency);
        }
    }
}
