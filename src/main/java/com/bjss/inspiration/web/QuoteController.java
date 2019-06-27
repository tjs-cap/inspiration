package com.bjss.inspiration.web;

import com.bjss.inspiration.domain.Quote;
import com.bjss.inspiration.domain.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class QuoteController {

    private final Quotes quotes;

    @Autowired
    public QuoteController( final Quotes quotes ) {
        this.quotes = quotes;
    }

    @GetMapping(path = "/api/quote")
    public Quote randomQuote() {
        return quotes.selectAtRandom();
    }
}
