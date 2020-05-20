package core.create;

import java.util.stream.IntStream;

/**
 * 实现创建线程的三种方法
 */
public class CreateThreadByExtendsThread {

   public static class ThreadRun extends Thread{

       public void run(){
           IntStream.range(0,10).forEach(i->System.out.println(Thread.currentThread()+"-"+i));
       }

    }

    public static void main(String[] args){
        ThreadRun t1 = new ThreadRun();

       t1.start();
    }
}
