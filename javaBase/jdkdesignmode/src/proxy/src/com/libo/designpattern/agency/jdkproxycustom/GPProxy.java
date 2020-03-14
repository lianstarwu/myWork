package com.libo.designpattern.agency.jdkproxycustom;



import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GPProxy {
    public static final String ln = "\r\n";
    private static HashMap<Class, Class> Map = new HashMap<>();

    static {
        Map.put(byte.class, Byte.class);
        Map.put(short.class, Short.class);
        Map.put(int.class, Integer.class);
        Map.put(long.class, Long.class);
        Map.put(char.class, Character.class);
        Map.put(double.class, Double.class);
        Map.put(boolean.class, Boolean.class);
        Map.put(float.class, Float.class);
    }

    /**
     * 获取动态代理实例
     *
     * @param gpClassLoader
     * @param interfaces
     * @param h
     * @return
     */
    public static Object newProxyInvocation(GPClassLoader gpClassLoader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            //1.动态生成源码文件
            String src = generateSrc(interfaces);
            //String src = gentor(interfaces);
            //2.java文件输出磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.close();
            //3.把生产的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4.把.class文件加载到jvm中
            Class proxyClass = gpClassLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(GPInvocationHandler.class);
            //file.delete();
            //返回字节码重组以后的新的代理对象
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 动态生产.java文件
     *
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.libo.designpattern.agency.jdkproxycustom;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append(ln);

        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);

        sb.append("GPInvocationHandler h;" + ln);

        sb.append("public $Proxy0(GPInvocationHandler h){ this.h = h;}");

        Method[] methods = interfaces[0].getMethods();
        if (methods != null && methods.length > 0) {

        }
        for (Method method : methods) {
            Class<?>[] params = method.getParameterTypes();
            //参数类型+字段名字
            StringBuffer paramsNames = new StringBuffer();
            //字段名字
            StringBuffer paramsValues = new StringBuffer();
            //参数类型
            StringBuffer paramsClasses = new StringBuffer();
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    Class<?> param = params[i];
                    String type = param.getName();
                    String paramsName = toLowerFirstCase(param.getSimpleName());
                    if (type != null && type.length() > 0) {
                        paramsNames.append(type + " " + paramsName);
                        paramsValues.append(paramsName);
                        paramsClasses.append(type + ".class");
                        if (i > 0 && i < params.length - 1) {
                            paramsNames.append(",");
                            paramsValues.append(",");
                            paramsClasses.append(",");
                        }
                    }
                }
            }
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramsNames.toString() + ") {" + ln);
            sb.append("try {" + ln);
            sb.append(" Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[] { " + paramsClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(method.getReturnType()) ? "return (" + method.getReturnType().getName() + ")" : "") + "this.h.invoke(this, m, new Object[] { " + paramsValues.toString() + " });" + ln);
            sb.append("}catch(Throwable e){ e.printStackTrace();}" + ln);
            sb.append(hasReturnValue(method.getReturnType()) ? "return null;}" : "}" + ln);
            //sb.append("public void " + method.getName() + "(){" + ln);
            //sb.append("try{");
            //sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            //sb.append("this.h.invoke(this,m,null);" + ln);
            //sb.append("}catch(Throwable e){ e.printStackTrace();}" + ln);
            //sb.append("}" + ln);
        }

        sb.append("}" + ln);
        return sb.toString();
    }

    /**
     * 根据类型处理返回值
     *
     * @param
     * @return
     */
    //private static String getReturnEmptyCode(Class<?> tClass) {
    //    if ()
    //}

    public static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    public static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

}
