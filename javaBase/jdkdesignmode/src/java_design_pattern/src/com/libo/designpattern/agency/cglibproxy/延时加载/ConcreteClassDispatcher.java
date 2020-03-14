package com.libo.designpattern.agency.cglibproxy.延时加载;
import net.sf.cglib.proxy.Dispatcher;
public class ConcreteClassDispatcher implements Dispatcher{
 
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before Dispatcher...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("xxx");
        propertyBean.setValue(new TargetObject());
        System.out.println("after Dispatcher...");
        return propertyBean;
    }
 
}