package com.learn.pattern.proxy.staticProxy;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:11
 **/
public class Proxy implements Person{
	private Person person;

	public Proxy(Person person){
		this.person = person;
	}

	@Override
	public void work() {
		this.person.work();
	}
}
