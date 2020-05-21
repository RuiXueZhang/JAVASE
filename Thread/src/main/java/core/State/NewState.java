package core.State;

import java.util.stream.IntStream;


/**
 *   Thread state for a thread which has not yet started.
 *
 *    NEW,
 */
public class NewState {

    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                IntStream.rangeClosed(1,10).forEach(i -> System.out.println(Thread.currentThread()+"-"+i));
            }
        });

        //只创建了线程未启动（未调用start方法）
        System.out.println(thread.getState());
    }


}
