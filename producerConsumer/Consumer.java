package producerConsumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by awadha on 10/21/2016.
 */
public class Consumer {
    LinkedList<Integer> list = new LinkedList<>();
    private Random random = new Random();
    private Object lock;

    public Consumer(LinkedList<Integer> list, Object lock){
        this.list = list;
        this.lock = lock;

    }

    public void consume(){
        try{
            while(true){
                synchronized (lock){
                    Thread.sleep(500);
                    if(list.size() >0){
                        Integer removedItem = list.poll();
                        System.out.println("Consumer consumed " + removedItem);
                        lock.notify();
                    }else{
                        lock.wait();
                    }
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
