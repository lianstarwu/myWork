//package com.libo.designpattern.agency.cglibproxy.cglibfastclass;
/**
 * 用于对fastclass类的理解
 */
//public abstract class FastClass{
//
//    // 委托类
//    private Class type;
//
//    // 子类访问构造方法
//    protected FastClass() {}
//    protected FastClass(Class type) {
//        this.type = type;
//    }
//
//    // 创建动态FastClass子类
//    public static FastClass create(Class type) {
//        // Generator：子类生成器，继承AbstractClassGenerator
//        Generator gen = new Generator();
//        gen.setType(type);
//        gen.setClassLoader(type.getClassLoader());
//        return gen.create();
//    }
//
//    /**
//     * 调用委托类方法
//     *
//     * @param name 方法名
//     * @param parameterTypes 方法参数类型
//     * @param obj 委托类实例
//     * @param args 方法参数对象
//     */
//    public Object invoke(String name, Class[] parameterTypes, Object obj, Object[] args) {
//        return invoke(getIndex(name, parameterTypes), obj, args);
//    }
//
//    /**
//     * 根据方法描述符找到方法索引
//     *
//     * @param name 方法名
//     * @param parameterTypes 方法参数类型
//     */
//    public abstract int getIndex(String name, Class[] parameterTypes);
//
//
//    /**
//     * 根据方法索引调用委托类方法
//     *
//     * @param index 方法索引
//     * @param obj 委托类实例
//     * @param args 方法参数对象
//     */
//    public abstract Object invoke(int index, Object obj, Object[] args);
//
//    /**
//     * 调用委托类构造方法
//     *
//     * @param parameterTypes 构造方法参数类型
//     * @param args 构造方法参数对象
//     */
//    public Object newInstance(Class[] parameterTypes, Object[] args) throws {
//        return newInstance(getIndex(parameterTypes), args);
//    }
//
//    /**
//     * 根据构造方法描述符（参数类型）找到构造方法索引
//     *
//     * @param parameterTypes 构造方法参数类型
//     */
//    public abstract int getIndex(Class[] parameterTypes);
//
//    /**
//     * 根据构造方法索引调用委托类构造方法
//     *
//     * @param index 构造方法索引
//     * @param args 构造方法参数对象
//     */
//    public abstract Object newInstance(int index, Object[] args);
//
//}