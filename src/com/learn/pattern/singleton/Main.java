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
		Class<?> clazz = InnerClassSingleton.class;
		try {
			Constructor cs  = clazz.getDeclaredConstructor(null);
			cs.setAccessible(true);

			Object o1 = cs.newInstance();
			Object o2 = cs.newInstance();

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}


	}
}
