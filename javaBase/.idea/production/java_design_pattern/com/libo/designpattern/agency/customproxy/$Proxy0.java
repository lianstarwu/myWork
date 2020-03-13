package com.libo.designpattern.agency.customproxy;
import java.lang.reflect.Method;
public class $Proxy0 implements com.libo.designpattern.agency.customproxy.Person{
MyInvocationHandle h;
public $Proxy0(MyInvocationHandle h){ this.h = h;}public void study(){
try{Method m = com.libo.designpattern.agency.customproxy.Person.class.getMethod("study",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){ e.printStackTrace();}
}
public void findLove(){
try{Method m = com.libo.designpattern.agency.customproxy.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){ e.printStackTrace();}
}
}
