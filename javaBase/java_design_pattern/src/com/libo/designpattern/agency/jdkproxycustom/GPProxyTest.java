package com.libo.designpattern.agency.jdkproxycustom;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class GPProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        GPPerson person = (GPPerson) new GPMeiPo().getInstance(new GPCustomer());
        person.findLove();
        person.study();
        person.study1("-study1");
        //person.study2(9999);
    }

    /**
     * 动态代理测试
     */
    public static void proxyTest01() {
        GPPerson person = (GPPerson) new GPMeiPo().getInstance(new GPCustomer());
        person.findLove();
        //gpPerson.findLove("findLove");
    }

    /**
     * 反编译
     */
    public static void proxyTest02() {
        GPPerson gpPerson = (GPPerson) new GPMeiPo().getInstance(new GPCustomer());
        //gpPerson.findLove("findLove");
        //gpPerson.findLove1("findLove1");
        FileOutputStream fos = null;
        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{GPPerson.class});
            fos = new FileOutputStream("D:\\myWork\\ideaWork\\javaBase\\java_design_pattern\\testFile\\$Proxy0.class");
            if (fos != null) {
                fos.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
