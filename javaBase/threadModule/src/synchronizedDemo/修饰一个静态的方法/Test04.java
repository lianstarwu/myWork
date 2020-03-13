package synchronizedDemo.修饰一个静态的方法;

import synchronizedDemo.多个线程访问synchronized和非synchronized代码块.Counter;

public class Test04 {
    public static void main(String[] args) {
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
