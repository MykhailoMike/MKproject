package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh13IOandAplets;

import java.io.FileInputStream;
import java.io.IOException;

public class ShowFile {

    public static void main(String[] args) {
        int i;

        try (FileInputStream fin = new FileInputStream("src\\main\\resources\\test.txt")) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Input-output error: " + e);
        }
    }
}
