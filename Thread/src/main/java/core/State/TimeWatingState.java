package core.State;

import org.junit.Test;

/**
 * 定义了具体等待时间的等待中的线程状态，一个线程进入该状态是由于调用了指定了超时时间的下列方法之一：
 *
 * Thread.sleep()
 * 带超时的Object.wait()
 * 带超时的Thread.join()
 * LockSupport.parkNanos()
 * LoclSupport.parkUntil()
 */
public class TimeWatingState {

    @Test
     public void SleepOfTimeWating() throws InterruptedException {

         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(2000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         });

         thread.start();
         Thread.sleep(20);
         System.out.println(thread.getState());
     }


}


