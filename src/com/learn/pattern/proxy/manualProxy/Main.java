package com.learn.pattern.proxy.manualProxy;

import com.learn.pattern.proxy.staticProxy.Person;
import com.learn.pattern.proxy.staticProxy.Woker;

import java.io.IOException;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 15:39
 **/
public class Main {
	public static void main(String[] args) throws IOException, NoSuchMethodException {
		Person person = (Person) new FJProxyer().getInstance(new Woker());
		person.work();
	}
}
