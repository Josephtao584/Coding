package threadStudy.threadPool;

import java.util.concurrent.*;

public class FixThreadPool {
    static class TaskDemo implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        TaskDemo taskDemo = new TaskDemo();
        executorService.execute(taskDemo);
        executorService.shutdown();
    }
}
