package com.learn.pattern.proxy.manualProxy;

import java.lang.reflect.Method;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-27 14:26
 **/
public interface FJInvocationHandle {
	Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
