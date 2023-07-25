package com.qa.houpermitproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class MechanicalPermit extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	
//	List<String> output = new ArrayList<String>();
	String confNumber= null;
	//String msg = null;

	public MechanicalPermit(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	By email = By.xpath("//input[@id='username_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By password = By.xpath("//input[@id='password_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By loginBtn = By.xpath("//button[@id='login_submit_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']");
	By myAccount = By.xpath("//button[@id='util-item-myaccount']");
	By cookiesBtn = By.xpath("//div[@class='cc-compliance']//a");

	By applyLink = By.xpath("(//a/span[text()='Register/Apply Now'])[1]");
	By structuralProAndTrPer = By.xpath(
			"//div[@class='tree-tab-content']//p[text()='Structural Project and Trade Permits' and @class='tree-tab-title']");
	By singleTrPer = By.xpath("//div[@class='tree-tab-content']//p[text()='Single Trade Permits' ]");
	By mechPer = By.xpath("//div[@class='tree-item']//p[text()='Mech. Permit - Single Trade' ]");
	// By elecPer = By.xpath("//div[@class='tree-item']//p[text()='Electrical Permit
	// - Single Trade' ]");
	// By plumbPer = By.xpath("//div[@class='tree-item']//p[text()='Plumbing Permit
	// - Single Trade' ]");

	By title = By.xpath("//input[@id='application-name']");
	By workType = By.xpath("//input[@id='work-type']");
	By wTyHAVC = By.xpath("//ul//li/span[text()='HVAC Work Only']/..");
	By occuType = By.xpath("//input[@id='occupancy-type']");
	//By singleResid = By.xpath("//ul//li/span[text()='Residential - Single Residence ']/..");
	By description = By.xpath("//textarea[@id='comments']");
	By sigTrDeclaraitonChck = By
			.xpath("//label[contains(text(),'I confirm that this application ')]//preceding-sibling::input");
	By capacityDropdown = By.xpath("//input[@id='capacity-dropdown']");
	By propertyOwner = By.xpath("//ul//li/span[text()='Property Owner']/..");
	// Return list of text boxes to enter full name, initials, print name. etc.
	By homeOwnerAffList = By.xpath("//div[@id='addDetailDiv']//legend[text()='Home Owner Affidavit']/..//input");
	By homeOwnerFullName = By.xpath("//input[@name='HOFullName']");
	By homeOwnerInitial1 = By.xpath("//input[@name='HOInitials1']");
	By homeOwnerInitial2 = By.xpath("//input[@name='HOInitials2']");
	By homeOwnerInitial3 = By.xpath("//input[@name='HOInitials3']");
	By homeOwnerInitial4 = By.xpath("//input[@name='HOInitials4']");
	By printName = By.xpath("//input[@name='HOPrintName']");
	By homeOwnerItemCount = By.xpath("//input[@name='AlterHVAC']");

	By addPimarySiteBtn = By.xpath("//button[@id='add-site-primary']");
	By postalCodeTxtBox = By.xpath("//input[@id='postal-code']");
	By searchBtn = By.xpath("//button[text()='Search']");
	// Returns list of postal code
	By postcodeList = By.xpath("//div[@class='modal-search-results']//ul/li");
//	By pCodeRadioBtn = By.xpath(
//			"//div[@class='modal-search-results']//ul/li//label[contains(text(),'721 E 10 1/2 ST  HOUSTON TX 77008')]");
	By addSiteBtn = By.xpath("//button[@id='results-add-site']");

	By saveAndConBtn = By.xpath("//button[text()='Save & Continue']");
	By submitBtn = By.xpath("//button[text()='Submit']");
	By popUpSubmitBtn = By.xpath("//section[@class='bbm-container']//button[text()='Submit']");
	By recSubmitMsg = By.xpath("//div//p[contains(text(),'Thank You! Your record')]");
	By confNum = By.xpath("//a[@id='InstrumentDetailLink']");

	public String createMechanicalPermit(String title,String workTy,String occuTy,String desc,String capacity,
			String HOfullName,String HOinit1,String HOinit2,String HOinit3,String HOinit4,String printName,
			String HOitemCnt,String postalCode) {
		try {
					
			Thread.sleep(2000);
			// elementUtil.doClick(applyLink);
			elementUtil.clickElementByJS(elementUtil.getElement(applyLink));
			Thread.sleep(2000);
			elementUtil.doClick(structuralProAndTrPer);
			elementUtil.doClick(singleTrPer);
			elementUtil.doClick(mechPer);
			Thread.sleep(2000);
			elementUtil.doSendKeys(this.title, title);
			elementUtil.doSendKeys(workType, workTy);
			Thread.sleep(2000);
			elementUtil.doClick(wTyHAVC);
			Thread.sleep(2000);
			elementUtil.doSendKeys(occuType, occuTy);
			Thread.sleep(3000);
			By singleResid = By.xpath("//ul//li/span[text()='"+occuTy+"']/..");
			elementUtil.doClick(singleResid);
			elementUtil.doSendKeys(description, desc);
			Thread.sleep(2000);
			// elementUtil.doClick(sigTrDeclaraitonChck);
			elementUtil.clickElementByJS(elementUtil.getElement(sigTrDeclaraitonChck));
			Thread.sleep(2000);
			elementUtil.doSendKeys(capacityDropdown, capacity);
			Thread.sleep(2000);
			elementUtil.doClick(propertyOwner);
			Thread.sleep(2000);
			elementUtil.doSendKeys(homeOwnerFullName, HOfullName);
			elementUtil.doSendKeys(homeOwnerInitial1, HOinit1);
			elementUtil.doSendKeys(homeOwnerInitial2, HOinit2);
			elementUtil.doSendKeys(homeOwnerInitial3, HOinit3);
			elementUtil.doSendKeys(homeOwnerInitial4, HOinit4);
			elementUtil.doSendKeys(this.printName,printName);
			elementUtil.doSendKeys(homeOwnerItemCount, HOitemCnt);
			Thread.sleep(3000);
			elementUtil.doClick(addPimarySiteBtn);
			Thread.sleep(2000);
			elementUtil.doClick(searchBtn);
			//109 W 10TH ST  HOUSTON TX 77008 
			String subString = postalCode.substring(0, 13);
			System.out.println(subString);
			By pCodeRadioBtn = By.xpath("//div[@class='modal-search-results']//ul/li//label[contains(text(),'"+subString+"')]");
			Thread.sleep(5000);
			//elementUtil.doClick(pCodeRadioBtn);
			elementUtil.clickElementByJS(elementUtil.getElement(pCodeRadioBtn));
			elementUtil.doClick(addSiteBtn);
			elementUtil.doClick(saveAndConBtn);
			Thread.sleep(3000);
			elementUtil.doClick(saveAndConBtn);
			Thread.sleep(2000);
			elementUtil.doClick(submitBtn);
			Thread.sleep(2000);
			elementUtil.doClick(popUpSubmitBtn);
//			Thread.sleep(2000);
//			msg = elementUtil.doGetText(recSubmitMsg);
//			System.out.println(msg);
			// Assert.assertEquals(msg, "Thank You! Your record was submitted.");
			Thread.sleep(3000);
			confNumber = elementUtil.doGetText(confNum);
			System.out.println("Confirmation Number is: " + confNumber);
			
//			output.add(msg);
//			output.add(confNumber);
			Thread.sleep(2000);
			
		} catch (Exception e) {
			//return null;
		}
		return confNumber;
		
	}
	
	public String applyMecPerWithAEorARLicense(String title,String workTy,String occuTy,String desc,String capacity,
			String HOfullName,String HOinit1,String HOinit2,String HOinit3,String HOinit4,String printName,
			String HOitemCnt,String postalCode) {
		try {
					
			Thread.sleep(2000);
			// elementUtil.doClick(applyLink);
			elementUtil.clickElementByJS(elementUtil.getElement(applyLink));
			Thread.sleep(2000);
			elementUtil.doClick(structuralProAndTrPer);
			elementUtil.doClick(singleTrPer);
			elementUtil.doClick(mechPer);
			Thread.sleep(2000);
			elementUtil.doSendKeys(this.title, title);
			elementUtil.doSendKeys(workType, workTy);
			Thread.sleep(2000);
			elementUtil.doClick(wTyHAVC);
			Thread.sleep(2000);
			elementUtil.doSendKeys(occuType, occuTy);
			Thread.sleep(3000);
			By singleResid = By.xpath("//ul//li/span[text()='"+occuTy+"']/..");
			elementUtil.doClick(singleResid);
			elementUtil.doSendKeys(description, desc);
			Thread.sleep(2000);
			// elementUtil.doClick(sigTrDeclaraitonChck);
			elementUtil.clickElementByJS(elementUtil.getElement(sigTrDeclaraitonChck));
			Thread.sleep(2000);
			elementUtil.doSendKeys(capacityDropdown, capacity);
			Thread.sleep(2000);
			elementUtil.doClick(propertyOwner);
			Thread.sleep(2000);
			elementUtil.doSendKeys(homeOwnerFullName, HOfullName);
			elementUtil.doSendKeys(homeOwnerInitial1, HOinit1);
			elementUtil.doSendKeys(homeOwnerInitial2, HOinit2);
			elementUtil.doSendKeys(homeOwnerInitial3, HOinit3);
			elementUtil.doSendKeys(homeOwnerInitial4, HOinit4);
			elementUtil.doSendKeys(this.printName,printName);
			elementUtil.doSendKeys(homeOwnerItemCount, HOitemCnt);
			Thread.sleep(3000);
			elementUtil.doClick(addPimarySiteBtn);
			Thread.sleep(2000);
			elementUtil.doClick(searchBtn);
			//109 W 10TH ST  HOUSTON TX 77008 
			String subString = postalCode.substring(0, 13);
			System.out.println(subString);
			By pCodeRadioBtn = By.xpath("//div[@class='modal-search-results']//ul/li//label[contains(text(),'"+subString+"')]");
			Thread.sleep(5000);
			//elementUtil.doClick(pCodeRadioBtn);
			elementUtil.clickElementByJS(elementUtil.getElement(pCodeRadioBtn));
			elementUtil.doClick(addSiteBtn);
			elementUtil.doClick(saveAndConBtn);
			Thread.sleep(3000);
			elementUtil.doClick(saveAndConBtn);
			Thread.sleep(2000);
			elementUtil.doClick(submitBtn);
			Thread.sleep(2000);
			elementUtil.doClick(popUpSubmitBtn);
//			Thread.sleep(2000);
//			msg = elementUtil.doGetText(recSubmitMsg);
//			System.out.println(msg);
			// Assert.assertEquals(msg, "Thank You! Your record was submitted.");
			Thread.sleep(3000);
			confNumber = elementUtil.doGetText(confNum);
			System.out.println("Confirmation Number is: " + confNumber);
			
//			output.add(msg);
//			output.add(confNumber);
			Thread.sleep(2000);
			
		} catch (Exception e) {
			//return null;
		}
		return confNumber;
		
	}
	
	public String applyMecPerWithBEorBRLicense(String title,String workTy,String occuTy,String desc,String capacity,
			String HOfullName,String HOinit1,String HOinit2,String HOinit3,String HOinit4,String printName,
			String HOitemCnt,String postalCode) {
		try {
					
			Thread.sleep(2000);
			// elementUtil.doClick(applyLink);
			elementUtil.clickElementByJS(elementUtil.getElement(applyLink));
			Thread.sleep(2000);
			elementUtil.doClick(structuralProAndTrPer);
			elementUtil.doClick(singleTrPer);
			elementUtil.doClick(mechPer);
			Thread.sleep(2000);
			elementUtil.doSendKeys(this.title, title);
			elementUtil.doSendKeys(workType, workTy);
			Thread.sleep(2000);
			elementUtil.doClick(wTyHAVC);
			Thread.sleep(2000);
			elementUtil.doSendKeys(occuType, occuTy);
			Thread.sleep(3000);
			By singleResid = By.xpath("//ul//li/span[text()='"+occuTy+"']/..");
			elementUtil.doClick(singleResid);
			elementUtil.doSendKeys(description, desc);
			Thread.sleep(2000);
			elementUtil.clickElementByJS(elementUtil.getElement(sigTrDeclaraitonChck));
			Thread.sleep(2000);
			elementUtil.doSendKeys(capacityDropdown, capacity);
			Thread.sleep(2000);
			elementUtil.doClick(propertyOwner);
			Thread.sleep(2000);
			elementUtil.doSendKeys(homeOwnerFullName, HOfullName);
			elementUtil.doSendKeys(homeOwnerInitial1, HOinit1);
			elementUtil.doSendKeys(homeOwnerInitial2, HOinit2);
			elementUtil.doSendKeys(homeOwnerInitial3, HOinit3);
			elementUtil.doSendKeys(homeOwnerInitial4, HOinit4);
			elementUtil.doSendKeys(this.printName,printName);
			elementUtil.doSendKeys(homeOwnerItemCount, HOitemCnt);
			Thread.sleep(3000);
			elementUtil.doClick(addPimarySiteBtn);
			Thread.sleep(2000);
			elementUtil.doClick(searchBtn);
			String subString = postalCode.substring(0, 13);
			System.out.println(subString);
			By pCodeRadioBtn = By.xpath("//div[@class='modal-search-results']//ul/li//label[contains(text(),'"+subString+"')]");
			Thread.sleep(5000);
			elementUtil.clickElementByJS(elementUtil.getElement(pCodeRadioBtn));
			elementUtil.doClick(addSiteBtn);
			elementUtil.doClick(saveAndConBtn);
			Thread.sleep(3000);
			elementUtil.doClick(saveAndConBtn);
			Thread.sleep(2000);
			elementUtil.doClick(submitBtn);
			Thread.sleep(2000);
			elementUtil.doClick(popUpSubmitBtn);
			Thread.sleep(3000);
			confNumber = elementUtil.doGetText(confNum);
			System.out.println("Confirmation Number is: " + confNumber);
			Thread.sleep(2000);
			
		} catch (Exception e) {
		}
		return confNumber;
		
	}
	

}
