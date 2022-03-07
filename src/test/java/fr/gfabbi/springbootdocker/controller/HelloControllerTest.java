package fr.gfabbi.springbootdocker.controller;

import fr.gfabbi.springbootdocker.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc      mockMvc;
    @MockBean
    private HelloService helloService;

    @Test
    void hello_controller_OK() throws Exception {
        doReturn("Hello John").when(helloService).hello(anyString());
        mockMvc.perform(get("/hello?name=John"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello John")));
    }
}
