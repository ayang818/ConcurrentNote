package CloseLock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTaskPreloader
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/28 14:12
 **/
public class FutureTaskPreloader {
    private final FutureTask<Object> future = new FutureTask<>(new Callable<Object>() {
        @Override
        public Object call() throws Exception {
            return loadProductList();
        }
    });
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public Object get() throws ExecutionException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoaderException) {
                throw (DataLoaderException) cause;
            } else {
                throw laundeThrowable(cause);
            }
        }
    }

    private RuntimeException laundeThrowable(Throwable cause) {
        if (cause instanceof RuntimeException) {
            return (RuntimeException) cause;
        } else if (cause instanceof Error) {
            throw (Error) cause;
        } else {
            throw new IllegalStateException("Not unchecked", cause);
        }
    }

    public static void main(String[] args) {

    }
}
