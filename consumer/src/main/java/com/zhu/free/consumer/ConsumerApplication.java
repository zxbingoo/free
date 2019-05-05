package com.zhu.free.consumer;

import com.zhu.free.provider.service.IRegisisterService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@EnableAutoConfiguration
public class ConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private IRegisisterService regisisterService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(regisisterService.registerNewUser());
    }


//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
//        context.start();
//        final IRegisisterService annotationAction = (IRegisisterService) context.getBean("IRegisisterService");
//
//        System.out.println("hello :" + annotationAction.registerNewUser());
//    }
//
//
//    @Configuration
//    @EnableDubbo(scanBasePackages = "com.zhu.free.consumer")
//    @PropertySource("classpath:dubbo-consumer.properties")
//    @ComponentScan(value = {"com.zhu.free.consumer"})
//    static public class ConsumerConfiguration {
//
//    }

//    public static void main(String[] args) {
//        SpringApplication.run(ConsumerApplication.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerApplication.class);
//        context.start();
//        final IRegisisterService annotationAction = (IRegisisterService) context.getBean("RegisisterServiceImpl");
//        String hello = annotationAction.registerNewUser();
//        System.out.println(hello);
//    }

}


