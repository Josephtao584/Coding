package threadStudy.producerAndConsumer;

import javax.swing.*;

/**
 * 使用synchronized实现生产者消费者模型
 */
public class Demo1 {
    private static int count = 0;
    private static final int FULL = 10;
    private static final String LOCK = "lock";

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        new Thread(demo1.new Producer()).start();
        new Thread(demo1.new Consumer()).start();
        new Thread(demo1.new Producer()).start();
        new Thread(demo1.new Consumer()).start();
        new Thread(demo1.new Producer()).start();
        new Thread(demo1.new Consumer()).start();

    }

    class Producer implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + " 生产者，目前共有：" + count);
                    LOCK.notifyAll();
                }
            }

        }
    }

    class Consumer implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == 0){
                        try {
                            LOCK.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有："  + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
