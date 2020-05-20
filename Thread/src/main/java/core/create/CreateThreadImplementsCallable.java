package core.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CreateThreadImplementsCallable {

    public static class ThreadRun implements Callable{

        @Override
        public Integer call() throws Exception {
            AtomicInteger count = new AtomicInteger();
            IntStream.rangeClosed(0,10).forEach(i -> {
                        System.out.println(Thread.currentThread() + "-" + i);
                        count.getAndIncrement();
                    }
                );
            return count.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadRun t1=  new ThreadRun();

        FutureTask<Integer> futureTask = new FutureTask<>(t1);

        //new Thread(futureTask).start();

        IntStream.rangeClosed(0,10).forEach(i -> {
            System.out.println(Thread.currentThread() + "-" + i);
            if(i==8){
                new Thread(futureTask).start();
            }
        });
        System.out.println(futureTask.get());

    }
}
