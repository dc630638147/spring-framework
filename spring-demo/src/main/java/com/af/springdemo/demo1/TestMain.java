package com.af.springdemo.demo1;

import com.af.springdemo.Appconfig;
import com.af.springdemo.demo1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: _AF
 * @Date: 2020-08-20 16:45
 * @Description:
 */

public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

		UserService userService = (UserService)ac.getBean("userService");
		userService.getName();
	}
}
