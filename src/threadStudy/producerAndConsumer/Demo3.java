package threadStudy.producerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockingQueue实现生产者消费者模式
 */
public class Demo3 {
    private static int count = 0;
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        for (int i = 0; i < 3; i++) {
            new Thread(demo3.new Producer()).start();
            new Thread(demo3.new Consumer()).start();
        }
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
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产, count = " + count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() +"消费者消费, count = " + count);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
