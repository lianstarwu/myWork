package com.libo.designpattern.agency.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class JDKMeipo implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        before();
        Object obj = method.invoke(target,objects);
        after();
        return obj;
    }

    private void before() {
        System.out.println("动态代理方法执行之前");

    }

    private void after() {
        System.out.println("动态代理方法执行之后");
    }
}
