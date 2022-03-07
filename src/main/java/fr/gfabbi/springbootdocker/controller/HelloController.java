package fr.gfabbi.springbootdocker.controller;

import fr.gfabbi.springbootdocker.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return helloService.hello(name);
    }

}
