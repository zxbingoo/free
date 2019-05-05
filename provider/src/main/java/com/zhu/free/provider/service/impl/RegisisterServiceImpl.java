package com.zhu.free.provider.service.impl;

import com.zhu.free.provider.service.IRegisisterService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class RegisisterServiceImpl implements IRegisisterService {

    @Override
    public String registerNewUser() {
        return "调用成功";
    }
}
