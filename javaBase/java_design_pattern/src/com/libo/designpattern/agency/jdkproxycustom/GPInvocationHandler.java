package com.libo.designpattern.agency.proxycustom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义动态代理处理器接口
 */
public interface GPInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
