package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {


	public static ExtentReports addReport()
	{
		ExtentSparkReporter htlmReport=new ExtentSparkReporter("extentReporter.html");
	
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(htlmReport);
		reports.setSystemInfo("Env","SIT");
		reports.setSystemInfo("TestingTypre", "Regression");
		reports.setSystemInfo("Browser", "Chrome");
		return reports;
	}
	
}
