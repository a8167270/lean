package com.learn.pattern.proxy.manualProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 14:26
 **/
public class FJProxy {
	private final static String ln = "\r\n";

	public static Object newProxyInstance(FJClassLoader classLoader, Class<?>[] interfaces, FJInvocationHandle invocationHandle) throws IOException,
			NoSuchMethodException {
		//1、动态生成源代码.java文件

		//4、编译成.class文件加载到JVM中
		//5、返回的字节码重组以后的新的代理对象
		String content = generateSrc(interfaces);
		try {
			//2、Java文件输出磁盘
			String filePath = FJProxy.class.getResource("").getPath();
			File f = new File(filePath+ "$Proxy0.java");
			FileWriter fileWriter = new FileWriter(f);
			fileWriter.write(content);
			fileWriter.close();

			//3、把生成的.java文件编译成.class文件
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
			Iterable iterable = manager.getJavaFileObjects(f);

			JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();

			Class proxyClass = classLoader.findClass("$Proxy0");
			Constructor constructor = proxyClass.getConstructor(FJInvocationHandle.class);
			return constructor.newInstance(invocationHandle);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String generateSrc(Class<?>[] interfaces) {
		StringBuffer sb = new StringBuffer();
		sb.append("package com.learn.pattern.proxy.manualProxy;" + ln);
		sb.append("import com.learn.pattern.proxy.staticProxy.Person;" + ln);
		sb.append("import java.lang.reflect.Method;" + ln);
		sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);

		sb.append("FJInvocationHandle h;" + ln);

		sb.append("public $Proxy0(FJInvocationHandle h) { " + ln);

		sb.append("this.h = h;");

		sb.append("}" + ln);


		for (Method m : interfaces[0].getMethods()) {
			sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
			sb.append("try{" + ln);
			sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
			sb.append("this.h.invoke(this,m,null);" + ln);
			sb.append("}catch(Throwable e){" + ln);
			sb.append("e.printStackTrace();" + ln);
			sb.append("}");
			sb.append("}");
		}

		sb.append("}" + ln);

		return sb.toString();
	}
}
