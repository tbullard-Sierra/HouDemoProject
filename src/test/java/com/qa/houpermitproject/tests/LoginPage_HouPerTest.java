package com.qa.houpermitproject.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ExcelUtil;

public class LoginPage_HouPerTest extends BaseTest{

	Logger log = Logger.getLogger(LoginPage_HouPerTest.class);
	
	@DataProvider
	public Object[][] getTestData() {
		
		return ExcelUtil.readTestData(Constants.LOGIN_TEST_DATA_SHEET_PATH,Constants.LOGIN_TEST_DATA_SHEET_NAME);
	}
	
	@Test(dataProvider="getTestData")
	public void verifyLoginToHouPerSiteTest(String uName, String pwd) throws InterruptedException {
		
		log.info("Entering Username and Password "+uName + "and" +pwd);
		loginPageHouPer.doLoginHouPer(prop.getProperty("cohUrl").trim(),uName, pwd);
		Reporter.log("User Name:"+uName +"and Password :"+pwd);
		
	}
}
