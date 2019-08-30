package Lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * JameLock
 */
public class LockHelper implements Lock {
    AtomicReference<Thread> owner = new AtomicReference<>();
    private LinkedBlockingQueue<Thread> waiter = new LinkedBlockingQueue<>();

    @Override
    public boolean tryLock() {
        return owner.compareAndSet(null, Thread.currentThread());
    }

    @Override
    public void lock() {
        if (!tryLock()) {
            waiter.offer(Thread.currentThread());
            // 自旋
            for (;;) {
                Thread head = waiter.peek();
                if (head == Thread.currentThread()) {
                    if (!tryLock()) {
                        // 挂起线程
                        // wait / notify 需要配合synchronized在这里不可行
                        LockSupport.park();
                    } else {
                        // 抢锁成功
                        waiter.poll();
                        return;
                    }
                } else {
                    // 线程挂起
                    LockSupport.park();
                }
            }
        }
    }

    public boolean tryUnlock() {
        if (owner.get() != Thread.currentThread()) {
            throw new IllegalMonitorStateException();
        } else {
            return owner.compareAndSet(Thread.currentThread(), null);
        }
    }

    @Override
    public void unlock() {
        if (tryUnlock()) {
            Thread th = waiter.peek();
            if (th != null) {
                // unpark是唤醒线程
                LockSupport.unpark(th);
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
