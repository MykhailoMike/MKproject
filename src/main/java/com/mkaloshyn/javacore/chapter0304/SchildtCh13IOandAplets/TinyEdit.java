package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh13IOandAplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEdit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[100];
        System.out.println("Please enter strings of text");
        System.out.println("Please enter stop to finish");
        for (int i = 0; i < 100; i++) {
            str[i] = br.readLine();
            if (str[i].equals("stop")) {
                break;
            }
        }
        System.out.println("There are strings from your file:");
        for (int i = 0; i < 100; i++) {
            System.out.println(str[i]);
            if (str[i].equals("stop")) {
                break;
            }
        }
    }
}
