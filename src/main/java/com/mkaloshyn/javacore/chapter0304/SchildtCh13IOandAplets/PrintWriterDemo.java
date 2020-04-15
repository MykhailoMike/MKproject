package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh13IOandAplets;

import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true); //Используется в реальных программах
        // вмместо sout, что упрощает Интернационализацию реальных программ.
        pw.println("this is a string");
        int i = -7;
        pw.println(i);
        double d = 4.5e-7;
        pw.println(d);
    }
}
