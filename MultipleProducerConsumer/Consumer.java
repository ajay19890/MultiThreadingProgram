package producerConsumerBQ;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * Created by awadha on 10/26/2016.
 */
public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private Object lock;

    public Consumer(BlockingQueue queue, Object lock){
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(800);
                int val = queue.take();
                System.out.println("Consumed value by" + Thread.currentThread().getName() + " is:" + val);
            }
        }catch(Exception e){

        }

    }
}
