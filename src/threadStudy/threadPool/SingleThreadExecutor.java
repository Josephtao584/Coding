package threadStudy.threadPool;

import java.util.concurrent.*;

public class SingleThreadExecutor {
    static class TaskDemo implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.execute(new TaskDemo());
        threadPoolExecutor.shutdown();
    }
}
