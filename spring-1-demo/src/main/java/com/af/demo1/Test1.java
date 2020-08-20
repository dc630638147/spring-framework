package com.af.demo1;

import com.af.demo1.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: _AF
 * @Date: 2020-08-20 17:00
 * @Description:
 */
public class Test1 {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

		DemoService userService = (DemoService)ac.getBean("demoService");
		System.out.println("名称："+userService.getName());
	}
}
