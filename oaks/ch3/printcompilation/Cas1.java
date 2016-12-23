package ch3.printcompilation;

import static java.lang.System.out;

public class Cas1 {
  public static void main(String... args) {
    if(args.length != 2) {
      out.println("input number of calls and max");
      return;
    }
    int first = Integer.parseInt(args[0]);
    int second = Integer.parseInt(args[1]);
    for(int i=0;i<first;i++) {
      int result = someMethod(second);
    }
  }

  static int someMethod(int max) {
    int sum = 0;
    for(int i=0;i<max;i++) {
      sum += i;
    }
    return sum;
  }
}
