package threadStudy.ThreadPrint;

public class PrintABC_1 {
    static volatile int index = 0;
    class Print implements Runnable{
        int count;
        @Override
        public void run() {
            while (index < 100){
                if(index % 3 == count){
                    switch (count){
                        case 0 : {
                            System.out.println(Thread.currentThread().getName() + ":" + "A");
                            index++;
                            break;
                        }
                        case 1 : {
                            System.out.println(Thread.currentThread().getName() + ":" + 'B');
                            index++;
                            break;
                        }
                        case 2: {
                            System.out.println(Thread.currentThread().getName() + ":" + 'C');
                            index++;
                            break;
                        }
                    }
                }
            }

        }
        Print(int count){
            this.count = count;
        }
    }

    public static void main(String[] args) {
        PrintABC_1 printABC_1 = new PrintABC_1();
        Thread a = new Thread(printABC_1.new Print(0));
        Thread b = new Thread(printABC_1.new Print(1));
        Thread c = new Thread(printABC_1.new Print(2));
        a.start();
        b.start();
        c.start();

    }
}
