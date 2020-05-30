package threadStudy.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        ExecutorService cacheThreadPool = Executors.newFixedThreadPool(2);
        cacheThreadPool.submit(threadPoolTest.new MyRunnable());
        cacheThreadPool.submit(threadPoolTest.new MyRunnable());
    }
    class MyRunnable implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
