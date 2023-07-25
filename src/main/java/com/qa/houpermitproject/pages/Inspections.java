package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class Inspections extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	public Inspections(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	

	By email = By.xpath("//input[@id='username_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By password = By.xpath("//input[@id='password_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By loginBtn = By.xpath("//button[@id='login_submit_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By myAccount = By.xpath("//button[@id='util-item-myaccount']");
	By cookiesBtn = By.xpath("//div[@class='cc-compliance']//a");

	By dashBoardTab = By.xpath("a[href='https://houstontx-tst.rhythmlabs.infor.com/my-dashboard']");
	By reqInspBtn = By.xpath(
			"(//div[@class='col col-result-code']/following-sibling::div/button[text()='Request Inspection'])[1]");
	By reqDateField = By.xpath("//input[@id='requestDate']");
	By locationDetailsField = By
			.xpath("//div[@class='field location-container location-details']//textarea[@name='locationDetails']");
	By contactPerson = By.xpath("//input[@name='contactPerson']");
	By contactInfo = By.xpath("//input[@id='contactInfo']");
	By speInstructions = By.xpath("//textarea[@name='specialInstructions']");
	//By submitReqBtn = By.xpath("//button[@id='inspectionRequest-submitRequestBtn']");
	By submitReqBtn = By.xpath("//button[text()='Submit Request']");
	By rescheduleBtn = By.xpath("(//button[@id='inspectionResult-rescheduleBtn'])[1]");
	By rescheduleReqDate = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	
	By cancelReqBtn = By.xpath("(//button[@id='inspectionResult-cancelRequestBtn'])[1]");
	By cancelReqMsg = By.xpath("//section[@id='inspection-cancel-content']/div/p");
	By cancelReqConfBtn = By.xpath("//button[@id='cancelInspectionRequest-cancelConfirmationBtn']");
	
	
	
	public String requestForScheduleInspection(String conNo, String reqDate, String locDetails, String contPerson,
			String contInfo, String instructions) {
		
		String schDate =null;
		try {
			
			
			Thread.sleep(5000);
			By perItem = By
					.xpath("//div[@class='paging-items-container']//div[@class='default-value-class']//a[@id='ItemLink_"
							+ conNo + "']");
			elementUtil.doClick(perItem);
			Thread.sleep(5000);
			
			elementUtil.doClick(reqInspBtn);
			Thread.sleep(5000);
			elementUtil.doSendKeys(reqDateField, reqDate);
			elementUtil.doSendKeys(locationDetailsField, locDetails);
			elementUtil.doSendKeys(contactPerson, contPerson);
			elementUtil.doSendKeys(contactInfo, contInfo);
			elementUtil.doSendKeys(speInstructions, instructions);
			Thread.sleep(2000);
			driver.findElement(submitReqBtn).click();
			Thread.sleep(5000);
			By scheduleDate = By.xpath("(//div[@class='col col-scheduled-date']//span[text()='"+reqDate+"'])[last()]");
			schDate = elementUtil.doGetText(scheduleDate);
			System.out.println("Scheduled Request Date: "+schDate);
			
		} catch (Exception e) {

		}
		
		return schDate;
	}
	
	
	
	
	
	public void rescheduleInsp(String confNo,String reschDate)  {
		try {

		//elementUtil.doClick(dashBoardTab);
		Thread.sleep(5000);
		By perItem = By.xpath("//div[@class='summary-card']//div[@class='default-value-class']//a[@id='ItemLink_"+confNo+"']");
		elementUtil.doClick(perItem);
		Thread.sleep(5000);
		//driver.findElement(rescheduleBtn).click();
		elementUtil.doClick(rescheduleBtn);
		Thread.sleep(5000);
		elementUtil.getElement(reqDateField).clear();
		elementUtil.doSendKeys(reqDateField, reschDate);
		Thread.sleep(2000);
		elementUtil.doClick(submitReqBtn);
		
		}catch(Exception e) {
			
		}
	}
	
	
	public String cancelInspection(String confNo) {
		
		String msg = null;
		try {
			Thread.sleep(3000);
			By perItem = By.xpath("//div[@class='summary-card']//div[@class='default-value-class']//a[@id='ItemLink_"+confNo+"']");
		elementUtil.doClick(perItem);
		Thread.sleep(5000);
		elementUtil.doClick(cancelReqBtn);
		msg = elementUtil.doGetText(cancelReqMsg);
		Thread.sleep(3000);
		elementUtil.doClick(cancelReqConfBtn);
		}catch(Exception e) {
			
		}
		
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
