package synchronizedDemo.修饰一个方法;

import java.io.IOException;
import java.nio.CharBuffer;

public class MyThread implements Runnable {
    private MyCounter myCounter;

    public MyThread(MyCounter myCounter) {
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        myCounter.countMethod();
    }
}
