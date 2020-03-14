package com.libo.designpattern.agency.cglibproxy;

import com.libo.designpattern.agency.jdkdynamic.Customer;
import com.libo.designpattern.agency.jdkdynamic.Person;
import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

import static net.sf.cglib.core.DebuggingClassWriter.DEBUG_LOCATION_PROPERTY;

public class CGLibProxyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        proxyTest01();
    }

    /**
     * 动态代理测试
     */
    public static String proxyTest01() {
        //利用CGLib的代理类可以将内存中的.class文件写到本地磁盘
        System.setProperty(DEBUG_LOCATION_PROPERTY, "D:\\myWork\\ideaWork\\javaBase\\java_design_pattern\\testFile\\");
        com.libo.designpattern.agency.cglibproxy.CGLibCustomer cgLibCustomer = (com.libo.designpattern.agency.cglibproxy.CGLibCustomer) new com.libo.designpattern.agency.cglibproxy.CGLibMeiPo().getInstance(com.libo.designpattern.agency.cglibproxy.CGLibCustomer.class);
        cgLibCustomer.findLove();
        return null;
    }

    /**
     * 反编译
     */
    public static void proxyTest02() {
        Person person = (Person) new com.libo.designpattern.agency.jdkdynamic.JDKMeipo().getInstance(new Customer());
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
