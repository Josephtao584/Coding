package threadStudy.threadPool;

import java.util.concurrent.*;

public class CacheThreadPool {
    static class TaskDemo implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        threadPoolExecutor.submit(new TaskDemo());
        threadPoolExecutor.shutdown();
    }
}
