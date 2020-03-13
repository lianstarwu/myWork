package synchronizedDemo.多个线程访问synchronized和非synchronized代码块;

import synchronizedDemo.代码块.SyncThread;
import synchronizedDemo.多个线程访问synchronized和非synchronized代码块.Counter;

public class Test01 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "B");
        thread1.start();
        thread2.start();
    }
}
