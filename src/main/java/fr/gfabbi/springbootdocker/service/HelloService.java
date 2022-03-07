package fr.gfabbi.springbootdocker.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloService {

    public String hello(String name){
        if (StringUtils.hasText(name)) {
            return "Hello " + name;
        }
        return "Hello world";
    }

}
