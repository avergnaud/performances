package oaks.ch3.io;

import java.io.*;

/* */
public class Bad {
  public static void main(String... args) throws IOException {

      /* no buffer */
      try(FileOutputStream fos = new FileOutputStream("bad.txt")) {
        for(int i=0;i<20_000_000;i++) {
          fos.write(i%100);
        }
      }
  }
}
