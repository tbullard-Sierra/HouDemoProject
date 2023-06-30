package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class COHhomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	public COHhomePage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	
	By emailAddress = By.id("username_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_");
	By password = By.id("password_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_");
	
	public boolean doVerifyEmailFieldDisplay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elementUtil.getElement(emailAddress).isDisplayed();
	}
	
	public boolean doVerifyPasswordFieldDisplay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elementUtil.getElement(password).isDisplayed();
		
	}
}
