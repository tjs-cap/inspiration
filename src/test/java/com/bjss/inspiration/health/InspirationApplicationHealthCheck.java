package com.bjss.inspiration.health;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InspirationApplicationHealthCheck {

    private static final String URL_DEPLOYED_APP_HEALTH_ENDPOINT = "http://localhost:8080/actuator/health";

    @Autowired
    private TestRestTemplate restClient;

    @Test
    public void returnsHttp200Ok() {
        ResponseEntity<String> health = restClient.getForEntity(URL_DEPLOYED_APP_HEALTH_ENDPOINT, String.class);

        assertThat(health.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
