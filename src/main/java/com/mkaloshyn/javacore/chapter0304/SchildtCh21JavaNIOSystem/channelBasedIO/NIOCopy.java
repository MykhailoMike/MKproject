package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.channelBasedIO;

import java.io.IOException;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        try {
            Path source = Paths.get("test4.txt");
            Path target = Paths.get("src/main/resources/Copyright1/test5.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
