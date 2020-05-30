package com.lion.eurekaserver.web;

import com.lion.dto.User;
import com.lion.service.HelloService;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lion on 2019/10/8.
 */
@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(com.lion.dto.User user) {
        return "Hello " + user.getName() + "," + user.getAge();
    }

}
