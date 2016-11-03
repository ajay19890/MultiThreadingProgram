package producerConsumerBQ;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by awadha on 10/21/2016.
 */
public class MainClass {
    public static void main(String ...args){
        final Object lock = new Object();
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(20);

        //Multiple producer
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            service.submit(new Producer(bq, lock));
        }

        //Multiple consumer
        ExecutorService service2 = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            service2.submit(new Consumer(bq, lock));
        }
    }
}
