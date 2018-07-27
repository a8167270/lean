package com.learn.pattern.proxy.manualProxy;

import com.learn.pattern.proxy.staticProxy.Person;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 15:26
 **/
public class FJProxyer implements FJInvocationHandle {
	private Person person;

	public Object getInstance(Person person) throws IOException, NoSuchMethodException {
		this.person = person;
		Class<?> clazz = person.getClass();

		//用来生成一个新的对象
		return FJProxy.newProxyInstance(new FJClassLoader(), clazz.getInterfaces(), this);

	}

	//	可以在被代理对象的方法上添加注解，然后在自己实现的InvocationHandler的invoke方法中判断要代理的方法有没有这个注解。
	//	如果有这个注解，就添加注解的逻辑。如果没有就直接调用原对象的方法。
	//  这样就可以实现对类的部分方法的代理。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("自定义代理启动");
		method.invoke(this.person, args);
		System.out.println("自定义代理启动");
		return null;
	}
}
