package com.johnchang.messagingbus;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.johnchang.messagingbus.TradeEnum.*;

public class TradeTest {

    private Validator validator;
    private Trade btcTrade = new BtcTrade();
    private Set<ConstraintViolation<Trade>> constraintViolations;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        btcTrade = TradeFactory.createTrade(BTC);
        constraintViolations = validator.validate(btcTrade);
    }

    @Test
    public void tradeIsValid() {
        assertThat(constraintViolations.size(), is(0));
    }

    @Test
    public void notionalIsNotNull() {
        Trade btcNotionalIsNull = new BtcTrade().toBuilder().notional(null).currency(null).build();
        Set<ConstraintViolation<Trade>> constraintViolations = validator.validate(btcNotionalIsNull);
        assertThat(constraintViolations.size(), is(2));
        assertThat(constraintViolations.iterator().next().getMessage(), is(equalTo("may not be null")));
    }
}
