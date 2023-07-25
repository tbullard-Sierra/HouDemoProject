package com.qa.houpermitproject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class UpdateDetailGridTest extends BaseTest{

	@DataProvider()
	public Object[][] getDataForUpdateGrid() {
		
		return ExcelUtil.readTestData(Constants.UPDATE_DETAILPAGE_GRID_SHEET_PAHT, 
				Constants.UPDATE_DETAILPAGE_GRID_SHEET_NAME);
	}
	
	
	@Test(dataProvider="getDataForUpdateGrid")
	public void updateDetailPageGridTest(String appNo, String capTy, String fName, String lName,
			String email,String phNo) {
		
		SoftAssert softAssert = new SoftAssert();
		
		String headerText = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(),
				prop.getProperty("ipsUsername").trim(), prop.getProperty("ipsPassword").trim());
		System.out.println("Home Page header : "+headerText);
		softAssert.assertEquals(headerText, Constants.IPS_HOME_PAGE_HEADER);
		
		String applicantEmail = updatedetilsPage.updateDetailspageGrid(appNo,capTy,fName,lName,email,phNo);
		System.out.println("Applicant Email: "+applicantEmail);
		softAssert.assertEquals(applicantEmail, email);
	
		
	}
	
}
