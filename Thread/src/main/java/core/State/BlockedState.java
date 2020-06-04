package core.State;


/**
 * 此状态表示线程正在等待进入一个同步的代码块或者方法的监视器锁
 * blocked状态的线程不会被cpu分配时间片
 * 线程处于blocked状态的两种可能情况：
 *
 *线程正在等待一个监视器锁，只有获取监视器锁之后才能进入synchronized代码块或者synchronized方法，在此状态的获取锁的过程都处于阻塞状态
 * 线程x 步入synchronized代码块或者方法（线程x已经释放锁），调用Object.wait()方法时候进行阻塞，当接收其他线程T调用该锁对象，
 * notify或者notifyAll()，但是线程T尚未退出他所在的代码块或者方法，那么线程X任处于阻塞状态
 */
public class BlockedState {

   public void BlockedOfState(){



   }


}
