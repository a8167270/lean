package com.learn.pattern.singleton;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 14:36
 **/
public class InnerClassSingleton {
	//在外部类被调用的时候内部类才会被加载
	//内部类一定是要在方法调用之前初始化
	//保证线程安全
	private static boolean initialized = false;

	//默认使用内部类的时候，会先初始化内部类
	//如果没有使用的话，内部类不会进行加载
	private InnerClassSingleton() {
		synchronized (InnerClassSingleton.class) {
			if (!initialized) {
				initialized = true;
			} else {
				throw new RuntimeException("单例已被侵犯");
			}

		}

	}

	public static InnerClassSingleton getInstance() {
		return LazyHolder.singleton;
	}

	private static class LazyHolder {
		private static final InnerClassSingleton singleton = new InnerClassSingleton();
	}
}
