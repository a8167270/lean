package com.learn.pattern.proxy.jdkProxy;

import com.learn.pattern.proxy.staticProxy.Person;
import com.learn.pattern.proxy.staticProxy.Woker;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:27
 **/
public class Main {
	public static void main(String[] args) {
		Person object = (Person) new JdkProxy().getInstance(new Woker());
		System.out.println(object);
		object.work();
	}
}
