package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class CreateProfile extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	public CreateProfile(WebDriver driver) {
		elementUtil=new ElementUtil(driver);
		this.driver = driver;
	}
	By createProfileLink = By.xpath("//main[@class='content']//div[@class='new-user-link']/a");
	By cookiesPopup = By.xpath("//div[@class='cc-compliance']/a");
	By email = By.xpath("//input[@id='user-Email']");
	By continueBtn = By.xpath("//button[@id='User_Info_Continue']");
	
	// Enroll As Company
	By enrollAsBuss = By.xpath("//input[@id='business-radio']/..//label");
	By businessName = By.xpath("//input[@id='business-name']");

	// Enroll As Individual
	By enrollAsIndv = By.xpath("//input[@id='individual-radio']/../label");
	By userTitle = By.xpath("//input[@id='user-Title2']");
	By userFirstName = By.xpath("//input[@id='user-Fname']");
	By userLastName = By.xpath("//input[@id='user-Lname']");
	By userMiddleName = By.xpath("//input[@id='user-Mname']");

	By address1 = By.xpath("//input[@id='user-Address1']");
	By address2 = By.xpath("//input[@id='user-Address2']");
	By userCity = By.xpath("//input[@id='user-City']");
	By userState = By.xpath("//input[@id='user-State']");
	
	By userZip = By.xpath("//input[@id='user-Zip']");
	By userMobilePhno = By.xpath("//input[@id='user-MobilePhone']");
	By userAlternatePhno = By.xpath("//input[@id='user-Phone']");
	By userFax = By.xpath("//input[@id='user-Fax']");
	By userContinueBtn = By.xpath("//button[@id='User_Contact_Continue']");
	
	By password = By.xpath("//input[@id='New-Password1']");
	By conPassword = By.xpath("//input[@id='New-Password2']");
	By userPrivacyBtn = By.xpath("//button[@id='User_Privacy_Continue']");
	
	By termsAndCondChck = By.xpath("//input[@id='service-checkbox']/..//label");
	By createAccntBtn = By.xpath("//button[text()='Create Account']");
	By accntSuccessMsg = By.xpath("//header[@class='user-form-register-header']/h2");

	
	public String setupIndividualProfile(String email,String title,String fN,String lN,String mN,
			String businessName,String add1,String add2,String city,String state,String zip,String mPh,
			String altPhno,String fax,String pwd,String conPwd)  {
		
		String sucessMsg = null;
		try {
		elementUtil.doClick(cookiesPopup);
		Thread.sleep(3000);
		elementUtil.doClick(createProfileLink);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doClick(continueBtn);
		// Enroll As Company
//		if(enrollAs.equals("Company")) {
//			elementUtil.doClick(enrollAsBuss);
//			elementUtil.doSendKeys(this.businessName, businessName);
//		}else if(enrollAs.equals("Individual")){
			elementUtil.doClick(enrollAsIndv);
			elementUtil.doSendKeys(userTitle, title);
			elementUtil.doSendKeys(userFirstName, fN);
			elementUtil.doSendKeys(userLastName, lN);
			elementUtil.doSendKeys(userMiddleName, mN);
		//}
		
		elementUtil.doSendKeys(address1, add1);
		elementUtil.doSendKeys(address2, add2);
		elementUtil.doSendKeys(userCity, city);
		elementUtil.doSendKeys(userState, state);
		By userStatePopup = By.xpath("//li[@data-val='"+state+"']");
		elementUtil.doClick(userStatePopup);
		elementUtil.doSendKeys(userZip, zip);
		elementUtil.waitForElementToBeVisible(userMobilePhno,20);
		elementUtil.doSendKeys(userMobilePhno, mPh);
		elementUtil.doSendKeys(userAlternatePhno, altPhno);
		elementUtil.doSendKeys(userFax, fax);
		elementUtil.doClick(userContinueBtn);
		elementUtil.waitForElementToBeVisible(password, 20);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doSendKeys(conPassword, conPwd);
		//driver.findElement(userPrivacyBtn).click();
		elementUtil.doClick(userPrivacyBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.waitForElementToBeVisible(termsAndCondChck, 20);
		elementUtil.doClick(termsAndCondChck);
		elementUtil.doClick(createAccntBtn);
		Thread.sleep(4000);
		sucessMsg = driver.findElement(accntSuccessMsg).getText();
		System.out.println("Account Creation Success Message: "+sucessMsg);
		}catch(Exception e) {
			
		}
		return sucessMsg;
		
	}

	public String setupCompanyProfile(String email,String businessName,String add1,
			String add2,String city,String state,String zip,String mPh,
			String altPhno,String fax,String pwd,String conPwd)  {
		
		String sucessMsg = null;
		try {
		elementUtil.doClick(cookiesPopup);
		//elementUtil.doClick(createProfileLink);
			Thread.sleep(3000);
		elementUtil.clickElementByJS(elementUtil.getElement(createProfileLink));
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doClick(continueBtn);
		// Enroll As Company
		//if(enrollAs.equals("Company")) {
			elementUtil.doClick(enrollAsBuss);
			elementUtil.doSendKeys(this.businessName, businessName);
//		}else if(enrollAs.equals("Individual")){
//			elementUtil.doClick(enrollAsIndv);
//			elementUtil.doSendKeys(userTitle, title);
//			elementUtil.doSendKeys(userFirstName, fN);
//			elementUtil.doSendKeys(userLastName, lN);
//			elementUtil.doSendKeys(userMiddleName, mN);
//		}
		
		elementUtil.doSendKeys(address1, add1);
		elementUtil.doSendKeys(address2, add2);
		elementUtil.doSendKeys(userCity, city);
		elementUtil.doSendKeys(userState, state);
		By userStatePopup = By.xpath("//li[@data-val='"+state+"']");
		elementUtil.doClick(userStatePopup);
		elementUtil.doSendKeys(userZip, zip);
		elementUtil.waitForElementToBeVisible(userMobilePhno,20);
		elementUtil.doSendKeys(userMobilePhno, mPh);
		elementUtil.doSendKeys(userAlternatePhno, altPhno);
		elementUtil.doSendKeys(userFax, fax);
		elementUtil.doClick(userContinueBtn);
		elementUtil.waitForElementToBeVisible(password, 20);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doSendKeys(conPassword, conPwd);
		//driver.findElement(userPrivacyBtn).click();
		elementUtil.doClick(userPrivacyBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.waitForElementToBeVisible(termsAndCondChck, 20);
		elementUtil.doClick(termsAndCondChck);
		elementUtil.doClick(createAccntBtn);
		sucessMsg = driver.findElement(accntSuccessMsg).getText();
		System.out.println("Account Creation Success Message: "+sucessMsg);
		}catch(Exception e) {
			
		}
		
		return sucessMsg;
		
	}
	
	public void lanuchRhythmURL(String rhythmURL) {
		elementUtil.launchURL(rhythmURL);
	}

}
