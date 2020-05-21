package core.State;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;


public class WaitingState {

    /**
     * waiting是无限等待的状态，这种状态下的线程不会被分配cpu执行时间，当一个线程执行了某些方法后就会进入无限等待状态
     * 直到被显示唤醒，被唤醒后，线程状态由wating转变为runnable然后继续执行
     *
     * 以下介绍进入waiting状态的方法
     */

    @Test
    public void waitOfWaiting(){

        Thread thread = new Thread(()->{
            //IntStream.rangeClosed(1,1000).forEach(i->System.out.println(Thread.currentThread()+"-"+i));
            try {
                //线程进入waiting状态的方法
                //Object.wait();
                wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
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
                while (true){
                    Thread.yield();
                }
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
