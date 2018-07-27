package com.learn.pattern.proxy.manualProxy;
import com.learn.pattern.proxy.staticProxy.Person;
import java.lang.reflect.Method;
public class $Proxy0 implements com.learn.pattern.proxy.staticProxy.Person{
FJInvocationHandle h;
public $Proxy0(FJInvocationHandle h) { 
this.h = h;}
public void work() {
try{
Method m = com.learn.pattern.proxy.staticProxy.Person.class.getMethod("work",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}}}
