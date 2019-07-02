package com.bjss.inspiration.integration;

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
    private ResponseEntity<QuoteResponse> quoteResponse;

    protected void requestHomePageHtml() {
        homePageHtmlResponse = restTemplate.getForEntity(getUri(), String.class);
    }

    private String getUri() {
        return "http://localhost:" + port + path;
    }

    protected int getHomePageStatus() {
        return homePageHtmlResponse.getStatusCodeValue();
    }

    protected String getHomePageContent() {
        return homePageHtmlResponse.getBody();
    }

    protected void requestQuoteFromApi() {
        quoteResponse = restTemplate.getForEntity(getUri(), QuoteResponse.class);
    }

    protected int getQuoteStatus() {
        return quoteResponse.getStatusCodeValue();
    }

    protected QuoteResponse getQuote() {
        return quoteResponse.getBody();
    }

    protected void setEndpointPath(String path) {
        this.path = path;
    }
}
