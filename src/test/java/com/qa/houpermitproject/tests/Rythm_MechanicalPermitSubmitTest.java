package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class Rythm_MechanicalPermitSubmitTest extends BaseTest{
	
	
	@BeforeMethod
	public void loginToRythm() {
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
	}
	
	
	
	@DataProvider
	public Object [][] getMechPerData() {
		return ExcelUtil.readTestData(Constants.MECHANICAL_PERMIT_TEST_DATA_SHEET_PATH, Constants.MECHANICAL_PERMIT_TEST_DATA_SHEET_NAME);
	}
	@Test (dataProvider ="getMechPerData",enabled=true)
	public void applyForMechaniclPermit(String title,String wTy,String occuTy,String desc,String cap,
			String HOfn,String HOinit1,String HOinit2,String HOinit3,String HOinit4,String printname,
			String HOitemCnt,String postalCode) {
		
		String confNum =mechPermit.createMechanicalPermit(title, wTy, occuTy, desc, cap, HOfn, HOinit1, HOinit2, HOinit3,
				HOinit4, printname, HOitemCnt, postalCode);

				
		System.out.println("Confirmation Number is: "+confNum);
		Assert.assertNotNull(confNum);
		Reporter.log("Confirmation Number: "+confNum);
	}
}
