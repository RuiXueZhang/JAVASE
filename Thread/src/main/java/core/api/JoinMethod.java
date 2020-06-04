package core.api;


/**
 * 问题描述：
 * T1,T2,T3三个线程，如何使T2在T1执行完后执行，T3在T2执行完后执行
 */
public class JoinMethod {

    /**
     * Thread.join()方法
     *表示等待该线程结束，再继续执行
     * 例如：
     * 在B线程中调用A线程，等待A线程结束后，再执行B线程，A线程在B线程结束之前结束
     */

    public static void method1() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 thread finished");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 thread finished");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 thread finished");
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }

    public static void main(String[] args){

        //验证join()方法的功能
          method1();
    }

}
