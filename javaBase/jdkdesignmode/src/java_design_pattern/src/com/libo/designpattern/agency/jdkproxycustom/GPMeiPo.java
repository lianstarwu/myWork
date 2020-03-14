package com.libo.designpattern.agency.jdkproxycustom;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态代理-处理器
 */
public class GPMeiPo implements GPInvocationHandler {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return GPProxy.newProxyInvocation(new GPClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        before();
        //System.out.println("jdk代理开始工作");
        //System.out.println("调用目标类方法");
        Object returnValue = method.invoke(target,args);
        //System.out.println("调用完毕，返回值为："+returnValue);
        after();
        return returnValue;
    }

    private void before() {
        System.out.println("动态代理方法执行之前-zidingyi");

    }

    private void after() {
        System.out.println("动态代理方法执行之后-zidingyi");
    }
}
