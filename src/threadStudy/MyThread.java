package threadStudy;

public class MyThread extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            // Thread.yield();
            count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime));
    }
}
