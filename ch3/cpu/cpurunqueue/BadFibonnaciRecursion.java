package ch3.cpu.cpurunqueue;

import static java.lang.System.out;
import java.util.*;
import java.util.concurrent.Callable;

/**/
public class BadFibonnaciRecursion implements Callable<Long> {
  public Long call() {
    long l = new Random().nextInt(40);
    out.println(Thread.currentThread().getName() + " computing Fibonnaci Number for " + l + " ms");
    return fibonacciRecusion(l);
  }

  private long fibonacciRecusion(long number) {
  		if (number == 1 || number == 2) {
  			return 1;
  		}
  		return fibonacciRecusion(number - 1) + fibonacciRecusion(number - 2);
  	}

}
