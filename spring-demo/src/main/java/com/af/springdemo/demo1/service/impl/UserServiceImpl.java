package com.af.springdemo.demo1.service.impl;

import com.af.springdemo.demo1.service.UserService;

/**
 * @Auther: _AF
 * @Date: 2020-08-20 16:44
 * @Description:
 */
public class UserServiceImpl implements UserService {
	@Override
	public String getName() {

		System.out.println("打印出来了");
		return "这是名字";
	}
}
