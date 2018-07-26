package com.learn.pattern;

import com.learn.pattern.AbstractFactory.AbstractFactory;
import com.learn.pattern.AbstractFactory.FactoryImp;
import com.learn.pattern.FactoryMethod.QingDaoFactory;
import com.learn.pattern.SimpleFactory.Factory;
import com.learn.pattern.SimpleFactory.SimpleFactory;
import com.learn.pattern.singleton.HungrySingleton;
import com.learn.pattern.singleton.InnerClassSingleton;
import com.learn.pattern.singleton.LazySingleton;
import com.learn.pattern.singleton.RegistSingleton;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		// 简单工厂
		Factory factory = new SimpleFactory();
		System.out.println(factory.createBear("青岛").printName());

		//工厂方法
		com.learn.pattern.FactoryMethod.Factory factoryMethod = new QingDaoFactory();
		System.out.println(factoryMethod.createBear().printName());

		//抽象工厂
		AbstractFactory factoryImp = new FactoryImp();
		System.out.println(factoryImp.createQingDao().printName());

		int count = 100;
		CountDownLatch latch = new CountDownLatch(count);
		IntStream.range(0, count).forEach(x -> {
					new Thread() {
						@Override
						public void run() {
							try {
								latch.await();
								Object singleton = RegistSingleton.getInstance(null);
								System.out.println(System.currentTimeMillis() + ":" + singleton);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}.start();

					latch.countDown();
				}
		);

	}
}
