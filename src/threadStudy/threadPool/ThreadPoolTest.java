package threadStudy.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
    }
}
