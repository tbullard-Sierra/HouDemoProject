package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class CancelRequestTest extends BaseTest{
			
	@DataProvider()
	public Object[][] getReqCancelData() {
		
		return ExcelUtil.readTestData(Constants.INSPECTION_SHEET_PATH, Constants.INSPECTION_CANCEL_SHEET_NAME);
	}
	@Test (dataProvider="getReqCancelData")
	public void requestCancelTest(String appNo) {
		
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		String cancelMsg = inspections.cancelInspection(appNo);
		System.out.println("cancel Request message: "+cancelMsg);
		
		Assert.assertEquals(cancelMsg, Constants.CANCEL_REQUEST_POPUP_MSG);
	}

}
