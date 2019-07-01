package com.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	public TestApplication() {
		System.out.println("我是构造方法。。。。");
	}
	@PostConstruct
	public void init() {
		System.out.println("我是初始化方法。。。。。");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("fal");
	}
	

}
