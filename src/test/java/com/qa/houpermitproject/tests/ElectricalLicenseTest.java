package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class ElectricalLicenseTest extends BaseTest {

	@BeforeMethod
	public void loginPermitSite() throws InterruptedException {
		//
		String accntText = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
				prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertEquals(accntText, Constants.DASHBOARD_TEXT);
	}
	
	@DataProvider
	public Object [][] getElectricalPermitData() {
		return ExcelUtil.readTestData(Constants.ELECTIRCAL_PERMIT_TEST_DATA_SHEET_PATH,Constants.ELECTRICAL_PERMIT_TEST_DATA_SHEET_NAME);
	}
	@Test (dataProvider = "getElectricalPermitData")
	public void electricalPermitTest(String lCatagory,String stLic, String IssBy, String stExp, 
			String DLno,String CompName,String compAdd,String compPh,String insPolNo,
			String insCompName,String insExpDate,String ContLicNo) throws InterruptedException {
		
		String confirmationNum =electricLicense.createElectricPermit(lCatagory, stLic, IssBy, stExp, DLno, CompName, compAdd, compPh,
				insPolNo, insCompName, insExpDate, ContLicNo);
		Reporter.log("Confirmation Number: "+confirmationNum);
		System.out.println("Confirmation Number is: "+confirmationNum);
	}

}
