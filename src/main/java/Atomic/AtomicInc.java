package Atomic;

import java.util.concurrent.locks.Lock;

public class AtomicInc {

    private static volatile int num = 0;
    private static LockHelper lockHelper = new LockHelper();

    public static synchronized void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        num++;
                    }
                }
            }).start();
        }
        Thread.sleep(6000);
        System.out.println(num);
    }
}
