package fr.gfabbi.springbootdocker.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void hello_null_param_OK() {
        var result = helloService.hello(null);
        assertEquals("Hello world", result);
    }

    @Test
    void hello_empty_param_OK() {
        var result = helloService.hello("");
        assertEquals("Hello world", result);
    }

    @Test
    void hello_name_OK() {
        var result = helloService.hello("John");
        assertEquals("Hello John", result);
    }

}
