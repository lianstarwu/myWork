package synchronizedDemo.修饰一个静态的方法;

/**
 * 同步线程
 */
class SyncThread implements Runnable {
   private static int count;

   public SyncThread() {
      count = 0;
   }

   public synchronized static void method() {
      for (int i = 0; i < 5; i ++) {
         try {
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   @Override
   public  void run() {
      method();
   }
}
