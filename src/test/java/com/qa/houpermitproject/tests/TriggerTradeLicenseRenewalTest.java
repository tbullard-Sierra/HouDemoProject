package com.qa.houpermitproject.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class TriggerTradeLicenseRenewalTest extends BaseTest{

	@DataProvider
	public Object[][] getTradeLicenseData() {
		
		return ExcelUtil.readTestData(Constants.TRADELICENSE_RENEWAL_SHEET_PATH, Constants.TRADELICENSE_RENEWAL_SHEET_NAME);
		
	}
	
	@Test(dataProvider = "getTradeLicenseData")
	public void renewTradeLicenseTest(String licNo,String logTy,String strDt,String stpDt,String StartdBy) {
		
		List<String> validations = new ArrayList<String>();
		
		SoftAssert softAssert = new SoftAssert();
		
		String dashBoardHeader = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(), prop.getProperty("ipsUsername").trim(), 
				prop.getProperty("ipsPassword"));
		
		System.out.println("Dashboard Header Text"+dashBoardHeader);
		softAssert.assertEquals(dashBoardHeader, Constants.IPS_HOME_PAGE_HEADER);
		
		
		validations = tTradeLicRenw.triggerTLRenewal(licNo,logTy,strDt,stpDt,StartdBy);
		
		String beforeRnwMilestoneMsg = validations.get(0);
		String afterRnwMilestoneMsg = validations.get(1);
		String renewDt =validations.get(2);
		String stopDt = validations.get(3);
		System.out.println("Before Renewal Milestone message: "+beforeRnwMilestoneMsg);
		System.out.println("After Renewal Milestone message: "+afterRnwMilestoneMsg);
		System.out.println("Renewal Date is: "+renewDt);
		System.out.println("stopDt"+stopDt);
		
		softAssert.assertEquals(beforeRnwMilestoneMsg, Constants.TRADE_LICENSE_RENEW_MSG);
		softAssert.assertEquals(afterRnwMilestoneMsg, Constants.TRADE_LICENSE_RENEW_MSG);
		softAssert.assertEquals(renewDt,strDt );
		softAssert.assertEquals(stopDt, stpDt);
		
		softAssert.assertAll();
	}
}
