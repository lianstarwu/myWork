package synchronizedDemo.指定要给某个对象加锁;

import synchronizedDemo.多个线程访问synchronized和非synchronized代码块.Counter;

public class Test02 {
    public static void main(String[] args) {
        Account account = new Account("zhang san", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int THREAD_NUM = 5;

        for (int i = 0; i < THREAD_NUM; i++) {
            Thread threads = new Thread(accountOperator, "Thread" + i);
            threads.start();
        }
    }
}
