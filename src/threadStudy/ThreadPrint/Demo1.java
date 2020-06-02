package threadStudy.ThreadPrint;

/**
 * 三个线程循环打印，使用volatile实现
 */
public class Demo1 {
    private volatile static int count = 1;
    class Print implements Runnable{
        int val;
        @Override
        public void run(){
            while (count < 100)
                if(count % 3 == val){
                    System.out.println(Thread.currentThread().getName() + "打印 ：" + count);
                    count = count + 1;
                }
        }
        Print(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < 3; i++) {
            new Thread(demo1. new Print(i)).start();
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
