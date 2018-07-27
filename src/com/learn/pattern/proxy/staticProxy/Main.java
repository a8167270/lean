package com.learn.pattern.proxy.staticProxy;

import sun.misc.ProxyGenerator;

import java.io.*;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 11:13
 **/
public class Main {
	public static void main(String[] args) throws IOException {
//		new Proxy(new Woker()).work();

		byte[] bytes = ProxyGenerator.generateProxyClass("$Pxoxy",new Class[]{Person.class});
		OutputStream os = new FileOutputStream("E://$Proxy0.class");
		os.write(bytes);
		os.close();
	}


}
