package threadStudy;

public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");

        a.start();

    }
}
