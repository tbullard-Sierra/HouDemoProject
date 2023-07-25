package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ElementUtil;

public class CompleteInspectionBackOffice extends BasePage{

	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public CompleteInspectionBackOffice(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	
	By userId = By.xpath("//input[@id='userId']");
	By password = By.xpath("//input[@id='password']");
	By signInBtn = By.xpath("//button[text()='Sign In']");
	By header = By.xpath("//div[@id='moduleHeaderContainer']//a[text()='My Infor']");
	By buildingPerMenu = By.xpath("//div[@class='inforApplicationNav']/ul/li/a[text()='Building Permits']");
	By applicationOption = By.xpath("//li[@id='BldngPrmts']//ul//li/a[text()='Application']");
	By lookUpAppOpt = By.xpath("//li[@id='BldngPrmtsAplctnLkpAplctns']//a[text()='Lookup Applications']");
	By appNumTextBox = By.xpath("//input[@id='_ctl0_SearchEdit_ebApNumber_input']");
	By searchBtn = By.xpath("//button[@id='_ctl0_btn_Search']");
	
	By inspectionTab = By.xpath("//li[contains(@id,'Inspections_tpApplInfo')]/a");
	By inspectionChkBox = By.xpath("//div[text()='Final (AC Final)']/preceding-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");
	By bldInsRecResInfoFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgInspectionRecordResultApplet:')]");
	By insResOpenBtn = By.xpath("//input[contains(@id,'ebInspectionResult_input')]/following-sibling::button/span");
	By approvedChkBox = By.xpath("(//div[text()='Approved'])[1]/preceding-sibling::div[contains(@class,'isCheckboxCell')]/div");
	By selectBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Select']");
	By saveAndCloseBtn = By.xpath("//button[@id='btnSaveClose']/span");
	
	By inspMileStone = By.xpath("//div[@id='_ctl29_ttAppStatus2']//span");
	By finalMileStone = By.xpath("//span[contains(@id,'labelAppStat2')]");
	By iframe = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerApplet:')]");
	By reviewsLnk = By.xpath("//li[@id='_ctl33_Reviews_tpApplInfo']//a");
	By reviewChkBox = By.xpath("//div[@class='content']//div[contains(@aria-describedby,'checkbox-selector')]");
	By reviewNumLnk = By.xpath("//div[contains(@aria-describedby,'ReviewNo')]/a");
	By recordResultsLnk = By.xpath("//div[contains(@id,'ttRecordInspectionResults')]/a");
	
	//String confNo = "MECS2658";
	@Test
	public String completeInspection(String confNo)  {
		
		String finalMilestoneMsg = null;
		try {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		elementUtil = new ElementUtil(driver);
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().deleteAllCookies();
//		driver.get("https://cohipsuat.houstontx.gov/IPS_4_UAT/");
//
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//
//		elementUtil.doSendKeys(userId, "mnath");
//		elementUtil.doSendKeys(password, "Password!0");
//		elementUtil.doClick(signInBtn);
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		Assert.assertTrue(elementUtil.isDisplayed(header));
		
		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		//Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doSendKeys(appNumTextBox, confNo);
		Thread.sleep(2000);
		elementUtil.doClick(searchBtn);
		Thread.sleep(2000);
		By searchRes = By.xpath("//div/a[text()='"+confNo+"']");
		Assert.assertTrue(elementUtil.isDisplayed(searchRes));
		Thread.sleep(2000);
		elementUtil.doClick(searchRes);
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		String milestone = elementUtil.doGetText(inspMileStone);
		System.out.println("MileStone is: " + milestone);
		
		if(milestone.equals(Constants.MILESTONE_INSPECTION_MSG)) {
			
			System.out.println("MileStone is Inspection. Complete Inspection.");
			elementUtil.doClick(inspectionTab);
			elementUtil.doClick(inspectionChkBox);
			elementUtil.doClick(recordResultsLnk);
			elementUtil.switchToParentFrame();
			elementUtil.switchToParentFrame();
			elementUtil.switchToFrameByWebElement(bldInsRecResInfoFrame);
			elementUtil.doSwitchToFrame("viewTab");
			Thread.sleep(2000);
			elementUtil.doClick(insResOpenBtn);
			elementUtil.switchToDefaultContent();
			elementUtil.doSwitchToFrame("__modalFrame__0");
			elementUtil.doSwitchToFrame("menuAndView");
			elementUtil.doSwitchToFrame("hansenView");
			elementUtil.doSwitchToFrame("viewTab");
			Thread.sleep(2000);
			elementUtil.doClick(approvedChkBox);
			elementUtil.switchToDefaultContent();
			elementUtil.doClick(selectBtn);
			elementUtil.switchToDefaultContent();
			elementUtil.doSwitchToFrame("menuAndView");
			elementUtil.doSwitchToFrame("hansenView");
			elementUtil.switchToFrameByWebElement(bldInsRecResInfoFrame);
			elementUtil.doSwitchToFrame("viewTab");
			Thread.sleep(2000);
			elementUtil.doClick(saveAndCloseBtn);
			
			Thread.sleep(2000);
			elementUtil.switchToDefaultContent();
			elementUtil.doSwitchToFrame("menuAndView");
			elementUtil.doSwitchToFrame("hansenView");
			Thread.sleep(2000);
			elementUtil.switchToFrameByWebElement(iframe);
			Thread.sleep(2000);
			elementUtil.doSwitchToFrame("viewTab");
			Thread.sleep(2000);
			finalMilestoneMsg = elementUtil.doGetText(finalMileStone);
			System.out.println("MileStone is: " + finalMilestoneMsg);
			
		}else {
			System.out.println("Milestone is not Inspection. Please check");
		}
		}catch(Exception e) {
			
		}
		return finalMilestoneMsg;
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
