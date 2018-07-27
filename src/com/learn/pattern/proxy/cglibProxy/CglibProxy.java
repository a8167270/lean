package com.learn.pattern.proxy.cglibProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:37
 **/
public class CglibProxy implements MethodInterceptor {
	public Object getInstance(Class<?> clazz) {
		Enhancer enhancer = new Enhancer();
		//把clazz设置为心类的父类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);

		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("工作代理");

		methodProxy.invokeSuper(o, objects);

		System.out.println("工作完成");
		return null;
	}
}
