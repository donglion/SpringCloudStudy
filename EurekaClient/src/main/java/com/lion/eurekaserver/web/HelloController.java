package com.lion.eurekaserver.web;

import com.lion.dto.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lion on 2019/10/8.
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody User user) {
        return "Hello " + user.getName() + "," + user.getAge();
    }

}
