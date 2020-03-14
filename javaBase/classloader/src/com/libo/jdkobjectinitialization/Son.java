package com.libo.jdkobjectinitialization;

/**
 * 无父类的对象初始化
 */
public class Son {

    final String STATIC_FIELD_01 = getSonField("STATIC_FIELD_01");//3
    private String field011 = "01";
    private String field01 = getMemberSonField("field01");//4

    public Son() {//
        System.out.println("子类构造方法！");
    }

    static {
        System.out.println("子类静态代码块！");//1
    }

    static final String STATIC_FIELD_02 = getSonField("STATIC_FIELD_02");//2

    static String getSonField(String str) {
        System.out.println("子类静态成员变量初始化-" + str);
        return str;
    }

    {
        System.out.println(field011);//1
        System.out.println("子类代码块！");//5
    }

    private String field02 = getMemberSonField("field02");//6

    String getMemberSonField(String str) {
        System.out.println("子类成员变量初始化-" + str);
        return str;
    }

    class Son01 {
        {
            System.out.println("子类代码块！");//5
        }

    }

    public static void main(String[] args) {
        new Son();//1
        //运行结果如下：

        //子类静态代码块！
        //子类静态成员变量初始化-STATIC_FIELD_02
        //子类静态成员变量初始化-STATIC_FIELD_01
        //子类成员变量初始化-field01
        //01
        //子类代码块！
        //子类成员变量初始化-field02
        //子类构造方法！

    }
}



