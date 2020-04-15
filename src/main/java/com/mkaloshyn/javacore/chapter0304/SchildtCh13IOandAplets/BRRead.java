package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh13IOandAplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {

    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter symbols, q - for exit");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c!='q');
    }
}
