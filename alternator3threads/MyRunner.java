package alternator3threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by awadha on 10/24/2016.
 */
public class MyRunner {

    public static void main(String []args){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ThreadTask tt1 = new ThreadTask(atomicInteger, 0);
        ThreadTask tt2 = new ThreadTask(atomicInteger, 1);
        ThreadTask tt3 = new ThreadTask(atomicInteger, 2);
        Thread t1 = new Thread(tt1);Thread t2 = new Thread(tt2);
        Thread t3 = new Thread(tt3);
        t1.setName("1");t2.setName("2");t3.setName("3");
        t1.start();t2.start();t3.start();

    }
}
