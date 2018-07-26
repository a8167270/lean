package com.learn.pattern.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 14:53
 **/
public class RegistSingleton {
	private static Map<String, Object> register = new ConcurrentHashMap<>();

	static {
		RegistSingleton singleton = new RegistSingleton();
		register.put(singleton.getClass().getName(), singleton);
	}

	private RegistSingleton() {

	}

	public static RegistSingleton getInstance(String name)  {
		if (name == null) {
			name = RegistSingleton.class.getName();
		}

		if (register.get(name) == null) {
			try {
				register.put(name, Class.forName(name).newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return (RegistSingleton) register.get(name);
	}
}
