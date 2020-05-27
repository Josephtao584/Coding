package threadStudy.producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 使用ReentrantLocke实现生产者消费者模式
 */
public class Demo2 {
    private static int count = 0;
    private static final int FULL = 10;
    private Lock lock = new ReentrantLock();
    private final Condition nouFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2.new Producer()).start();
        new Thread(demo2.new Consumer()).start();
        new Thread(demo2.new Producer()).start();
        new Thread(demo2.new Consumer()).start();
        new Thread(demo2.new Producer()).start();
        new Thread(demo2.new Consumer()).start();
        new Thread(demo2.new Producer()).start();
        new Thread(demo2.new Consumer()).start();

    }
    class Producer implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == FULL) {
                        nouFull.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产, count = " + count);
                    notEmpty.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }
            lock.lock();
            try{
                while (count == 0){
                    notEmpty.await();
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费, count = " + count);
                nouFull.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }}

    }
}
