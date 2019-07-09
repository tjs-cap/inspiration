package com.bjss.inspiration.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class QuotesTest implements RandomSource{
    private final RandomSource stubRandomSource = this; // 'Self-shunt' stubbing
    private int stubRandomValue ;

    private final Quotes quotes = new Quotes(stubRandomSource);

    @Test
    public void fetchesQuote(){
        stubRandomValue = 0;

        Quote quote = quotes.selectAtRandom();

        assertThat(quote.getText()).isNotBlank();
    }

    @Test
    public void fetchesDifferentQuotesAtRandom(){
        stubRandomValue = 1;
        Quote quoteA = quotes.selectAtRandom();

        stubRandomValue = 1;
        Quote quoteB = quotes.selectAtRandom();

        assertThat(quoteA.getText()).isNotEqualTo(quoteB.getText());
    }

    @Override
    public int next(int upperLimit) {
        return stubRandomValue;
    }
}