package core.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 用ReadWriteLock读写锁来实现一个高效的Map缓存 *
 */
public class LockAndSynchronized<K, V> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Map<K, V> map;

    public LockAndSynchronized(Map<K, V> map) {
        this.map = map;
    }

    /*************   这是用lock()方法写的   ********************///
    public V putLock(K key, V value) {
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }

    }

    public V getLock(K key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    //    /*************   这是用tryLock()方法写的   ********************/
    public V putTryLock(K key, V value) {
        while (true) {
            if (writeLock.tryLock()) {
                try {
                    System.out.println("put " + key + " = " + value);
                    return map.put(key, value);
                } finally {
                    writeLock.unlock();
                }
            }
        }
    }

    public V getTryLock(K key) {
        while (true) {
            if (readLock.tryLock()) {
                try {
                    V v = map.get(key);
                    System.out.println("get " + key + " = " + v);
                    return v;
                } finally {
                    readLock.unlock();
                }
            }
        }
    }

    static class TestRunnable implements Runnable {
        private final LockAndSynchronized<String, Integer> rw;
        private final String KEY = "x";

        TestRunnable(LockAndSynchronized<String, Integer> rw) {
            this.rw = rw;
        }

        @Override
        public void run() {
            Random random = new Random();
            int r = random.nextInt(100);
            // 生成随机数，小于30的写入缓存，大于等于30则读取数字
            if (r < 30) {
                rw.putLock(KEY, r);
            } else {
                rw.getLock(KEY);
            }
        }
    }
    //    /********************    下面是测试区       *********************************/
    public static void main(String[] args) {
        final LockAndSynchronized<String, Integer> rw = new LockAndSynchronized<>(new HashMap<>());
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new TestRunnable(rw));
        }
        exec.shutdown();
    }


}

