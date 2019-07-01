package com.bjss.inspiration.integration;

import com.bjss.inspiration.domain.Quote;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringBootCucumberIntegration {
    private static final String INSPIRE_ENDPOINT = "/inspire";

    @LocalServerPort
    protected int port;

    protected RestTemplate restTemplate = new RestTemplate();

    private String path = INSPIRE_ENDPOINT;
    private ResponseEntity<String> homePageHtmlResponse;
    private ResponseEntity<Quote> quoteResponse;

    protected void requestHomePageHtml() {
        homePageHtmlResponse = restTemplate.getForEntity(getHomePageUri(), String.class);
    }

    private String getHomePageUri() {
        return "http://localhost:" + port + path;
    }

    protected int getHomePageStatus() {
        return homePageHtmlResponse.getStatusCodeValue();
    }

    protected String getHomePageContent() {
        return homePageHtmlResponse.getBody();
    }

    protected int getQuoteStatus() {
        return quoteResponse.getStatusCodeValue();
    }

    protected Quote getQuote() {
        return quoteResponse.getBody();
    }

    protected void setEndpointPath(String path) {
        this.path = path;
    }
}
