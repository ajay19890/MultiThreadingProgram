package producerConsumerBQ;

import jdk.nashorn.internal.ir.Block;
import producerConsumer.Consumer;
import producerConsumer.Producer;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by awadha on 10/21/2016.
 */
public class MainClass {
    public static void main(String ...args){
        final Object lock = new Object();
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);

        Thread t1 = new Thread(new producerConsumerBQ.Producer(bq, lock));

        Thread t2 = new Thread(new producerConsumerBQ.Consumer(bq, lock));

        t1.start();t2.start();
    }
}
