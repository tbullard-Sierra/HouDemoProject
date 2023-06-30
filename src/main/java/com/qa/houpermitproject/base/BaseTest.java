package com.qa.houpermitproject.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.houpermitproject.pages.COHRegistrationPage;
import com.qa.houpermitproject.pages.COHhomePage;
import com.qa.houpermitproject.pages.CreateProfile;
import com.qa.houpermitproject.pages.ElectricalLicense;
import com.qa.houpermitproject.pages.LoginPage_HouPer;

public class BaseTest {

	WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public COHRegistrationPage regPage;
	public COHhomePage cohHomePage;
	public LoginPage_HouPer loginPageHouPer;
	public ElectricalLicense electricLicense;
	public CreateProfile createProfile;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop =basePage.initialize_Properties();
		driver = basePage.initialize_WebDriver(prop);
		createProfile = new CreateProfile(driver);
		regPage = new COHRegistrationPage(driver);
		cohHomePage = new COHhomePage(driver);
		loginPageHouPer = new LoginPage_HouPer(driver);
		electricLicense = new ElectricalLicense(driver);
	}
	
//	@Parameters({"browser"})
//	@BeforeMethod
//	public void setUp(String browserName) {
//		basePage = new BasePage();
//		prop =basePage.initialize_Properties();
//		prop.setProperty("browser", browserName);
//		driver = basePage.initialize_WebDriver(prop);
//		loginPageHouPer = new LoginPage_HouPer(driver); 
//		regPage = new COHRegistrationPage(driver);
//		cohHomePage = new COHhomePage(driver);
//	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
