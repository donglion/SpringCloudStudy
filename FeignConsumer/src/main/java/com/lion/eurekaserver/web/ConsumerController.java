package com.lion.eurekaserver.web;

import com.lion.dto.User;
import com.lion.eurekaserver.service.HelloService;
import com.lion.eurekaserver.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lion on 2019/10/8.
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello1("DIDI")).append("\n");
        sb.append(helloService.hello2("DIDI", 18)).append("\n");
        sb.append(helloService.hello3(new User("DIDI", 18))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("DIDI")).append("\n");
        sb.append(refactorHelloService.hello("DIDI", 18)).append("\n");
        sb.append(refactorHelloService.hello(new User("DIDI", 18))).append("\n");
        return sb.toString();
    }

}
