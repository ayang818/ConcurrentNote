package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {
    static class CustomizeThreadFactory implements ThreadFactory {
        private final String poolName ;

        public CustomizeThreadFactory(String name) {
            this.poolName = name;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new CustomizeThread(r);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Executors.newCachedThreadPool();
//        Executors.newScheduledThreadPool(10);
//        Executors.newFixedThreadPool(10);
//        Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 100,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolDemo.CustomizeThreadFactory("calc-pool"),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Callable<Integer> task = () -> {
            Integer ans = 0;
            for (int i = 0; i <= 100; i++) {
                ans += i;
            }
            return ans;
        };
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> submit = threadPoolExecutor.submit(task);
            list.add(submit);
        }

        Integer ans = 0;
        for (Future<Integer> integerFuture : list) {
            ans += integerFuture.get();
        }

        System.out.println(ans);
        threadPoolExecutor.shutdown();
    }
}

class CustomizeThread extends  Thread {
    private static final String DEFAULT_NAME = "CustomizeThread";
    private static AtomicInteger created = new AtomicInteger();
    private static AtomicInteger alived = new AtomicInteger();
    private Runnable target;

    CustomizeThread(Runnable runnable) {
        super(runnable, DEFAULT_NAME + "-" + created.incrementAndGet());
        target = runnable;
        setUncaughtExceptionHandler((t, e) -> {

        });
    }

    @Override
    public void run() {
        try  {
            target.run();
            alived.incrementAndGet();
        } finally {
            alived.decrementAndGet();
        }
    }
}