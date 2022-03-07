package fr.gfabbi.springbootdocker.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void hello_without_name_OK() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/hello", String.class))
                .contains("Hello world");
    }

    @Test
    void hello_with_name_OK() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/hello?name=John", String.class))
                .contains("Hello John");
    }
}
