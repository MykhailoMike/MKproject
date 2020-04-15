package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.byteBasedStream;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("src/main/resources/COPYRIGHT");
        p("Name of file: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Absolute Path: " + f1.getAbsolutePath());
        p("Parent directory: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");
        p(f1.canRead()? "can read" : "can not read");
        p(f1.canWrite()? "can write" : "can not write");
        p(f1.isDirectory()? "is directory" : "is not directory");
        p(f1.isFile()? "is ordinary file" : "can be called channel");
        p(f1.isAbsolute()?"is absolute":"is not absolute");
        p("Last modification with File: " + f1.lastModified());
        p("Size: " + f1.length() + " bytes");
        File f2 = new File("src/main/resources/Copyright1");
        System.out.println(f1.renameTo(f2));
        System.out.println(f2.isHidden());
        File f3 = new File(f2, "CopyRightUA");
        f3.mkdir();
    }
}
