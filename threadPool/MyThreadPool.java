package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by awadha on 10/21/2016.
 */
public class MyThreadPool {
    BlockingQueue<Runnable> queue  = new LinkedBlockingQueue<Runnable>();
    int numberOfThreads;
    public static boolean running = true;

    public MyThreadPool(int num){
        numberOfThreads = num;
    }

    public void addTask(Runnable r){
        queue.add(r);
    }

    public void execute(){
        for(int i=1;i<=numberOfThreads;i++){
            MyThread thread = new MyThread(queue);
            thread.start();
        }
    }

    public void shutDownNow(){
        running = false;
    }

}
