package CloseLock;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchGate
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/28 11:20
 **/
public class CountDownLatchGate {

    public static void main(String[] args) throws InterruptedException {
        Long aLong = timeTasks(2);
    }

    public static Long timeTasks(Integer taskNum) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(taskNum);
        for (int i = 0; i < taskNum; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() +" is ready");
                    startGate.await();
                    try {
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " thread is start");
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        return end - start;
    }
}
