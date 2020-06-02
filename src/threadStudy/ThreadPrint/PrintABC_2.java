package threadStudy.ThreadPrint;

public class PrintABC_2 {
    int count = 1;
    Object lock = new Object();
    public static void main(String[] args) {
        PrintABC_2 printABC_2 = new PrintABC_2();
        new Thread(printABC_2.new Print(0)).start();
        new Thread(printABC_2.new Print(1)).start();
        new Thread(printABC_2.new Print(2)).start();
    }
    class Print implements Runnable{
        int index;
        @Override
        public void run() {
            while (count < 100){
                synchronized (lock){
                    if(count % 3 == index ){
                        switch (index){
                            case 0 : {
                                System.out.println(Thread.currentThread().getName() + ":" + "A" + count);
                                break;
                            }
                            case 1 : {
                                System.out.println(Thread.currentThread().getName() + ":" + 'B' + count);
                                break;
                            }
                            case 2: {
                                System.out.println(Thread.currentThread().getName() + ":" + 'C' + count);
                                break;
                            }
                        }
                        count++;
                        lock.notifyAll();
                    }
                    else {
                        try{

                            lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        public Print(int index){
            this.index = index;
        }
    }
}
