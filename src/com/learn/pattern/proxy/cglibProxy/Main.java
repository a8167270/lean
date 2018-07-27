package com.learn.pattern.proxy.cglibProxy;

import com.learn.pattern.proxy.staticProxy.Person;
import com.learn.pattern.proxy.staticProxy.Woker;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:47
 **/
public class Main {
	public static void main(String[] args) {
		Person obj = (Person) new CglibProxy().getInstance(Woker.class);
		obj.work();
	}

}
