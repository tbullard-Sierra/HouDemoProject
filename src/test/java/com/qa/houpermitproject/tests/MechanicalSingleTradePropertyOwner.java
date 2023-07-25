package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class MechanicalSingleTradePropertyOwner extends BaseTest{
	
	
	
	String confNum = null;
	@DataProvider
	public Object [][] getMechPerData() {
		return ExcelUtil.readTestData(Constants.MECHANICAL_PERMIT_TEST_DATA_SHEET_PATH, Constants.MECHANICAL_PERMIT_TEST_DATA_SHEET_NAME);
	}
	
	
	@Test (dataProvider ="getMechPerData",enabled=true,priority=1)
	public void createMechaniclPermit(String title,String wTy,String occuTy,String desc,String cap,
			String HOfn,String HOinit1,String HOinit2,String HOinit3,String HOinit4,String printname,
			String HOitemCnt,String postalCode) {
		
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		System.out.println("Rhythm Dashboard Header : "+accnt);
		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		confNum =mechPermit.createMechanicalPermit(title, wTy, occuTy, desc, cap, HOfn, HOinit1, HOinit2, HOinit3,
				HOinit4, printname, HOitemCnt, postalCode);

		System.out.println("Confirmation Number is: "+confNum);
		Assert.assertNotNull(confNum);
		Reporter.log("Confirmation Number: "+confNum);
	}
	@Test(priority=2)
	public void backOfficeApprovalAndPayFeeTest() {
		
		SoftAssert softAssert = new SoftAssert();
		
		String headerText = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(),
				prop.getProperty("ipsUsername").trim(), prop.getProperty("ipsPassword").trim());
		System.out.println("IPS Home Page header : "+headerText);
		softAssert.assertEquals(headerText, Constants.IPS_HOME_PAGE_HEADER);
		
		String preScreenMileStoneMsg =backOffice.preScreenStatus(confNum);
		System.out.println("PreScreen Milestone message: "+preScreenMileStoneMsg);
		softAssert.assertEquals(preScreenMileStoneMsg, Constants.MILESTONE_PRE_SCREEN_MSG);
		
		String feeMileStoneMsg=backOffice.approvePermitAndSatusAwaitingFeePayment();
		System.out.println("Fee Awaiting MileStone Message: "+feeMileStoneMsg);
		//softAssert.assertEquals(feeMileStoneMsg, Constants.MILESTONE_FEE_PAYMENT_AWAITNG_MSG);
		
		String insMileStoneMsg = backOffice.payFeesAndStatusInspection();
		System.out.println("Inspection MileStone Message: "+insMileStoneMsg);
		//softAssert.assertEquals(insMileStoneMsg, Constants.MILESTONE_INSPECTION_MSG);
		
		softAssert.assertAll();
		
	}
	@DataProvider()
	public Object[][] getTestDataForInspection(){
		return ExcelUtil.readTestData(Constants.INSPECTION_SHEET_PATH, Constants.INSPECTION_REQUEST_SHEET_NAME);
	}
	
	@Test(priority = 3,dataProvider = "getTestDataForInspection")
	public void inspectionRequestTest(String appNo,String reqDate,String locDetails,String contPerson,
			String contInfo,String instructions) {
		appNo = confNum;
		
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		System.out.println("Confirmation Number using for Inspections: "+appNo);
		inspections.requestForScheduleInspection(appNo, reqDate, locDetails,
				contPerson, contInfo, instructions);
		
	}

}
