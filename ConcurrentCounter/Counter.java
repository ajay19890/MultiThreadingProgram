package ConcurrentCounter;

import java.net.Inet4Address;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by awadha on 11/3/2016.
 */
public class Counter {

    private volatile int value;

    public Counter(Integer initialValue){
        value = initialValue;
    }


    public Integer getCurrentValue(){
        return value;
    }

    public synchronized Integer getAndIncrement(){
        return ++value;
    }

    public synchronized Integer incrementAndGet(){
        return value++;
    }
}
