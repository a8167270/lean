package com.learn.pattern.proxy.staticProxy;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:12
 **/
public class Woker implements Person {

	@Override
	public void work() {
		System.out.println("工人工作");
	}
}
