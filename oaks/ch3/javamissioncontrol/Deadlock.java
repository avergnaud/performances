package oaks.ch3.deadlock;

import static java.lang.System.out;
import java.util.concurrent.*;

public class Deadlock {

  static Object first = new Object();
  static Object second = new Object();

  /*callable*/
  static String lockFirstThenSecond() throws InterruptedException {
    synchronized(first) {
      out.println("lockFirstThenSecond: got first");
      Thread.sleep(50);
      synchronized(second) {
        return "done";
      }
    }
  }

/*callable*/
  static String lockSecondThenFirst() throws InterruptedException {
    synchronized(second) {
      out.println("lockSecondThenFirst: got second");
      Thread.sleep(50);
      synchronized(first) {
        return "done";
      }
    }
  }

  public static void main(String... args) {
    ExecutorService es = Executors.newCachedThreadPool();
    try {
      es.submit(Deadlock::lockFirstThenSecond);
        es.submit(Deadlock::lockSecondThenFirst);
    } finally {
      es.shutdown();
    }

  }

}
