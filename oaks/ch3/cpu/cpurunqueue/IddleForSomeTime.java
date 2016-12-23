package ch3.cpu.cpurunqueue;

import static java.lang.System.out;
import java.util.*;
import java.util.concurrent.Callable;

/**/
public class IddleForSomeTime implements Callable<String> {
  /**/
  public String call() throws InterruptedException {
    int ms = new Random().nextInt(10_000);
    out.println(Thread.currentThread().getName() + " waiting for " + ms + " ms");
    return "done";
  }
}
