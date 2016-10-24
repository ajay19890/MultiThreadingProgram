package producerConsumer;

import java.util.LinkedList;

/**
 * Created by awadha on 10/21/2016.
 */
public class MainClass {
    public static void main(String ...args){
        Object lock = new Object();
        LinkedList<Integer> ll = new LinkedList<>();
        Producer producer = new Producer(ll, lock);
        Consumer consumer = new Consumer(ll, lock);

        Thread t1 = new Thread(() -> {
           producer.produce();
        });

        Thread t2 = new Thread(() -> {
            consumer.consume();
        });

        t1.start();t2.start();
        /*try{
            t1.join();t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }*/

    }
}
