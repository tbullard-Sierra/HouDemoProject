package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class RequestForRescheduleInspectionTest extends BaseTest{
	
	@DataProvider()
	public Object[][] getReqForReschdData() {
		
		return ExcelUtil.readTestData(Constants.INSPECTION_SHEET_PATH, Constants.INSPECTION_RESCHEDULE_SHEET_NAME);
	}
	@Test(dataProvider="getReqForReschdData")
	public void rescheduleInspectionTest(String appNo,String reschdDate) {
		
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		inspections.rescheduleInsp(appNo, reschdDate);
	}
}
