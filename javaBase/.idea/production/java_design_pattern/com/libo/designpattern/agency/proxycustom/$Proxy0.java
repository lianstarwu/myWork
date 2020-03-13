package com.libo.designpattern.agency.proxycustom;
import java.lang.reflect.Method;

public class $Proxy0 implements com.libo.designpattern.agency.proxycustom.GPPerson{
GPInvocationHandler h;
public $Proxy0(GPInvocationHandler h){ this.h = h;}public void study() {
try {
 Method m = com.libo.designpattern.agency.proxycustom.GPPerson.class.getMethod("study", new Class[] { });
this.h.invoke(this, m, new Object[] {  });
}catch(Throwable e){ e.printStackTrace();}
}
public void findLove() {
try {
 Method m = com.libo.designpattern.agency.proxycustom.GPPerson.class.getMethod("findLove", new Class[] { });
this.h.invoke(this, m, new Object[] {  });
}catch(Throwable e){ e.printStackTrace();}
}
public java.lang.String study1(java.lang.String string) {
try {
 Method m = com.libo.designpattern.agency.proxycustom.GPPerson.class.getMethod("study1", new Class[] { java.lang.String.class});
return (java.lang.String)this.h.invoke(this, m, new Object[] { string });
}catch(Throwable e){ e.printStackTrace();}
return null;}}
