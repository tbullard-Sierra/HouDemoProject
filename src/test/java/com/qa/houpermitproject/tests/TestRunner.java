package com.qa.houpermitproject.tests;







import org.testng.ITestNGListener;
import org.testng.TestNG;

import com.qa.houpermitproject.listeners.ExtentReportListener;

public class TestRunner {

	static TestNG testNg;
	
	
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//ExtentReportListener extentReportListener = new ExtentReportListener();
		//ITestNGListener iTestNgListener =new ExtentReportListener();
		ITestNGListener extent = new ExtentReportListener();
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {RoofingPermitTest.class,CommertialPermitTest.class});
		//testNg.addListener(extentReportListener);
		//testNg.addListener(iTestNgListener);
		testNg.addListener(extent);
		testNg.run();
	}

}
