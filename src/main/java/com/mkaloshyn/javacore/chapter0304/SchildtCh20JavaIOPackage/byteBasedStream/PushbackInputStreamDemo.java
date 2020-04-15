package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.byteBasedStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {

    public static void main(String[] args) {
        String s = "if (a==4) a=0;\n";
        byte[] buf = s.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;

        try (PushbackInputStream pb = new PushbackInputStream(in)) {
            while ((c = pb.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = pb.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<-");
                            pb.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
