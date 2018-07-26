package com.learn.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 14:45
 **/
public class Main {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> clazz = LazySingleton.class;
		Constructor[] cs  = clazz.getDeclaredConstructors();

		for (Constructor c : cs) {
			//用反射强制访问
			c.setAccessible(true);
			Object o = c.newInstance();
		}

	}
}
