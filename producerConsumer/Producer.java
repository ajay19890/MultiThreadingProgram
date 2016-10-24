package producerConsumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by awadha on 10/21/2016.
 */
public class Producer {
    private LinkedList<Integer> list;
    private Random random = new Random();
    private Object lock;

    public Producer(LinkedList<Integer> list, Object lock){
        this.list = list;
        this.lock = lock;
    }

    public void produce(){
        try{
            while(true){
                Thread.sleep(300);
                synchronized (lock){
                    if(list.size() == 10){
                        lock.wait();
                    }else{
                        int producedItem = random.nextInt(100);
                        list.add(producedItem);
                        System.out.println("Producer produced " + producedItem);
                        lock.notify();
                    }
                }

            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
