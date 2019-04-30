package com.zhu.free.provider;


import com.zhu.free.provider.config.DubboProviderConfiguration;

public class ProviderApplication {

	public static void main(String[] args) throws Exception {
		new EmbeddedZooKeeper(2181, false).start(); // #1
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboProviderConfiguration.class); // #2
		context.start(); // #3
		System.in.read(); // #4
	}
}
