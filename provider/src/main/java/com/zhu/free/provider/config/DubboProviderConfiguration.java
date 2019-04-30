package com.zhu.free.provider.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author jianbin
 * @date 2019/4/30
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.zhu.free.provider")
@PropertySource("classpath:/dubbo-provider.properties")
public class DubboProviderConfiguration {
}
