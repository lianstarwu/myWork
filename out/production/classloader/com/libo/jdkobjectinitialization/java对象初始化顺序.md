java创建对象 的初始化顺序

1、初始化块

初始化块通常写在类的构造方法之前，由花括号括起来，通常包含对成员属性进行初始化的语句；

初始化块分为instance初始化块和static初始化块，初始化块在构造方法执行之前被执行；

static初始化块不能访问非static成员，也不能调用非static方法，并且只能在类加载时执行一次；

初始化块通常用于提取多个构造方法中的公共代码。　　

2、初始化块的执行顺序

（1）、在初次创建一个子类对象时，先加载父类，再加载子类

（2）、加载父类：

　　　　初始化父类的static属性，赋默认值。

　　　　执行父类的static初始化块

　（3）、加载子类：

　　　　　　初始化子类的static属性，赋默认值。

　　　　　　执行子类的static初始化块。

（4）、创建父类对象：

　　　　初始化父类的非static属性，赋默认值；

　　　　执行父类的instance初始化块；

　　　　执行父类的构造方法；

（5）、创建子类的对象

　　　　初始化子类的static属性，赋默认值；

　　　　执行子类的instance初始化块；

　　　　执行子类的构造方法；

后再创建子类对象时，按4，5步骤执行。