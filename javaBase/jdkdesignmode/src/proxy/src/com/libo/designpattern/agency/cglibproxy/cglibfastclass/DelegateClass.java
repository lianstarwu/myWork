package com.libo.designpattern.agency.cglibproxy.cglibfastclass;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.reflect.FastClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射与fastclass的方式获取实例实现方法调用
 */
public class DelegateClass {

    public DelegateClass() {
    }

    public DelegateClass(String string) {
    }

    public boolean add(String string, int i) {
        System.out.println("This is add method: " + string + ", " + i);
        return true;
    }

    public void update() {
        System.out.println("This is update method");
    }

    public static void main(String[] args) throws Exception {
        // 保留生成的FastClass类文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\Temp\\CGLib\\FastClass");

        Class delegateClass = DelegateClass.class;

        // Java Reflect

        // 反射构造类
        Constructor delegateConstructor = delegateClass.getConstructor(String.class);
        // 创建委托类实例
        DelegateClass delegateInstance = (DelegateClass) delegateConstructor.newInstance("Tom");

        // 反射方法类
        Method addMethod = delegateClass.getMethod("add", String.class, int.class);
        // 调用方法
        addMethod.invoke(delegateInstance, "Tom", 30);

        Method updateMethod = delegateClass.getMethod("update");
        updateMethod.invoke(delegateInstance);

        // CGLib FastClass

        // FastClass动态子类实例
        FastClass fastClass = FastClass.create(DelegateClass.class);

        // 创建委托类实例
        DelegateClass fastInstance = (DelegateClass) fastClass.newInstance(
                new Class[]{String.class}, new Object[]{"Jack"});

        // 调用委托类方法
        fastClass.invoke("add", new Class[]{String.class, int.class}, fastInstance,
                new Object[]{"Jack", 25});

        fastClass.invoke("update", new Class[]{}, fastInstance, new Object[]{});
    }
}