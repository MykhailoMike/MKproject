package main.java.com.mkaloshyn.javacore.chapter0304.myApp.view;

import java.util.Scanner;

public class ReportView {

        public int askForChoice() {

        int choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("__________________________________\n" +
                "Please choose the action needed:\n" +
                "1 - read report by ID\n" +
                "2 - read all reports\n" +
                "3 - add report\n" +
                "4 - terminate program"
        );
        choice = scanner.nextInt();
        return choice;
    }
}
