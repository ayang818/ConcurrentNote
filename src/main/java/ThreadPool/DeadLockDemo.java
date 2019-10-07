package ThreadPool;

import java.util.concurrent.*;

/**
 * @ClassName DeadLockDdemo
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/7 17:55
 **/
public class DeadLockDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService singleExecutor = Executors.newFixedThreadPool(10);
        Callable<String> task1 = () -> "hello";
        Callable<String> task2 = () -> singleExecutor.submit(task1).get();
        String neverShowAns2 = singleExecutor.submit(task1).get();
        String neverShowAns = singleExecutor.submit(task2).get();
        System.out.println(neverShowAns);
        System.out.println(neverShowAns2);
        FutureTask
    }
}
