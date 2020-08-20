package com.af.demo1;

import com.af.demo1.service.DemoService;
import com.af.demo1.service.DemoUserServiceImpl;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: _AF
 * @Date: 2020-08-20 17:00
 * @Description:
 */
public class Test1 {
	public static void main(String[] args) {

//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.getBeanFactory().registerSingleton("userService",new DemoUserServiceImpl());
		ac.register(Appconfig.class); //重新注入

		DemoUserServiceImpl userService =(DemoUserServiceImpl) ac.getBean("userService");

        // ac.refresh();//刷新
		System.out.println(userService.testName());
	//	GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
	//	genericBeanDefinition.setBeanClass(DemoUserServiceImpl.class);

	//	ac.registerBeanDefinition("userService",genericBeanDefinition);
		//
		// ac.refresh();
//		DemoService userService = (DemoService)ac.getBean("demoService");
//		System.out.println("名称："+userService.getName());
	}
}
