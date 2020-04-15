package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.fileSystemOperations;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "src/main/resources";
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("Directory: " + dirname);
            for (Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory()) {
                    System.out.print("<DIR>");
                } else {
                    System.out.print("     ");
                }
                System.out.println(entry.getName(3));
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid path: " + e);
        } catch (NotDirectoryException e) {
            System.out.println("This is not directory: " + e);
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
