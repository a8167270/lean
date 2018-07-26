package com.learn.pattern.singleton;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 14:23
 **/
public class HungrySingleton {
	private final  static HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton() {

	}

	public static HungrySingleton getInstance() {
		return hungrySingleton;
	}
}
