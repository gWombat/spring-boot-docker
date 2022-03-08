package fr.gfabbi.springbootdocker.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloService {

    /**
     * Says hello to the person specified by the given name
     *
     * @param name
     *         the name to welcome
     * @return a welcome to the given name
     */
    public String hello(String name) {
        if (StringUtils.hasText(name)) {
            return "Hello " + name;
        }
        return "Hello world";
    }

}
