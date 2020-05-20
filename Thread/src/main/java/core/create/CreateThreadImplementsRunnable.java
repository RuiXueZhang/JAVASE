package core.create;

import java.util.stream.IntStream;

public class CreateThreadImplementsRunnable {

    public static class ThreadRun implements Runnable{

        @Override
        public void run() {
            IntStream.range(1,10).forEach(i -> System.out.println(Thread.currentThread()+"-"+i));
        }
    }

    public static void main(String[] args){
        ThreadRun t1 = new ThreadRun();
        new Thread(t1).start();
    }
}
