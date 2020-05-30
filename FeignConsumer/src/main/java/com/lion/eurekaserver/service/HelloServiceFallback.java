package com.lion.eurekaserver.service;

import com.lion.dto.User;
import org.springframework.stereotype.Component;

/**
 * Created by lion on 2020/5/30.
 */
@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello1(String name) {
        return "error";
    }

    @Override
    public User hello2(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello3(User user) {
        return "error";
    }

}
