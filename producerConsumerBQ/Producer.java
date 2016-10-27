package producerConsumerBQ;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by awadha on 10/26/2016.
 */
public class Producer implements Runnable{

    private BlockingQueue<Integer> queue;
    private Object lock;

    public Producer(BlockingQueue queue, Object lock){
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(300);
                Random random = new Random();
                int val = random.nextInt(100);
                System.out.println("Produced value is:" + val);
                queue.add(val);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
