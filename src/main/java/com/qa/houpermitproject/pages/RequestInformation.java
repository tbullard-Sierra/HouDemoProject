package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class RequestInformation extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil ;
	
	
	public RequestInformation(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver =driver;
	}
	
	By reqInfoLnk = By.xpath("//li[@class='log-link-row']//a[contains(text(),'Request Information')]");
	By description = By.xpath("//div[@class='field field-description']//textarea[@id='newlink-description']");
	By logDate = By.xpath("//div[@class='list-container']//div[@class='col log-date']//p");
	By comments = By.xpath("(//div[@class='comments'])[last()]");
	By reqInfoBtn = By.xpath("//div[@class='bbm-modal-bottombar']//button[@class='btn btn-primary submit-button']");
	
	String custComments = null;
	public String requestInfo(String confNo,String desc) {
		
		
		try {
		Thread.sleep(3000);
		By perItem = By.xpath("//div[@class='summary-card']//div[@class='default-value-class']//a[@id='ItemLink_"+confNo+"']");
		elementUtil.waitForElementToBeVisible(perItem, 30);
		elementUtil.doClick(perItem);
		Thread.sleep(5000);
		//elementUtil.waitForElementToBeClickable(reqInfoLnk, 50);
		elementUtil.doClick(reqInfoLnk);
		Thread.sleep(3000);
		elementUtil.doSendKeys(description, desc);
		Thread.sleep(3000);
		elementUtil.doClick(reqInfoBtn);
		Thread.sleep(2000);
		String logDateText = elementUtil.doGetText(logDate);
		System.out.println("Last Request Updated date-"+logDateText);
		Thread.sleep(5000);
		custComments = driver.findElement(comments).getText();
		//System.out.println(custComments);
		}catch(Exception e) {
			
		}
		
		return custComments;
	}
}
