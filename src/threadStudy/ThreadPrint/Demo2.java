package threadStudy.ThreadPrint;

public class Demo2 {
    private static int count = 50;
    Object lock = new Object();
    class printThread implements Runnable{
        int val;
        @Override
        public void run(){
            while (count < 100){
                synchronized (lock){
                    if(count % 3 == val){
                        System.out.println(Thread.currentThread().getName() +":" + count);
                        count++;
                        lock.notifyAll();
                    }else{
                        try{
                           lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        printThread(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            new Thread(demo2.new printThread(i)).start();
        }
    }
}
