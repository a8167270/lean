package com.learn.pattern.singleton;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 14:29
 **/
public class LazySingleton {
	private static LazySingleton lazySingleton;

	private LazySingleton() {

	}

	public static synchronized LazySingleton getInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}

		return lazySingleton;
	}
}
