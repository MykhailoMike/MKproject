package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.byteBasedStream;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamReset {
    public static void main(String[] args) {
        String str = "abc";
        byte[] b = str.getBytes();
        System.out.println(b.length);
        ByteArrayInputStream in = new ByteArrayInputStream(b);

        for (int i = 0; i < 5; i++) {
            int c;
            while ((c = in.read()) != -1) {
                if (i == 0) {
                    System.out.print((char) c);
                } else {
                    System.out.print(Character.toUpperCase((char) c));
                }
            }
            System.out.println();
            in.reset();
        }
    }
}
