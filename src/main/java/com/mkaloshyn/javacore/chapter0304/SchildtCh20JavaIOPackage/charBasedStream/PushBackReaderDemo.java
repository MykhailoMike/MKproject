package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.charBasedStream;

import java.io.*;

public class PushBackReaderDemo {
    public static void main(String[] args) {
        String s = "if (a==4) a=0;\n";
        char[] ch = new char[s.length()];
        s.getChars(0, s.length(), ch, 0);
        CharArrayReader in = new CharArrayReader(ch);

        int c;

        try (PushbackReader f = new PushbackReader(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = f.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<-");
                            f.unread(c);
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
