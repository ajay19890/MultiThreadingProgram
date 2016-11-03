package ConcurrentCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by awadha on 11/3/2016.
 */
public class MainApp {

    public static void main(String... args) throws InterruptedException{
        Counter counter  = new Counter(0);
        Runnable runnable = ()->{
            for(int i=0; i<10;i++){
                counter.getAndIncrement();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();t2.start();

        Thread.sleep(2000);

        System.out.println("Final value:" + counter.getCurrentValue());

    }

}