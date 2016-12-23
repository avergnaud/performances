package oaks.ch3.io;

import java.io.*;

/* */
public class Better {
  public static void main(String... args) throws IOException {

      /* no buffer */
      try(BufferedOutputStream bos = new BufferedOutputStream
          (new FileOutputStream("better.txt"))) {
        for(int i=0;i<20_000_000;i++) {
          bos.write(i%100);
        }
      }
  }
}
