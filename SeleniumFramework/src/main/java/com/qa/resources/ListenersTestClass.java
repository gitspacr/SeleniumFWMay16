package com.qa.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersTestClass implements ITestListener {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		System.out.println("onTestStart");
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		System.out.println("onTestSuccess"+ "script passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		System.out.println("onTestFailure"+"take screenshot");
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.BLUE));
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss").format(new Date());
		String repname="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
		
		htmlReporter.config().setDocumentTitle("Automation Report View");
		htmlReporter.config().setReportName("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		extent =new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("OS", "Window 11");
		extent.setSystemInfo("Tester Name", "Pranitha");
		extent.setSystemInfo("Browser", "Chrome");
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("onFinish");
		extent.flush();
	}

}
