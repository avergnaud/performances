package ch3.cpu.cpurunqueue;

import static java.lang.System.out;
import java.util.concurrent.*;
import ch3.cpu.cpurunqueue.*;

/**/
public class LotsOfThreads {

  static ExecutorService service;

  /**/
  public static void start() {
    service = Executors.newFixedThreadPool(100);
    for(int i=0;i<1_000;i++) {
      service.submit(new BadFibonnaciRecursion());
    }
  }

  public static void stop() {
    if(service != null) {
      service.shutdown();
    }
  }
}
