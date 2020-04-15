package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.charBasedStream;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] buf = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);

        int c;

        try (CharArrayReader input1 = new CharArrayReader(buf)) {
            System.out.println("First: ");
            while ((c = input1.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }

        try (CharArrayReader input2 = new CharArrayReader(buf, 0, 5)) {
            System.out.println("\nSecond: ");
            while ((c = input2.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
