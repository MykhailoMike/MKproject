package main.java.com.mkaloshyn.javacore.chapter0304.myApp.model;

public class Report {

    private Long reportID;
    private String reportName;
    private ReportStatus reportStatus;

    public Report(Long reportID, String reportName, ReportStatus reportStatus) {
        this.reportID = reportID;
        this.reportName = reportName;
        this.reportStatus = reportStatus;
    }

    public long getReportID() {
        return reportID;
    }

    public void setReportID(long reportID) {
        this.reportID = reportID;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public ReportStatus getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(ReportStatus reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportID=" + reportID +
                ", reportName='" + reportName + '\'' +
                ", reportStatus=" + reportStatus +
                '}';
    }
}
