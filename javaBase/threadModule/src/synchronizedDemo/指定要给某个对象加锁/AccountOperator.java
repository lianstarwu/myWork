package synchronizedDemo.指定要给某个对象加锁;

/**
 * 账户操作类
 */
public class AccountOperator implements Runnable {

    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    public void run() {
        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}