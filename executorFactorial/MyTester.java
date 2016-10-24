package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by awadha on 10/24/2016.
 */
public class MyTester {
    private List<Integer> inList = new ArrayList<>(100);

    public void prepareData(){
        for(int i=0;i<100;i++){
            inList.add(new Random().nextInt(10));
        }
    }

    public static void main(String ...args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyTester myTester = new MyTester();
        myTester.prepareData();

        for(int i=0;i<myTester.getInList().size();i++){
            FactorialCalculator factorialCalculator = new FactorialCalculator(myTester.getInList().get(i));
            executorService.submit(factorialCalculator);

        }

    }

    public List<Integer> getInList() {
        return inList;
    }

    public void setInList(List<Integer> inList) {
        this.inList = inList;
    }
}
