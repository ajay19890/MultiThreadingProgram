package alternator3threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by awadha on 10/25/2016.
 */
public class ThreadTask implements Runnable {
    private AtomicInteger num;
    private final int threadPosition;

    public ThreadTask(AtomicInteger num, int pos){
        this.num = num;
        threadPosition = pos;
    }

    @Override
    public void run() {
        try{
            while(num.get() < 21){
                synchronized (num){
                    if(num.get() % 3 == this.threadPosition){
                        System.out.println("Thread " + Thread.currentThread().getName() + " value: " +num.incrementAndGet());
                        num.notifyAll();
                    }else
                        num.wait();
                }

            }
        }catch(InterruptedException e){

        }

    }
}
