package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;


public class CreateProfileTest extends BaseTest{
	
	
	@BeforeMethod
	public void launchURL() {
		createProfile.lanuchRhythmURL(prop.getProperty("cohUrl").trim());
	}
		
	@DataProvider()
	public Object[][] getCompanyProfileData() {
		return ExcelUtil.readTestData(Constants.CREATE_PROFILE_SHEET_PATH, Constants.CREATE_COMPANY_PROFILE_SHEET_NAME);
	}
	@Test (dataProvider ="getCompanyProfileData",enabled=false)
	public void createCompanyProfile(String email,String compName,String add1,String add2,
			String city,String state,String zip,String mPh,String altPh,String fax,String password,
			String conPassword) {
		
//		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
//				prop.getProperty("username").trim(), prop.getProperty("password").trim());
//		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		String accntCrMsg = createProfile.setupCompanyProfile(email,compName, add1, add2, city, state, zip, mPh, 
				altPh, fax, password, conPassword);
		
		Reporter.log("Account Creation Message: "+accntCrMsg);
		
		Assert.assertEquals(accntCrMsg, Constants.EXPECTED_ACCNT_CREATE_SUCESS_MSG);
}
	
	
	@DataProvider
	public Object[][] getIndividualProfileData() {
		
		return ExcelUtil.readTestData(Constants.CREATE_PROFILE_SHEET_PATH, Constants.CREATE_INDIV_PROFILE_SHEET_NAME);
	}
	
	
	@Test(dataProvider="getIndividualProfileData")
	public void createIndividualProfile(String email,String title,String fN,String lN,String mN,
			String add1,String add2,String city,String state,String zip,String mPh,String altPh,
			String fax,String password,String conPassword) {
		
//		String accnt = loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),
//				prop.getProperty("username").trim(), prop.getProperty("password").trim());
//		Assert.assertEquals(accnt, Constants.DASHBOARD_TEXT);
		
		String message = createProfile.setupIndividualProfile(email, title, fN, lN, mN, mN, add1, add2, city, state, 
				zip, mPh, altPh, fax, password, conPassword);
		
		Assert.assertEquals(message, Constants.EXPECTED_ACCNT_CREATE_SUCESS_MSG,"Failed to create account");
		Reporter.log("Account creation message: "+message);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}