package com.learn.pattern.proxy.manualProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 14:27
 **/
public class FJClassLoader extends ClassLoader {
	private File classFilePath;

	public FJClassLoader() {
		String classPath = FJClassLoader.class.getResource("").getPath();
		this.classFilePath = new File(classPath);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = FJClassLoader.class.getPackage().getName() + "." + name;
		if (classFilePath != null) {
			File classFile = new File(classFilePath, name.replaceAll("\\.", "/") + ".class");
			if (classFile.exists()) {
				try (FileInputStream in = new FileInputStream(classFile); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
					byte[] buff = new byte[1024];
					int len;
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}

					return defineClass(className, out.toByteArray(), 0, out.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
