package main.java.com.mkaloshyn.javacore.chapter0304.myApp;

import main.java.com.mkaloshyn.javacore.chapter0304.myApp.controller.ReportController;
import main.java.com.mkaloshyn.javacore.chapter0304.myApp.view.ReportView;

public class MyAppMain {

    public static void main(String[] args) {

        int choice;

        ReportView reportView = new ReportView();
        ReportController reportController = new ReportController();

        do {
            choice = reportView.askForChoice();
            reportController.actionActivation(choice);
        } while (choice!=4);
    }
}
