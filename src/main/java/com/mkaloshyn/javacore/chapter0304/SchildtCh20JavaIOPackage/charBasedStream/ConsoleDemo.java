package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.charBasedStream;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        con = System.console();
        if (con == null) {
            return;
        }
        str = con.readLine("Please, input string: ");
        con.printf("The string you've put is : %s\n", str);
    }
}
