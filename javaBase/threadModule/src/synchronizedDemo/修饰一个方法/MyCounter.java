package synchronizedDemo.修饰一个方法;

public class MyCounter {
    public synchronized void  countMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
