package com.libo.designpattern.agency.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 处理类
 */
public class CGLibMeiPo implements MethodInterceptor {
    public Object getInstance(Class<?> aclass) {
        Enhancer enhancer = new Enhancer();
        //要把哪个设置为将很生产的新类的父类
        enhancer.setSuperclass(aclass);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
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
