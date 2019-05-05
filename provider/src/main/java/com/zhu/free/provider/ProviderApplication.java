package com.zhu.free.provider;

import com.zhu.free.provider.config.EmbeddedZooKeeper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@EnableAutoConfiguration
public class ProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplication.class)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                })
                .run(args);
    }

//    public static void main(String[] args) throws Exception {
//        new EmbeddedZooKeeper(2181, false).start();
//        Thread.sleep(1000);
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
//        System.out.println(context.containsBean("IRegisisterService"));
//        context.start();
//        System.in.read();
//    }
//
//    @Configuration
//    @EnableDubbo(scanBasePackages = "com.zhu.free.provider")
//    @PropertySource("classpath:/dubbo-provider.properties")
//    static public class ProviderConfiguration {
//        @Bean
//        public ProviderConfig providerConfig() {
//            ProviderConfig providerConfig = new ProviderConfig();
//            providerConfig.setTimeout(1000);
//            return providerConfig;
//        }
//    }
}
