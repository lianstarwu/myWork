package com.libo.designpattern.agency.cglibproxy.延时加载;

import static net.sf.cglib.core.DebuggingClassWriter.DEBUG_LOCATION_PROPERTY;

public class Test {
    public static void main(String[] args) {
        System.setProperty(DEBUG_LOCATION_PROPERTY, "D:\\myWork\\ideaWork\\javaBase\\java_design_pattern\\testFile\\");
        LazyBean jack = new LazyBean("jack", 29);
        PropertyBean propertyBean = jack.getPropertyBean();
        PropertyBean propertyBeanDispatcher = jack.getPropertyBeanDispatcher();
        System.out.println(propertyBean.getKey());
        System.out.println(propertyBean.getKey());
        System.out.println(propertyBeanDispatcher.getKey());
        System.out.println(propertyBeanDispatcher.getKey());
    }
}
