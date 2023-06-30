package com.qa.houpermitproject.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.pages.COHRegistrationPage;
import com.qa.houpermitproject.utils.ElementUtil;
import com.qa.houpermitproject.utils.ScreenshotUtils;



public class ExtentReportListener extends BasePage implements ITestListener {

	private static final String OUTPUT_FOLDER = "./build/";
	private static final String FILE_NAME = "TestExecutionReport.html";

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	private static ExtentReports init() {

		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		htmlReporter.config().setDocumentTitle("Automation Test Results");
		htmlReporter.config().setReportName("Test Results");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);

		return extent;
	}

	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");
	}

	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		extent.flush();
		test.remove();
	}

	public synchronized void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " started!");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		/*
		 * methodName = StringUtils.capitalize(StringUtils.join(StringUtils.
		 * splitByCharacterTypeCamelCase(methodName), StringUtils.SPACE));
		 */
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		test.get().fail(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(getScreehshot()).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
		test.get().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
		test.get().info(result.getMethod().getDescription());
		
	}
//	COHRegistrationPage elementUtil = new COHRegistrationPage(getDriver());
//	  @Override
//	    public void onTestFailure(ITestResult tr) {
//	        // Capture screenshot of specific WebElement on test failure and attach it to the report
//	        WebElement element = getDriver().findElement(elementUtil.regHeader); // Replace with the desired locator for your element
//	        try {
//	            File screenshotFile = ScreenshotUtils.captureElementScreenshot(element);
//	            test.get().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
//	            test.get().addScreenCaptureFromPath(screenshotFile.getAbsolutePath(), "Failure Screenshot");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
	
	
//	 @Override
//	    public void onTestFailure(ITestResult tr) {
//	        // Capture screenshot on test failure and attach it to the report
//	       // WebDriver driver = ((WebDriver) tr.getTestContext().getAttribute("WebDriver"));
//	        TakesScreenshot ts = (TakesScreenshot) getDriver();
//	        String screenshotBase64 = ts.getScreenshotAs(OutputType.BASE64);
//			test.get().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
//			test.get().addScreenCaptureFromBase64String(screenshotBase64, "Failure Screenshot");
//	    }

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(getScreehshot()).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}