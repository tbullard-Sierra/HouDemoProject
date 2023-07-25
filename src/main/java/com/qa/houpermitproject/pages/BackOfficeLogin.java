package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class BackOfficeLogin extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	public BackOfficeLogin(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	By userId = By.xpath("//input[@id='userId']");
	By password = By.xpath("//input[@id='password']");
	By signInBtn = By.xpath("//button[text()='Sign In']");
	By header = By.xpath("//div[@id='moduleHeaderContainer']//a[text()='My Infor']");
	
	
		public String loginToBackOffice(String url,String email, String password) {
			String headerText = null;
		try {
		elementUtil.launchURL(url);
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSendKeys(userId, email);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(signInBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		Thread.sleep(2000);
		headerText = elementUtil.doGetText(header);
		System.out.println("Header Text is: "+headerText);
		//Assert.assertTrue(elementUtil.isDisplayed(header));
		}catch(Exception e) {
			
		}
		return headerText;
	}
		
		
		
		
	
}
