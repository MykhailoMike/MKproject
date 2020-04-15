package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh21JavaNIOSystem.fileSystemOperations;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirTreeList {

    public static void main(String[] args) {
        String dirname = "src/main/resources";
        System.out.println("Dir tree starting from " + dirname + " : ");
        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException e) {
            System.out.println("io-error: " + e);
        }
    }
}


class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}


