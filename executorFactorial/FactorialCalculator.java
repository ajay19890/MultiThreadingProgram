package executor;

import java.util.concurrent.Callable;

/**
 * Created by awadha on 10/24/2016.
 */
public class FactorialCalculator implements Callable<Integer>{

    private int number;


    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
        return result;
    }

    public int factorial(int number){
        int result;
        if(number == 0 || number ==1){
            return 1;
        }
        result = number* factorial(number-1);
        return result;

    }
}
