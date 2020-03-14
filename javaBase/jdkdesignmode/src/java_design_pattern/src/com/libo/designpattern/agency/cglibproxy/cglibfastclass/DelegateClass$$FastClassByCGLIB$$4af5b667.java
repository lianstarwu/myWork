//package com.libo.designpattern.agency.cglibproxy.cglibfastclass;
//
//import net.sf.cglib.reflect.FastClass;
//
//import java.lang.reflect.InvocationTargetException;
//
///**
// * 动态子类，只是用于理解如何生成一个动态子类与如何进行方法的调用
// */
//public abstract class DelegateClass$$FastClassByCGLIB$$4af5b667 extends FastClass {
//
//    /**
//     * 动态子类构造方法
//     */
//    public DelegateClass$$FastClassByCGLIB$$4af5b667(Class delegateClass) {
//        super(delegateClass);
//    }
//
//    /**
//     * 根据方法签名得到方法索引
//     *
//     * @param name 方法名
//     * @param parameterTypes 方法参数类型
//     */
//    public int getIndex(String methodName, Class[] parameterTypes) {
//        switch(methodName.hashCode()) {
//
//            // 委托类方法add索引：0
//            case 96417:
//                if (methodName.equals("add")) {
//                    switch(parameterTypes.length) {
//                        case 2:
//                            if (parameterTypes[0].getName().equals("java.lang.String") &&
//                                parameterTypes[1].getName().equals("int")) {
//                                return 0;
//                            }
//                    }
//                }
//                break;
//
//            // 委托类方法update索引：1
//            case -838846263:
//                if (methodName.equals("update")) {
//                    switch(parameterTypes.length) {
//                        case 0:
//                            return 1;
//                    }
//                }
//                break;
//
//            // Object方法equals索引：2
//            case -1295482945:
//                if (methodName.equals("equals")) {
//                    switch(parameterTypes.length) {
//                        case 1:
//                            if (parameterTypes[0].getName().equals("java.lang.Object")) {
//                                return 2;
//                            }
//                    }
//                }
//                break;
//
//            // Object方法toString索引：3
//            case -1776922004:
//                if (methodName.equals("toString")) {
//                    switch(parameterTypes.length) {
//                        case 0: return 3;
//                    }
//                }
//                break;
//
//            // Object方法hashCode索引：4
//            case 147696667:
//                if (methodName.equals("hashCode")) {
//                    switch(parameterTypes.length) {
//                        case 0:
//                            return 4;
//                    }
//                }
//        }
//
//        return -1;
//    }
//
//    /**
//     * 根据方法索引调用委托类方法
//     *
//     * @param methodIndex 方法索引
//     * @param delegateInstance 委托类实例
//     * @param parameterValues 方法参数对象
//     */
//    public Object invoke(int methodIndex, Object delegateInstance, Object[] parameterValues) throws InvocationTargetException {
//        DelegateClass instance = (DelegateClass) delegateInstance;
//        int index = methodIndex;
//        try {
//            switch(index) {
//                case 0:
//                    // 委托类实例直接调用方法语句
//                    return new Boolean(instance.add((String)parameterValues[0],
//                            ((Number)parameterValues[1]).intValue()));
//                case 1:
//                    instance.update();
//                    return null;
//                case 2:
//                    return new Boolean(instance.equals(parameterValues[0]));
//                case 3:
//                    return instance.toString();
//                case 4:
//                    return new Integer(instance.hashCode());
//            }
//        } catch (Throwable t) {
//            throw new InvocationTargetException(t);
//        }
//
//        throw new IllegalArgumentException("Cannot find matching method/constructor");
//    }
//
//    /**
//     * 根据构造方法描述符（参数类型）找到构造方法索引
//     *
//     * @param parameterTypes 构造方法参数类型
//     */
//    public int getIndex(Class[] parameterTypes) {
//        switch(parameterTypes.length) {
//            // 无参构造方法索引：0
//            case 0:
//                return 0;
//
//            // 有参构造方法索引：1
//            case 1:
//                if (parameterTypes[0].getName().equals("java.lang.String")) {
//                    return 1;
//                }
//            default:
//                return -1;
//        }
//    }
//
//    /**
//     * 根据构造方法索引调用委托类构造方法
//     *
//     * @param methodIndex 构造方法索引
//     * @param parameterValues 构造方法参数对象
//     */
//    public Object newInstance(int methodIndex, Object[] parameterValues) {
//        // 创建委托类实例
//        DelegateClass newInstance = new DelegateClass;
//        DelegateClass newObject = newInstance;
//        int index = methodIndex;
//        try {
//            switch(index) {
//                // 调用构造方法（<init>）
//                case 0:
//                    newObject.<init>();
//                    return newInstance;
//                case 1:
//                    newObject.<init>((String)parameterValues[0]);
//                    return newInstance;
//            }
//        } catch (Throwable t) {
//            throw new InvocationTargetException(t);
//        }
//
//        throw new IllegalArgumentException("Cannot find matching method/constructor");
//    }
//
//    public int getMaxIndex() {
//        return 4;
//    }
//}