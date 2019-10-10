package Volatile;

/**
 * @ClassName UnsafeVolatile
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/10 11:03
 **/
public class UnsafeVolatile {
    private static volatile int trace = 0;

    public static void increase() {
        trace++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
        Thread.sleep(2000L);

        System.out.println(trace);
    }

}
