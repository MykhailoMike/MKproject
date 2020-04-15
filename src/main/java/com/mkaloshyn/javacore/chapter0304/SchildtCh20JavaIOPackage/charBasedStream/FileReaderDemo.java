package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.charBasedStream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("src/main/java/com/mkaloshyn/javacore/chapter0304/SchildtCh20JavaIOPackage/charBasedStream/FileReaderDemo.java")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
