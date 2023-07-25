package com.qa.houpermitproject.tests;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class Rhythm_ApplyMechPerWithAEorARlicenseTest extends BaseTest{
	
	@DataProvider()
	public Object[][] getTestDataForARorAElicenseMechPer() {
		
		return ExcelUtil.readTestData(Constants.MECHANICAL_PERMIT_TEST_DATA_SHEET_PATH, Constants.MECHPER_AEorAR_LICENSE_TEST_SHEET_NAME);
	}
	
	@Test(dataProvider="getTestDataForARorAElicenseMechPer")
	public void applyMechPerWithARorAElicneseTest(String title,String wTy,String oTy,String desc,
			String cap,String hOwner,String init1,String init2,String init3,String init4,String pName,
			String iCnt,String pCode) {
		
		SoftAssert softAssert = new SoftAssert();
		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("AE/ARLicenseUserName").trim(), prop.getProperty("AE/ARLicensePassword").trim());
		softAssert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		
		String confNum = mechPermit.applyMecPerWithAEorARLicense(title,wTy,oTy,desc,cap,hOwner,init1,init2,init3,init4,pName
				,iCnt,pCode);
	
		System.out.println("Confirmation number is: "+confNum);
		Reporter.log("Confirmation Number :"+confNum);
		softAssert.assertNotNull(confNum);
		
		softAssert.assertAll();
	}

}
