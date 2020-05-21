package core.State;


/**
 * Thread state for a runnable thread.  A thread in the runnable
 * state is executing in the Java virtual machine but it may
 * be waiting for other resources from the operating system
 * such as processor.
 *
 * RUNNABLE
 */
// 可运行状态下的线程状态，可运行状态的线程正在java虚拟机中运行，但可能等待操作系统中其他资源的释放，例如： 处理器

public class RunnableState {

    /**
     * Runnable状态有两个子状态，Ready和Running
     * Ready状态的线程是没有被操作系统分配时间片的线程，当被线程调度器调度的时候就转为Running状态
     *Running状态的线程正在运行，线程对象run方法中的代码正在被cpu执行
     * @param args
     */

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (true){
                //yield方法被调用，表示该线程放弃当前时间片，
                Thread.yield();
            }
        });

        thread.start();
        Thread.sleep(2000);

        System.out.println(thread.getState());


    }
}
