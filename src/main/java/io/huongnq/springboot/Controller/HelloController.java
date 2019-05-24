package io.huongnq.springboot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/home")
    public String sayHello()
    {
        return "hello world";

    }
}
