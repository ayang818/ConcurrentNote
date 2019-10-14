package Lock;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockDemo
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/14 18:35
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) throws IOException {
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();
    }
}
