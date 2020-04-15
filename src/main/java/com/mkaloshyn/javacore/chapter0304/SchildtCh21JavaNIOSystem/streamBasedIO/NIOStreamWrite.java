package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.streamBasedIO;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        try (OutputStream fout =
                     new BufferedOutputStream(
                             Files.newOutputStream(Paths.get("test6.txt")))) {
            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
