package lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    public AtomicReference<Thread> cas = new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        while (!cas.compareAndSet(null, current)){
            //Do nothing;
        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
