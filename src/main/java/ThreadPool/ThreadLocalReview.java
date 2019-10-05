package ThreadPool;

import java.util.Optional;

public class ThreadLocalReview {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        });
        thread.start();
        ThreadLocal<String> strThreadLocal = ThreadLocal.withInitial(() -> {
            return "hello";
        });
    }
}