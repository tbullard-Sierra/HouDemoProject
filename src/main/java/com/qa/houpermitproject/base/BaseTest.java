package com.qa.houpermitproject.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.houpermitproject.pages.ApplyPermitFromBackOffice;
import com.qa.houpermitproject.pages.BackOffice;
import com.qa.houpermitproject.pages.BackOfficeLogin;
import com.qa.houpermitproject.pages.COHRegistrationPage;
import com.qa.houpermitproject.pages.COHhomePage;
import com.qa.houpermitproject.pages.CompleteInspectionBackOffice;
import com.qa.houpermitproject.pages.CreateProfile;
import com.qa.houpermitproject.pages.ElectricalLicense;
import com.qa.houpermitproject.pages.Inspections;
import com.qa.houpermitproject.pages.LoginPage_HouPer;
import com.qa.houpermitproject.pages.MechanicalPermit;
import com.qa.houpermitproject.pages.RequestInformation;
import com.qa.houpermitproject.pages.TriggerTradeLicenseRenewal;
import com.qa.houpermitproject.pages.UpdateDetailsPageGrid;

public class BaseTest {

	
	WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public COHRegistrationPage regPage;
	public COHhomePage cohHomePage;
	public LoginPage_HouPer loginPageHouPer;
	public ElectricalLicense electricLicense;
	public CreateProfile createProfile;
	public MechanicalPermit mechPermit;
	public BackOfficeLogin ipsLogin;
	public BackOffice backOffice;
	public Inspections inspections;
	public ApplyPermitFromBackOffice permitFromIPS;
	public UpdateDetailsPageGrid updatedetilsPage;	
	public CompleteInspectionBackOffice completeInspection;
	public RequestInformation reqInfo;
	public TriggerTradeLicenseRenewal tTradeLicRenw;	
	
	//@Parameters("browser")
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop =basePage.initialize_Properties();
//		String browser = prop.getProperty("browser").trim();
//		
//		if(browserName!=null) {
//			browser = browserName;
//		}
		driver = basePage.initialize_WebDriver(prop);
		createProfile = new CreateProfile(driver);
		regPage = new COHRegistrationPage(driver);
		cohHomePage = new COHhomePage(driver);
		loginPageHouPer = new LoginPage_HouPer(driver);
		electricLicense = new ElectricalLicense(driver);
		mechPermit = new MechanicalPermit(driver);
		ipsLogin = new BackOfficeLogin(driver);
		backOffice = new BackOffice(driver);
		inspections = new Inspections(driver);
		permitFromIPS = new ApplyPermitFromBackOffice(driver);
		updatedetilsPage = new UpdateDetailsPageGrid(driver);
		completeInspection = new CompleteInspectionBackOffice(driver);
		reqInfo = new RequestInformation(driver);
		tTradeLicRenw = new TriggerTradeLicenseRenewal(driver);
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
