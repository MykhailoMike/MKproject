package main.java.com.mkaloshyn.javacore.chapter0304.myApp.controller;

import main.java.com.mkaloshyn.javacore.chapter0304.myApp.model.ReportStatus;
import main.java.com.mkaloshyn.javacore.chapter0304.myApp.repository.JavaIOReportRepositoryImpl;
import main.java.com.mkaloshyn.javacore.chapter0304.myApp.repository.ReportRepository;

import java.util.Arrays;
import java.util.Scanner;

public class ReportController {

    ReportRepository reportRepository = new JavaIOReportRepositoryImpl();

    public void actionActivation(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Please put the report's ID:");
                long i = (long) scanner.nextInt();
                reportRepository.getById(i);
                break;
            case 2:
                reportRepository.getAll();
                break;
            case 3:
                System.out.println("Please put the report's name:");
                String reportName = scanner.nextLine();
                System.out.println("Please put one of the possible statuses: " + Arrays.toString(ReportStatus.values()));
                String repStatus = scanner.nextLine();
                reportRepository.save(reportRepository.createReport(reportName, repStatus));
                break;
            case 4:
                System.out.println("Program has been terminated.");
                break;
            default:
                System.out.println("Please choose in range 1 to 4 strictly");
                break;
        }

    }
}
