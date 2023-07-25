package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;
public class RequestForInspectionTest extends BaseTest{

	
	@DataProvider()
	public Object[][] getDataForReqInspection() {
		
		return ExcelUtil.readTestData(Constants.INSPECTION_SHEET_PATH, Constants.INSPECTION_REQUEST_SHEET_NAME);
	}
	@Test (dataProvider="getDataForReqInspection")
	public void inspectionRequestTest(String appNo,String reqDate,String locDetails,String contPerson,
			String contInfo,String instructions) {
		
		
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		String schduledDate =inspections.requestForScheduleInspection(appNo,reqDate,locDetails,contPerson,
				contInfo,instructions);
		
		System.out.println("Scheduled request date : "+schduledDate);
		Assert.assertEquals(schduledDate,reqDate );
		
	}
}
