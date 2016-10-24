package threadPool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by awadha on 10/21/2016.
 */
public class MyThread extends Thread {
    BlockingQueue<Runnable> queue;

    public MyThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(MyThreadPool.running){
                queue.take().run();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
