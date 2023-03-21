package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
    static ExtentReports extentReports;

    public static ExtentReports getReporterObject(){

        String path = System.getProperty("user.dir") +"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Selenium Test Results");
        reporter.config().setDocumentTitle("Automation Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester","Mostafa Agamy");

        return extentReports;
    }
}
