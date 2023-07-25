package com.qa.houpermitproject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class ExpirePermitProcessTest extends BaseTest{
	
	@DataProvider()
	public Object[][] getExpirePerProcessData() {
		
		return ExcelUtil.readTestData(Constants.TRADELICENSE_RENEWAL_SHEET_PATH, Constants.TRADELICENSE_EXPIREPERMIT_PROCESS_SHEET_NAME);
		
	}
	
	@Test(dataProvider="getExpirePerProcessData")
	public void expirePerProcess(String licNo, String newExpDt) {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dashBoardHeader = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(), prop.getProperty("ipsUsername").trim(), 
				prop.getProperty("ipsPassword"));
		
		System.out.println("Dashboard Header Text"+dashBoardHeader);
		softAssert.assertEquals(dashBoardHeader, Constants.IPS_HOME_PAGE_HEADER);
		
		String newExpDate = tTradeLicRenw.expirepermit(licNo, newExpDt);;
		System.out.println("Modified Expire Date is: "+newExpDate);
		softAssert.assertEquals(newExpDate, newExpDt);
		
		softAssert.assertAll();
		
	}

}
