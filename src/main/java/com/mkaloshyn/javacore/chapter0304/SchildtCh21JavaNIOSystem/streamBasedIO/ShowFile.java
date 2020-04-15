package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.streamBasedIO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;

        try (InputStream fin = Files.newInputStream(Paths.get("src\\main\\resources\\test.txt"))) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (IOException e) {
            System.out.println("Input-output error: " + e);
        }
    }
}
