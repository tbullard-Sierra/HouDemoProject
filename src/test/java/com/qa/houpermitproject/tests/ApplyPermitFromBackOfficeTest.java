package com.qa.houpermitproject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class ApplyPermitFromBackOfficeTest extends BaseTest{

	
	@DataProvider()
	public Object[][] getTestDataForMechPerBackOffice() {
		
		return ExcelUtil.readTestData(Constants.MECHANICAL_PERMIT_TEST_DATA_SHEET_PATH, 
				Constants.MECHAICAL_PERMIT_BACKOFFICE_TEST_DATA_SHEET_NAME);
	}
	@Test(dataProvider="getTestDataForMechPerBackOffice")
	public void applyMechanicalPermitFromBackOffice(String appTy,String stNo,String preDir,
			String stName,String emailAdd, String wTy,String occTy,String appName,
			String descOfWrk, String fName,String init1,String init2,String init3,
			String init4,String pName,String valuation) {
		
		SoftAssert softAssert = new SoftAssert();
		String dashBoardHeader = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(), prop.getProperty("ipsUsername").trim(), 
				prop.getProperty("ipsPassword"));
		
		System.out.println("Dashboard Header Text"+dashBoardHeader);
		softAssert.assertEquals(dashBoardHeader, Constants.IPS_HOME_PAGE_HEADER);
		
		String confNum = permitFromIPS.applyMechPermitFromBackOffice(appTy,stNo,preDir,stName,emailAdd,wTy,occTy,appName,
				descOfWrk,fName,init1,init2,init3,init4,pName,valuation);
		
		System.out.println("Confirmation Number: "+confNum);
		softAssert.assertNotNull(confNum);
	}
}
