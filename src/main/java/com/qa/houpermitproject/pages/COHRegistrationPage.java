package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class COHRegistrationPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	public WebElement headerEle;
	public COHRegistrationPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
		
		
	}

	
	By regLink = By.xpath("//a[@class='nav-link-primary item-link']/span[text()='Register/Apply Now']");
	public By regHeader = By.xpath("//h2[text()='Submit a New Record']");
	
	
	public String doClickRegLink() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//elementUtil.doClick(regLink);
		Reporter.log("Click on Register link");
		elementUtil.clickElementByJS(elementUtil.getElement(regLink));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		headerEle =elementUtil.getElement(regHeader);
		Reporter.log("Capturing register page header");
		String headerText = elementUtil.doGetText(regHeader);
		System.out.println("Register page header : "+headerText);
		return headerText;
	}
	
	
	
}
