package Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReadAndWriteLockDemo
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/14 20:18
 **/
public class ReadAndWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock readAndWriteLock = new ReentrantReadWriteLock();
    }
}
