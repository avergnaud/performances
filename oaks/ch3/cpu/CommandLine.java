package ch3.cpu;

import static java.lang.System.out;
import java.io.Console;
import ch3.cpu.cpurunqueue.*;

/**/
public class CommandLine {
  public static void main(String... args) {
    /* check if Console is available */
    Console console = System.console();
    if(console == null) {
      out.println("no console");
    }

    /* wait for user input "start" */
    String userInput = null;
    while(!"start".equalsIgnoreCase(userInput)) {
      userInput = console.readLine("start ? [start]");
    }

    /* */
    LotsOfThreads.start();
    out.println("started");

    /* wait for user input "stop" */
    userInput = null;
    while(!"stop".equalsIgnoreCase(userInput)) {
      userInput = console.readLine("stop ? [stop]");
    }

    /*  */
    LotsOfThreads.stop();
    out.println("stoped");
  }
}
