package com.learn.pattern.proxy.jdkProxy;

import com.learn.pattern.proxy.staticProxy.Person;
import com.learn.pattern.proxy.staticProxy.Woker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:19
 **/
public class JdkProxy implements InvocationHandler {
	//被代理对象，保存引用
	private Person person;

	public Object getInstance(Person person) {
		this.person = person;
		Class<?> clazz = person.getClass();

		//用来生成一个新的对象
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是代理！");

		method.invoke(this.person, args);

		System.out.println("工作完成！");
		return null;
	}
}
