package main.java.com.mkaloshyn.javacore.chapter0304.myApp.repository;

import main.java.com.mkaloshyn.javacore.chapter0304.myApp.model.Report;
import main.java.com.mkaloshyn.javacore.chapter0304.myApp.model.ReportStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaIOReportRepositoryImpl implements ReportRepository {

    @Override
    public void getById(Long ID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/reports.txt"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.equals("")) {
                    String[] parts = str.split(",");
                    long idFromParts = Long.parseLong(parts[0]);
                    if (ID == idFromParts) {
                        Report report = getReport(str);
                        System.out.println(report);
                        return;
                    }
                }
            }
            System.out.println("There is no report with such an ID");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Report> getAll() {
        if (!getReportsAsList().isEmpty()) {
            for (Report report : getReportsAsList()) {
                System.out.println(report);
            }
        } else {
            System.out.println("There are no reports in the list yet");
        }
        return getReportsAsList();
    }

    private List<Report> getReportsAsList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/reports.txt"))) {
            String str;
            List<Report> reports = new ArrayList<>();
            while (true) {
                try {
                    if ((str = reader.readLine()) == null) {
                        return reports;
                    }
                    if (!str.equals("")) {
                        Report report = getReport(str);
                        reports.add(report);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Report getReport(String str) {
        String[] split = str.split(",");
        Long id = Long.valueOf(split[0]);
        String reportName = split[1];
        ReportStatus reportStatus = ReportStatus.valueOf(split[2]);
        return new Report(id, reportName, reportStatus);
    }

    @Override
    public void save(Report report) {
        if (report != null) {

            Long id = report.getReportID();
            String name = report.getReportName();
            String status = report.getReportStatus().toString();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/reports.txt", true))) {
                writer.write(id + "," + name + "," + status + "\n");
                System.out.println("New report was sucessfully added!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Report report) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Report createReport(String name, String status) {
        try {
            ReportStatus reportStatus = ReportStatus.valueOf(status.toUpperCase());
            Long id;
            if (!getReportsAsList().isEmpty()) {
                Optional<Long> max = getReportsAsList().stream()
                        .map(s -> s.getReportID())
                        .max((o1, o2) -> o1.compareTo(o2));
                if (max.isPresent()) {
                    id = max.get() + 1;
                } else {
                    id = 1L;
                }
            } else {
                id = 1L;
            }
            return new Report(id, name, reportStatus);
        } catch (IllegalArgumentException e) {
            System.out.println("There is no such a status among possible ones. Try again.");
            return null;
        }
    }
}

