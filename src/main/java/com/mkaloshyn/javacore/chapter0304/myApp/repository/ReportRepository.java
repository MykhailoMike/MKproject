package main.java.com.mkaloshyn.javacore.chapter0304.myApp.repository;

import main.java.com.mkaloshyn.javacore.chapter0304.myApp.model.Report;

import java.util.List;

public interface ReportRepository extends GenericRepository {

    void getById(Long ID);

    List<Report> getAll();

    Report createReport(String name, String status);

    void save(Report report);

    void update(Report report);

    void deleteById(Long id);


}
