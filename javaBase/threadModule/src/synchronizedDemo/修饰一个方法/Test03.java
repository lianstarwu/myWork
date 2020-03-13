package synchronizedDemo.修饰一个方法;

import synchronizedDemo.多个线程访问synchronized和非synchronized代码块.Counter;

public class Test03 {
    public static void main(String[] args) {
//        MyCounter myCounter = new MyCounter();
//        MyThread myThread = new MyThread(myCounter);
//        Thread thread1 = new Thread(myThread, "A");
//        Thread thread2 = new Thread(myThread, "B");
//        thread1.start();
//        thread2.start();
        SyncThread myThread = new SyncThread();
        Thread thread1 = new Thread(myThread, "A");
        Thread thread2 = new Thread(myThread, "B");
        thread1.start();
        thread2.start();
    }
}
