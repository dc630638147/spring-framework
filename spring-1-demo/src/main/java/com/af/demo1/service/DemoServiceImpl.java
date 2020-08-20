package com.af.demo1.service;

import org.springframework.stereotype.Service;

/**
 * @Auther: _AF
 * @Date: 2020-08-20 17:01
 * @Description:
 */
@Service
public class DemoServiceImpl implements DemoService {
	@Override
	public String getName() {
		System.out.println("打印名称");
		return "test";
	}
}
