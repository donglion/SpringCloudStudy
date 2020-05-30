package com.lion.eurekaserver.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by lion on 2020/5/30.
 */
@FeignClient(name = "hello-service")
public interface RefactorHelloService extends com.lion.service.HelloService {

}
