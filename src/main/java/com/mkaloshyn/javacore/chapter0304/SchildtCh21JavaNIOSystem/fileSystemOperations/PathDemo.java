package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.fileSystemOperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("src/main/resources/Copyright1/test5.txt");

        System.out.println("Filename: " + filepath.getName(4));
        System.out.println("Path to the file: " + filepath);
        System.out.println("Absolute path to the file: " + filepath.toAbsolutePath());
        System.out.println("Parent directory: " + filepath.getParent());

        if (Files.exists(filepath)) {
            System.out.println("File exists!");
        } else {
            System.out.println("File does not exist!");
        }

        try {
            if (Files.isHidden(filepath)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File is not hidden");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Files.isWritable(filepath))
        System.out.println("File is available to write in");

        if (Files.isReadable(filepath))
        System.out.println("File is available to read from");

        try {
            BasicFileAttributes attribs = Files.readAttributes(filepath, BasicFileAttributes.class);

            if (attribs.isDirectory()) {
                System.out.println("It is directory");
            } else {
                System.out.println("It is not a directory");
            }

            if (attribs.isRegularFile()) {
                System.out.println("It is regular file");
            } else {
                System.out.println("It is not a regular file");
            }

            if (attribs.isSymbolicLink()) {
                System.out.println("This is symbolic link");
            } else {
                System.out.println("It is not symbolic link");
            }

            System.out.println("The last file modification: " + attribs.lastModifiedTime());
            System.out.println("The size (in bytes): " + attribs.size());
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}
