package com.libo.designpattern.agency.dynamic;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        proxyTest01();
    }

    /**
     * 动态代理测试
     */
    public static String proxyTest01() {
        //Person person = (Person) new JDKMeipo().getInstance(new Customer());
        //person.findLove("findLove", "findLove");
        //person.findLove1("findLove");
        return null;
    }

    /**
     * 反编译
     */
    public static void proxyTest02() {
        Person person = (Person) new com.libo.designpattern.agency.dynamic.JDKMeipo().getInstance(new Customer());
        //person.findLove("findLove", "findLove");
        //person.findLove1("findLove1");
        FileOutputStream fos = null;
        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
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
