package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class LoginPage_HouPer extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	public LoginPage_HouPer(WebDriver driver) {

		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	By email = By.xpath("//input[@id='username_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By password = By.xpath("//input[@id='password_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By loginBtn = By.xpath("//button[@id='login_submit_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By myAccount = By.xpath("//button[@id='util-item-myaccount']");
	By cookiesBtn = By.xpath("//div[@class='cc-compliance']//a");
	
	public String doLoginHouPer(String email, String password) throws InterruptedException {

		if(elementUtil.isDisplayed(cookiesBtn)) {
			elementUtil.doClick(cookiesBtn);
		}
		Thread.sleep(3000);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.clickElementByJS(elementUtil.getElement(loginBtn));
		//Thread.sleep(1000);
		String myAcctText = elementUtil.doGetText(myAccount);

		return myAcctText;
	}

}
