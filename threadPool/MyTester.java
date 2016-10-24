package threadPool;

import java.util.Random;

/**
 * Created by awadha on 10/21/2016.
 */
public class MyTester {
    public static void main(String ...args){
        int size = 10;
        MyThreadPool pool = new MyThreadPool(size);
        for(int i=1;i<=size;i++){
            pool.addTask(() ->{
                System.out.println("Number Generated ->" + new Random().nextInt(10));
            });
        }

        pool.execute();
        pool.shutDownNow();
    }
}
