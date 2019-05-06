package com.zhu.free.consumer.controller;

import com.zhu.free.provider.service.IRegisisterService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Reference
    private IRegisisterService regisisterService;

    public void test(){
        System.out.println(regisisterService.registerNewUser());
    }

}
