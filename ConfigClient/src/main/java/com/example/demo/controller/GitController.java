package com.example.demo.controller;

import com.example.demo.config.GitAutoRefreshConfig;
import com.example.demo.config.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lion on 2020/6/15.
 */
@RestController
public class GitController {

    @Autowired
    private GitConfig gitConfig;

    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    @GetMapping(value = "show")
    public Object show(){
        return gitConfig;
    }

    @GetMapping(value = "autoShow")
    public Object autoShow(){
        return gitAutoRefreshConfig;
    }

}
