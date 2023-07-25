package com.qa.houpermitproject.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackOffice extends BasePage{


	WebDriver driver;
	ElementUtil elementUtil;
	
	public BackOffice(WebDriver driver) {
		
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
	//div[@id='_ctl29_ttAppStatus2']//span[contains(text(),'Awaiting Fee Payment.')]
	By mileStone = By.xpath("//div[contains(@id,'_ttAppStatus2')]//span[contains(text(),'Current milestone')]");
	By iframe = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerApplet:')]");
	By reviewsLnk = By.xpath("//li[@id='_ctl33_Reviews_tpApplInfo']//a");
	By reviewChkBox = By.xpath("//div[@class='content']//div[contains(@aria-describedby,'checkbox-selector')]");
	By reviewNumLnk = By.xpath("//div[contains(@aria-describedby,'ReviewNo')]/a");
	By recordResultsLnk = By.xpath("//div[contains(@id,'ttRecordReviewResults')]/a");
	
	By reviewRecordResultsFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgReviewRecordResultApplet:')]");
	By reviewResultsOpenBtn = By.xpath("//input[contains(@id,'ReviewResult_input')]/following-sibling::button/span");
	By approvalChkBox = By.xpath("//div[text()='Review approved']/preceding-sibling::div/following-sibling::div[contains(@aria-describedby,'checkbox-selector')]");
	By selectBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Select']");
	By saveAndCloseBtn = By.xpath("//button[@id='btnSaveClose']/span");
	
	By wrkTyText = By.xpath("//div[contains(@id,'_ctl1_ebWorkType')]//input[contains(@id,'ebWorkType_input')]");
	By occTyText = By.xpath("//div[@id='_ctl1_ebOccupancyType']//input[contains(@id,'ebOccupancyType_input')]");
	By appNameText = By.xpath("//div[@id='_ctl1_ebApplicationName']//input[contains(@id,'ebApplicationName_input')]");
	
	List<String> values = new ArrayList<String>();
	
	
	/**
	 * 
	 * @param confNo
	 * @return multiple values in the form of array list
	 */
	public List<String> preScreenStatusWithMulitpleValuesValidation(String confNo) {
		
		String milestone = null;
		try {
		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		Thread.sleep(1000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doSendKeys(appNumTextBox, confNo);
		Thread.sleep(1000);
		elementUtil.doClick(searchBtn);
		Thread.sleep(1000);
		By searchRes = By.xpath("//div/a[text()='"+confNo+"']");
		Assert.assertTrue(elementUtil.isDisplayed(searchRes));
		Thread.sleep(1000);
		elementUtil.doClick(searchRes);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		//Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		//Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		
	
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		//Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		//Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		
		//String wTyText = elementUtil.doGetText(wrkTyText);
		//String wTyText = elementUtil.getText(wrkTyText, "input");
		String wTyText = elementUtil.getTextByJS(elementUtil.getElement(wrkTyText));
		System.out.println("WorkType from BackOffice: "+wTyText);
		Thread.sleep(2000);
		//String oTyText = elementUtil.doGetText(occTyText);
		String oTyText = elementUtil.getTextByJS(elementUtil.getElement(occTyText));
		System.out.println("Occupancy Type from BackOffice: "+oTyText);
		Thread.sleep(2000);
		//String appNameTxt = elementUtil.doGetText(appNameText);
		String appNameTxt = elementUtil.getTextByJS(elementUtil.getElement(appNameText));
		System.out.println("Application Name from BackOffice: "+appNameTxt);
		
		
		values.add(milestone);
		values.add(wTyText);
		values.add(oTyText);
		values.add(appNameTxt);
		
		}catch(Exception e) {
			
		}
		return values;
	}
	
	
	
/**
 * 
 * @param confNo
 * @return single Milestone
 */
	
	
	
	
	public String preScreenStatus(String confNo) {
		
		String milestone = null;
		try {
		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		Thread.sleep(2000);
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
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		
//		By wrkTyText = By.xpath("//div[@id='_ctl1_ebWorkType']//input[contains(@id,'ebWorkType_input')]");
//		By occTyText = By.xpath("//div[@id='_ctl1_ebOccupancyType']//input[contains(@id,'ebOccupancyType_input')]");
//		By appNameText = By.xpath("//div[@id='_ctl1_ebApplicationName']//input[contains(@id,'ebApplicationName_input')]");
//		Thread.sleep(2000);
//		
//		String wTyText = elementUtil.doGetText(wrkTyText);
//		System.out.println("WorkType from BackOffice: "+wTyText);
//		Thread.sleep(2000);
//		String oTyText = elementUtil.doGetText(occTyText);
//		System.out.println("Occupancy Type from BackOffice: "+oTyText);
//		Thread.sleep(2000);
//		String appNameTxt = elementUtil.doGetText(appNameText);
//		System.out.println("Application Name from BackOffice: "+appNameTxt);
			
				
		}catch(Exception e) {
			
		}
		return milestone;
	}
	
	
		By closeArrowBtn = By.xpath("//button[@id='btn_Close']/span");
	public String approvePermitAndSatusAwaitingFeePayment() {
		
		String milestone = null;
		try {
		Thread.sleep(2000);
		elementUtil.doClick(reviewsLnk);
		Thread.sleep(2000);
		elementUtil.doClick(reviewChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(recordResultsLnk);
		elementUtil.switchToParentFrame(); 
		elementUtil.switchToParentFrame(); 
		elementUtil.switchToFrameByWebElement(reviewRecordResultsFrame);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(reviewResultsOpenBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(approvalChkBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(reviewRecordResultsFrame);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(saveAndCloseBtn);
		Thread.sleep(2000);
		
		
//		//extra code starts from here
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//		Thread.sleep(2000);
//		elementUtil.switchToFrameByWebElement(iframe);
//		elementUtil.doClick(closeArrowBtn);
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
//		elementUtil.doSwitchToFrame("viewTab");
//		Thread.sleep(2000);
//		By searchRes = By.xpath("//div/a[text()='"+confNo+"']");
//		Assert.assertTrue(elementUtil.isDisplayed(searchRes));
//		Thread.sleep(2000);
//		elementUtil.doClick(searchRes);
//		
//		//ends here
				
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(4000);
		milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		
		}catch(Exception e) {
			
		}
		
		return milestone;
	}
	
	public String payFeesAndStatusInspection() {
		String milestone = null;
		try {
		elementUtil.waitForElementToBeVisible(feesLnk, 30);
		elementUtil.doClick(feesLnk);
		elementUtil.waitForElementToBeVisible(payFeesLnk, 30);
		elementUtil.doClick(payFeesLnk);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(feePayFrame);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(feeChck);
		Thread.sleep(2000);
		elementUtil.doClick(addFeeBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.waitForElementToBeVisible(saveBtn, 30);
		elementUtil.doClick(saveBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(feePayFrame);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.waitForElementToBeVisible(payBtn, 30);
		elementUtil.doClick(payBtn);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		}catch(Exception e) {
			
		}
		return milestone;
	}
		
	@Test (enabled=false)
	public void mechPerFeePayment() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		elementUtil = new ElementUtil(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://cohipsuat.houstontx.gov/IPS_4_UAT/");
		
		//driver.switchTo().frame("menuAndView");
		elementUtil.doSwitchToFrame("menuAndView");
		//driver.switchTo().frame("hansenView");
		elementUtil.doSwitchToFrame("hansenView");
		
		elementUtil.doSendKeys(userId, "mnath");
		elementUtil.doSendKeys(password, "Password!0");
		elementUtil.doClick(signInBtn);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		Assert.assertTrue(elementUtil.isDisplayed(header));
		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		//elementUtil.doClick(lookUpAppOpt);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doSendKeys(appNumTextBox, "MECS2570");
		Thread.sleep(2000);
		elementUtil.doClick(searchBtn);
		Thread.sleep(2000);
		By searchRes = By.xpath("//div/a[text()='MECS2570']");
		Assert.assertTrue(elementUtil.isDisplayed(searchRes));
		Thread.sleep(2000);
		elementUtil.doClick(searchRes);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		String milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		
		Assert.assertEquals(milestone, Constants.MILESTONE_PRE_SCREEN_MSG);
		
		elementUtil.doClick(reviewsLnk);
		Thread.sleep(2000);
		elementUtil.doClick(reviewChkBox);
		//elementUtil.clickElementByJS(elementUtil.getElement(reviewChkBox));
		Thread.sleep(2000);
		//elementUtil.doClick(reviewNumLnk);
		elementUtil.doClick(recordResultsLnk);
		
		elementUtil.switchToParentFrame(); 
		elementUtil.switchToParentFrame(); 
		elementUtil.switchToFrameByWebElement(reviewRecordResultsFrame);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		//elementUtil.clickElementByJS(elementUtil.getElement(reviewResultsOpenBtn));
		
		elementUtil.doClick(reviewResultsOpenBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(approvalChkBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(reviewRecordResultsFrame);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(saveAndCloseBtn);

	}
	
	public String checkStatusAwaitingFeePayment(String confNo)  {
		String milestone = null;
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
		Thread.sleep(2000);
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
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		
		}catch(Exception e) {
			
		}
		return milestone;
	}
	
	By feesLnk = By.xpath("//li[@title='Fees']/a");
	By payFeesLnk = By.xpath("//div[contains(@id,'ActFeesPayFeesLink')]/a");
	By feePayFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgFeePayApplet')]");
	By addFeeBtn = By.xpath("//button[@id='gFeePayments_new']/span");
	By feeChck = By.xpath("//fieldset[@id='gFeePayGrid']//div[contains(@id,'FeeStatus')]/preceding-sibling::div/following-sibling::div/span/div");
	By saveBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Save']");
	By payBtn = By.xpath("//button[@class='inforIconButton pay']");
	
	
	@Test(dependsOnMethods = "checkStatusAwaitingFeePayment")
	public void payFees() throws InterruptedException {
		
		elementUtil.waitForElementToBeVisible(feesLnk, 30);
		elementUtil.doClick(feesLnk);
		elementUtil.waitForElementToBeVisible(payFeesLnk, 30);
		elementUtil.doClick(payFeesLnk);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(feePayFrame);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(feeChck);
		Thread.sleep(2000);
		elementUtil.doClick(addFeeBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.waitForElementToBeVisible(saveBtn, 30);
		elementUtil.doClick(saveBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(feePayFrame);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.waitForElementToBeVisible(payBtn, 30);
		elementUtil.doClick(payBtn);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
	}
	
	
	@Test
	public void statusInspectionMilestoneCheck() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		elementUtil = new ElementUtil(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://cohipsuat.houstontx.gov/IPS_4_UAT/");
		
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSendKeys(userId, "mnath");
		elementUtil.doSendKeys(password, "Password!0");
		elementUtil.doClick(signInBtn);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		Assert.assertTrue(elementUtil.isDisplayed(header));
		
		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doSendKeys(appNumTextBox, "MECS2570");
		Thread.sleep(2000);
		elementUtil.doClick(searchBtn);
		Thread.sleep(2000);
		By searchRes = By.xpath("//div/a[text()='MECS2570']");
		Assert.assertTrue(elementUtil.isDisplayed(searchRes));
		Thread.sleep(2000);
		elementUtil.doClick(searchRes);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		String milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: "+milestone);
		
		Assert.assertEquals(milestone, Constants.MILESTONE_INSPECTION_MSG);
	}
	
	By myDashBoardLnk = By.xpath("//nav[@class='dynamic-menu dynamic-menu-header']//a//span[text()='My Dashboard']");
	By reqDate = By.xpath("//div[@class='datepicker-container']//input[@id='requestDate']");
	By reqTime = By.xpath("//div[@class='field request-time-container']//input[@id='time-preference']");
	By reqTimeDropdownBtn = By.xpath("//div[@class='field request-time-container']//button[@class='btn btn-icon droppy-toggle']");
	By reqTimeOption = By.xpath("//div[@class='field request-time-container']//ul[@class='droppy-list']/li[@data-val='NA']");
	@Test
	public void requestForInspectionRhythm() {
		
		String conNo ="MECS2570";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		elementUtil = new ElementUtil(driver);
		LoginPage_HouPer login = new LoginPage_HouPer(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://houstontx-tst.rhythmlabs.infor.com/home");
		//ItemLink_MECS2570
		login.doLoginHouPer("https://houstontx-tst.rhythmlabs.infor.com/","m.nath@sierradigitalinc.com", "Sierra@2023");
		elementUtil.waitForElementToBeVisible(myDashBoardLnk, 30);
		//elementUtil.doClick(myDashBoardLnk);
		By perItem = By.xpath("//div[@class='paging-items-container']//div[@class='default-value-class']//a[@id='ItemLink_"+conNo+"']");
		elementUtil.waitForElementToBeVisible(perItem, 30);
		elementUtil.doClick(perItem);
		//elementUtil.clickElementByJS(elementUtil.getElement(perItem));
		
		By reqInspBtn = By.xpath("//button[@id='InspectionResultRequestInspectionBtn_4029']");
		elementUtil.waitForElementToBeVisible(reqInspBtn, 30);
		//elementUtil.doClick(reqInspBtn);
		elementUtil.clickElementByJS(elementUtil.getElement(reqInspBtn));
		elementUtil.waitForElementToBeVisible(reqDate, 30);
		elementUtil.doSendKeys(reqDate, "07/07/2023");
		elementUtil.waitForElementToBeVisible(reqTime, 30);
		elementUtil.doClick(reqTime);
		//elementUtil.doClick(reqTimeDropdownBtn);
		elementUtil.waitForElementToBeVisible(reqTimeOption, 30);
		elementUtil.doClick(reqTimeOption);
	}
	
	By startApp = By.xpath("//li[@id='BldngPrmtsAplctnStrtAplctn']//a[text()='Start Application']");
	By appTyBtn = By.xpath("//div[@id='APTypeEditBox_inputContainer']//input[@id='APTypeEditBox_input']/following-sibling::button");
	//div[@id='APTypeEditBox_inputContainer']//button[@class='inforTriggerButton inforLookupButton']/span[text()='Open']
	//div[@id='APTypeEditBox_inputContainer']//input[@id='APTypeEditBox_input']/following-sibling::button
	By startAppIframe = By.xpath("//iframe[@title='Start Application (BPSA) ']");
	
	By stNoTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStNum_input')]");
	By preDirTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebPreDir_input')]");
	By stNameTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]");
	By stNameBtn = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button/span");
	//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button/span
	//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button
	By applicantsTab = By.xpath("//li[@id='tpgApplApplicants']/a");
	By capcityBtn = By.xpath("//div[contains(@id,'CapacityType_inputContainer')]/button");
	By capTyChckBox = By.xpath("//div[text()='Owner']/preceding-sibling::div/following-sibling::div/div");
	
	By applicantLastName = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebLastName_input')]");
	By applicantFirstName = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebFirstName_input')]");
	By contactTy = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebcontactType_input')]");
	By applicantMobile = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebMobile_input')]");
	By applicantAltPhNo = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebDayPhone_input')]");
	By address = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebAddressLine1_input')]");
	By email = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebemail_input')]");
	By city = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebCity_input')]");
	By state = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebState_input')]");
	By zip = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebZip_input')]");
	
	By jobDescTab = By.xpath("//li[@id='tpgApplJobDescription']/a");
	By workTy = By.xpath("//input[contains(@id,'WorkTypeEditBox_input')]");
	By occupancyTy = By.xpath("//input[contains(@id,'OccupancyTypeEditBox_input')]");
	By apName = By.xpath("//input[contains(@id,'APNameEditBox_input')]");
	By descOfWork = By.xpath("//div[contains(@class,'inforRichTextEditor')]");
	
	
	@Test
	public void applyMechPermitFromBackOffice() throws InterruptedException {
		
		String appType ="MECS";
		String streetName = "DREW";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		elementUtil = new ElementUtil(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://cohipsuat.houstontx.gov/IPS_4_UAT/");

		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		
		elementUtil.doSendKeys(userId, "mnath");
		elementUtil.doSendKeys(password, "Password!0");
		elementUtil.doClick(signInBtn);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		Assert.assertTrue(elementUtil.isDisplayed(header));
		
		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		//elementUtil.doClick(lookUpAppOpt);
		elementUtil.clickElementByJS(elementUtil.getElement(startApp));
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(3000);
		//elementUtil.waitForElementToBeVisible(appTyBtn, 30);
		elementUtil.doClick(appTyBtn);
		//elementUtil.clickElementByJS(elementUtil.getElement(appTyBtn));
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		By appTyChkBox = By.xpath("//div[text()='"+appType+"']/preceding-sibling::div/following-sibling::div/div");
		elementUtil.waitForElementToBeVisible(appTyChkBox, 30);
		elementUtil.doClick(appTyChkBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		//elementUtil.waitForElementToBeVisible(stNoTxtBox, 30);
		elementUtil.doSendKeys(stNoTxtBox, "101");
		Thread.sleep(2000);
		elementUtil.doSendKeys(preDirTxtBox, "W");
		Thread.sleep(2000);
		elementUtil.doClick(preDirTxtBox);
		Thread.sleep(2000);
		elementUtil.doSendKeys(stNameTxtBox, streetName);
		Thread.sleep(2000);
		elementUtil.doClick(stNameTxtBox);
		Thread.sleep(2000);
		elementUtil.doClick(stNameBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		//elementUtil.switchToFrameByWebElement(By.xpath("//iframe[@data-auto-uid='Hansen.Property.AddressCustomPopup']"));
		By addChckBox = By.xpath("//div[text()='"+streetName+"']/preceding-sibling::div/following-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");
		elementUtil.doClick(addChckBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doClick(applicantsTab);
		Thread.sleep(2000);
		elementUtil.doClick(capcityBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doClick(capTyChckBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doSendKeys(applicantFirstName, "Dave");
		elementUtil.doSendKeys(applicantLastName, "John,M");
		elementUtil.doSendKeys(contactTy, "Employee");
		elementUtil.doClick(contactTy);
		elementUtil.doSendKeys(applicantMobile, "2301201201");
		elementUtil.doSendKeys(applicantAltPhNo, "3021023010");
		elementUtil.doSendKeys(address, "6001 Savoy Dr");
		elementUtil.doSendKeys(email, "123dJo@gmail.com");
		elementUtil.doSendKeys(city, "Houston");
		elementUtil.doSendKeys(state, "TX");
		elementUtil.doSendKeys(zip, "77036");
		elementUtil.doClick(jobDescTab);
		elementUtil.doSendKeys(workTy, "HVAC");
		elementUtil.doClick(workTy);
		elementUtil.doSendKeys(occupancyTy, "ResSng");
		elementUtil.doClick(occupancyTy);
		elementUtil.doSendKeys(apName, "Test Application");
		elementUtil.doSendKeys(descOfWork, "Test Application");

		
	}
	
}
