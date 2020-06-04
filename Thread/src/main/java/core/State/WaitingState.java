package core.State;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

/**
 * 等待线程的状态
 * 一个线程进入等待状态是由于调用了下面方法之一
 *
 * 不带超时时间的Object.wait()
 * 不带超时时间的Thread.wait()
 * LockSupport.park()
 * 一个处于等待状态的线程是在等待另一个线程进行一些特殊的处理
 *
 */
public class WaitingState {

    /**
     * waiting是无限等待的状态，这种状态下的线程不会被分配cpu执行时间，当一个线程执行了某些方法后就会进入无限等待状态
     * 直到被显示唤醒，被唤醒后，线程状态由wating转变为runnable然后继续执行
     *
     * 以下介绍进入waiting状态的方法
     */
    public void waitOfWaiting() throws InterruptedException {

        Thread thread = new Thread(()->{
            //IntStream.rangeClosed(1,1000).forEach(i->System.out.println(Thread.currentThread()+"-"+i));
            //线程进入waiting状态的方法
            //Object.wait();
            while (true) {
                Thread.yield();
            }
        });

        thread.start();
        thread.wait(2000);
        System.out.println(thread.getState());
    }

    @Test
    public void joinOfWating() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                IntStream.rangeClosed(1,10).forEach(i -> System.out.println(Thread.currentThread()+"-"+i));
            }
        }
        );

        Thread waiting = new Thread(() -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );

        waiting.start();
        Thread.sleep(50);
        System.out.println(waiting.getState());
    }

    @Test
    public void LockSupportOfWating() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                while (true){
                    Thread.yield();
                }
            }
        });

        thread.start();
        Thread.sleep(50);
        System.out.println(thread.getState());

    }

}
