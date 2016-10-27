package delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by awadha on 10/27/2016.
 */
public class MyDelayQueue {

    public static void main(String ...args){
        DelayedElement myDelay1 = new DelayedElement(3000, "Message with 3s delay");
        DelayedElement myDelay2 = new DelayedElement(1000, "Message with 1s delay");
        DelayedElement myDelay3 = new DelayedElement(2000, "Message with 2s delay");


        DelayQueue dq = new DelayQueue();
        dq.offer(myDelay1);
        dq.offer(myDelay2);
        dq.offer(myDelay3);

        try{
            System.out.println(dq.take());
            System.out.println(dq.take());
            System.out.println(dq.take());
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
