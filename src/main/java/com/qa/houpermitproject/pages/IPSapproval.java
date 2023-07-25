package com.qa.houpermitproject.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.houpermitproject.constants.Constants;
import com.qa.houpermitproject.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class IPSapproval {

	WebDriver driver;
	ElementUtil elementUtil;
		
	
	// By formLogin = By.
	By userId = By.xpath("//input[@id='userId']");
	By password = By.xpath("//input[@id='password']");
	By signInBtn = By.xpath("//button[text()='Sign In']");
	By header = By.xpath("//div[@id='moduleHeaderContainer']//a[text()='My Infor']");
	By buildingPerMenu = By.xpath("//div[@class='inforApplicationNav']/ul/li/a[text()='Building Permits']");
	By applicationOption = By.xpath("//li[@id='BldngPrmts']//ul//li/a[text()='Application']");
	By lookUpAppOpt = By.xpath("//li[@id='BldngPrmtsAplctnLkpAplctns']//a[text()='Lookup Applications']");
	By appNumTextBox = By.xpath("//input[@id='_ctl0_SearchEdit_ebApNumber_input']");
	By searchBtn = By.xpath("//button[@id='_ctl0_btn_Search']");

	By mileStone = By.xpath("//div[@id='_ctl29_ttAppStatus2']//span");
	By iframe = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerApplet:')]");
	By reviewsLnk = By.xpath("//li[@id='_ctl33_Reviews_tpApplInfo']//a");
	By reviewChkBox = By.xpath("//div[@class='content']//div[contains(@aria-describedby,'checkbox-selector')]");
	By reviewNumLnk = By.xpath("//div[contains(@aria-describedby,'ReviewNo')]/a");
	By recordResultsLnk = By.xpath("//div[contains(@id,'ttRecordReviewResults')]/a");

	By reviewRecordResultsFrame = By
			.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgReviewRecordResultApplet:')]");
	By reviewResultsOpenBtn = By.xpath("//input[contains(@id,'ReviewResult_input')]/following-sibling::button/span");
	By approvalChkBox = By.xpath(
			"//div[text()='Review approved']/preceding-sibling::div/following-sibling::div[contains(@aria-describedby,'checkbox-selector')]");
	By selectBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Select']");
	By saveAndCloseBtn = By.xpath("//button[@id='btnSaveClose']/span");

	@Test(enabled = false)
	public void mechPerFeePayment() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		elementUtil = new ElementUtil(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://cohipsuat.houstontx.gov/IPS_4_UAT/");

		// driver.switchTo().frame("menuAndView");
		elementUtil.doSwitchToFrame("menuAndView");
		// driver.switchTo().frame("hansenView");
		elementUtil.doSwitchToFrame("hansenView");

		elementUtil.doSendKeys(userId, "mnath");
		elementUtil.doSendKeys(password, "Password!0");
		elementUtil.doClick(signInBtn);

		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		Assert.assertTrue(elementUtil.isDisplayed(header));

		// navigate to building permit application
		// elementUtil.doSwitchToFrame("menuAndView");

		Thread.sleep(2000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(2000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(2000);
		// elementUtil.doClick(lookUpAppOpt);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		// elementUtil.doSwitchToFrame("_Task_Tab_Content0");
		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doSendKeys(appNumTextBox, "MECS2570");
		Thread.sleep(2000);
		elementUtil.doClick(searchBtn);
		Thread.sleep(2000);
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//		
//		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
//		elementUtil.doSwitchToFrame("viewTab");
		By searchRes = By.xpath("//div/a[text()='MECS2570']");
		Assert.assertTrue(elementUtil.isDisplayed(searchRes));
		Thread.sleep(2000);
		elementUtil.doClick(searchRes);
//		elementUtil.switchToParentFrame(); //To _Task_Tab_Content1 From viewTab
//		elementUtil.switchToParentFrame(); //To hansenView From _Task_Tab_Content1
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		Thread.sleep(2000);
		elementUtil.switchToFrameByWebElement(iframe);
		// elementUtil.doSwitchToFrame("_Task_Tab_Content14");
		Thread.sleep(2000);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		String milestone = elementUtil.doGetText(mileStone);
		System.out.println("MileStone is: " + milestone);

		Assert.assertEquals(milestone, Constants.MILESTONE_PRE_SCREEN_MSG);
		elementUtil.doClick(reviewsLnk);
		Thread.sleep(2000);
		elementUtil.doClick(reviewChkBox);
		// elementUtil.clickElementByJS(elementUtil.getElement(reviewChkBox));
		Thread.sleep(2000);
		// elementUtil.doClick(reviewNumLnk);
		elementUtil.doClick(recordResultsLnk);

		elementUtil.switchToParentFrame();
		elementUtil.switchToParentFrame();
		elementUtil.switchToFrameByWebElement(reviewRecordResultsFrame);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		// elementUtil.clickElementByJS(elementUtil.getElement(reviewResultsOpenBtn));

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

	@Test
	public void checkStatusFeePayment() throws InterruptedException {
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
		elementUtil.doSendKeys(appNumTextBox, "MECS2576");
		Thread.sleep(2000);
		elementUtil.doClick(searchBtn);
		Thread.sleep(2000);
		By searchRes = By.xpath("//div/a[text()='MECS2576']");
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
		System.out.println("MileStone is: " + milestone);

		Assert.assertEquals(milestone, Constants.MILESTONE_FEE_PAYMENT_AWAITNG_MSG);

	}

	By feesLnk = By.xpath("//li[@title='Fees']/a");
	By payFeesLnk = By.xpath("//div[contains(@id,'ActFeesPayFeesLink')]/a");
	By feePayFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgFeePayApplet')]");
	By addFeeBtn = By.xpath("//button[@id='gFeePayments_new']/span");
	By feeChck = By.xpath(
			"//fieldset[@id='gFeePayGrid']//div[contains(@id,'FeeStatus')]/preceding-sibling::div/following-sibling::div/span/div");
	By saveBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Save']");
	By payBtn = By.xpath("//button[@class='inforIconButton pay']");

	@Test(dependsOnMethods = "checkStatusFeePayment")
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
		System.out.println("MileStone is: " + milestone);

		Assert.assertEquals(milestone, Constants.MILESTONE_INSPECTION_MSG);
	}

	By myDashBoardLnk = By.xpath("//nav[@class='dynamic-menu dynamic-menu-header']//a//span[text()='My Dashboard']");
	By reqDate = By.xpath("//div[@class='datepicker-container']//input[@id='requestDate']");
	By reqTime = By.xpath("//div[@class='field request-time-container']//input[@id='time-preference']");
	By reqTimeDropdownBtn = By
			.xpath("//div[@class='field request-time-container']//button[@class='btn btn-icon droppy-toggle']");
	By reqTimeOption = By
			.xpath("//div[@class='field request-time-container']//ul[@class='droppy-list']/li[@data-val='NA']");

	@Test
	public void requestForInspectionRhythm() {

		String conNo = "MECS2570";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		elementUtil = new ElementUtil(driver);
		LoginPage_HouPer login = new LoginPage_HouPer(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://houstontx-tst.rhythmlabs.infor.com/home");
		// ItemLink_MECS2570
		login.doLoginHouPer("https://houstontx-tst.rhythmlabs.infor.com/", "m.nath@sierradigitalinc.com",
				"Sierra@2023");
		elementUtil.waitForElementToBeVisible(myDashBoardLnk, 30);
		// elementUtil.doClick(myDashBoardLnk);
		By perItem = By
				.xpath("//div[@class='paging-items-container']//div[@class='default-value-class']//a[@id='ItemLink_"
						+ conNo + "']");
		elementUtil.waitForElementToBeVisible(perItem, 30);
		elementUtil.doClick(perItem);
		// elementUtil.clickElementByJS(elementUtil.getElement(perItem));

		By reqInspBtn = By.xpath("//button[@id='InspectionResultRequestInspectionBtn_4029']");
		elementUtil.waitForElementToBeVisible(reqInspBtn, 30);
		// elementUtil.doClick(reqInspBtn);
		elementUtil.clickElementByJS(elementUtil.getElement(reqInspBtn));
		elementUtil.waitForElementToBeVisible(reqDate, 30);
		elementUtil.doSendKeys(reqDate, "07/07/2023");
		elementUtil.waitForElementToBeVisible(reqTime, 30);
		elementUtil.doClick(reqTime);
		// elementUtil.doClick(reqTimeDropdownBtn);
		elementUtil.waitForElementToBeVisible(reqTimeOption, 30);
		elementUtil.doClick(reqTimeOption);
	}

	By startApp = By.xpath("//li[@id='BldngPrmtsAplctnStrtAplctn']//a[text()='Start Application']");
	By appTyBtn = By.xpath(
			"//div[@id='APTypeEditBox_inputContainer']//input[@id='APTypeEditBox_input']/following-sibling::button");
	// div[@id='APTypeEditBox_inputContainer']//button[@class='inforTriggerButton
	// inforLookupButton']/span[text()='Open']
	// div[@id='APTypeEditBox_inputContainer']//input[@id='APTypeEditBox_input']/following-sibling::button
	By startAppIframe = By.xpath("//iframe[@title='Start Application (BPSA) ']");

	By stNoTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStNum_input')]");
	By preDirTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebPreDir_input')]");
	By stNameTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]");
	By stNameBtn = By.xpath(
			"//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button/span");
	// input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button/span
	// input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button
	By applicantsTab = By.xpath("//li[@id='tpgApplApplicants']/a");
	By capcityBtn = By.xpath("//div[contains(@id,'CapacityType_inputContainer')]/button");
	By capTyChckBox = By.xpath("//div[text()='Owner']/preceding-sibling::div/following-sibling::div/div");

	By applicantLastName = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebLastName_input')]");
	By applicantFirstName = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebFirstName_input')]");

	By lNameOpnBtn = By.xpath(
			"//div[contains(@id,'ebLastName_inputContainer')]//button[@class='inforTriggerButton inforLookupButton']/span");

	By contactTy = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebcontactType_input')]");
	By applicantMobile = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebMobile_input')]");
	By applicantAltPhNo = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebDayPhone_input')]");
	By address = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebAddressLine1_input')]");
	By email = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebemail_input')]");
	By city = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebCity_input')]");
	By state = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebState_input')]");
	By zip = By.xpath("//input[contains(@id,'ApplicantSwap_Content_ebZip_input')]");

	By jobDescTab = By.xpath("//li[@id='tpgApplJobDescription']/a[text()='Job Description']");
	By workTy = By.xpath("//input[contains(@id,'WorkTypeEditBox_input')]");
	By occupancyTy = By.xpath("//input[contains(@id,'OccupancyTypeEditBox_input')]");
	By apName = By.xpath("//input[contains(@id,'APNameEditBox_input')]");
	By descOfWork = By.xpath("//div[contains(@class,'inforRichTextEditor')]");

	By detailsTab = By.xpath("//li[@id='tpgApplDetails']/a");
	By sngTrDeclChkBox = By.xpath("//div//label[contains(text(),'I confirm that this application is for a single trade permit')]");
	By saveButton = By.xpath("//button[@id='btnSave']/span");
	By appNo = By.xpath("//div[@class='printContainer']//div[@id='ttTitle']/a");
	By appDetailLnk = By.xpath("//li[@tabid='tpgApplDetails']/a");
	//By hOwnerAffdLnk = By.xpath("//div[@id='uccTabPages']//div[@id='tpApplInfo']//div[contains(@tbt,'ApplicationDetails_tpApplInfo')]//div[@class='content']//div[@title='Homeowner Affidavit']/a");
	//By hOwnerAffdLnk = By.xpath("//*//div[@class='inforDataGrid inforDataGrid179946']//div[@id='inforDataGrid179946canvasTopL']//div[@title='Homeowner Affidavit']/a");
	//By hOwnerCntLnk = By.xpath("//div[@title='Homeowner Item Count']/a");
	By homeOwnerAffdChkBox = By.xpath("//a[text()='Homeowner Affidavit']/../preceding-sibling::div/following-sibling::div/div");
	By homeOwnerAffd = By.xpath("//a[text()='Homeowner Affidavit']/../preceding-sibling::div/following-sibling::div/div/../following-sibling::div/a[text()='Homeowner Affidavit']");
	
	By homeOwnerItemCntChkBox = By.xpath("//a[text()='Homeowner Item Count']/../preceding-sibling::div/following-sibling::div/div");
	By homeOnwerItemCnt = By.xpath("//a[text()='Homeowner Item Count']/../preceding-sibling::div/following-sibling::div/div/../following-sibling::div/a[text()='Homeowner Item Count']");
	
	By bldAppDetailInfoFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerDetailApplet')]");
	By hOwnerFN = By.xpath("//input[contains(@id,'ebFullName_input')]");
	By hOwnerInit1 = By.xpath("//input[contains(@id,'ebinitial1_input')]");
	By hOwnerInit2 = By.xpath("//input[contains(@id,'ebInitials2_input')]");
	By hOwnerInit3 = By.xpath("//input[contains(@id,'ebInitials3_input')]");
	By hOwnerInit4 = By.xpath("//input[contains(@id,'ebInitials4_input')]");
	By hOnwerPrintName = By.xpath("//input[contains(@id,'ebPrintname_input')]");
	By saveAndClose = By.xpath("//button[@id='btnSaveClose']/span");
	
	@Test
	public void applyMechPermitFromBackOffice() throws InterruptedException {

		String appType = "MECS";
		String streetName = "DREW";
		String email = "abc@gmail.com";
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

		Thread.sleep(1000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(1000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(1000);
		// elementUtil.doClick(lookUpAppOpt);
		elementUtil.clickElementByJS(elementUtil.getElement(startApp));
		Thread.sleep(1000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(1000);
		// elementUtil.waitForElementToBeVisible(appTyBtn, 30);
		elementUtil.doClick(appTyBtn);
		// elementUtil.clickElementByJS(elementUtil.getElement(appTyBtn));
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		By appTyChkBox = By.xpath("//div[text()='" + appType + "']/preceding-sibling::div/following-sibling::div/div");
		elementUtil.waitForElementToBeVisible(appTyChkBox, 20);
		elementUtil.doClick(appTyChkBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(1000);
		// elementUtil.waitForElementToBeVisible(stNoTxtBox, 30);
		elementUtil.doSendKeys(stNoTxtBox, "101");
		Thread.sleep(1000);
		elementUtil.doSendKeys(preDirTxtBox, "W");
		Thread.sleep(1000);
		elementUtil.doClick(preDirTxtBox);
		Thread.sleep(1000);
		elementUtil.doSendKeys(stNameTxtBox, streetName);
		Thread.sleep(1000);
		elementUtil.doClick(stNameTxtBox);
		Thread.sleep(1000);
		elementUtil.doClick(stNameBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		// elementUtil.switchToFrameByWebElement(By.xpath("//iframe[@data-auto-uid='Hansen.Property.AddressCustomPopup']"));
		By addChckBox = By.xpath("//div[text()='" + streetName
				+ "']/preceding-sibling::div/following-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");
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
		By searchContChkBox = By.xpath(
				"//div[text()='"+email+"']//preceding-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");

		elementUtil.doSendKeys(this.email, email);
		Thread.sleep(1000);
		elementUtil.doClick(lNameOpnBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		elementUtil.doClick(searchContChkBox);
		Thread.sleep(1000);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.waitForElementToBeVisible(jobDescTab, 30);
		elementUtil.doClick(jobDescTab);
		elementUtil.doSendKeys(workTy, "HVAC");
		elementUtil.doClick(workTy);
		elementUtil.doSendKeys(occupancyTy, "ResSng");
		elementUtil.doClick(occupancyTy);
		elementUtil.doSendKeys(apName, "Test Application");
		elementUtil.doSendKeys(descOfWork, "Test Application");
		Thread.sleep(2000);
		elementUtil.doClick(detailsTab);
		Thread.sleep(2000);
		elementUtil.doClick(sngTrDeclChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(saveButton);
		Thread.sleep(3000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.waitForElementToBeVisible(appNo, 30);
		String text = elementUtil.doGetText(appNo);
		System.out.println("Application Number: "+text);
		elementUtil.waitForElementToBeClickable(appNo, 30);
		elementUtil.doClick(appNo);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(iframe);
		elementUtil.doSwitchToFrame("viewTab");
		
		elementUtil.doClick(appDetailLnk);
		Thread.sleep(5000);
		Thread.sleep(2000);
		elementUtil.doClick(homeOwnerAffdChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(homeOwnerAffd);
	
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(bldAppDetailInfoFrame);
		elementUtil.doSwitchToFrame("viewTab");
		
		elementUtil.doSendKeys(hOwnerFN, "Dave Jhony");
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit1, "JD1");
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit2, "JD2");
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit3, "JD3");
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit4, "JD4");
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOnwerPrintName, "JD4");
		Thread.sleep(1000);
		elementUtil.doClick(saveAndClose);
		Thread.sleep(1000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(iframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(1000);
		elementUtil.doClick(homeOwnerItemCntChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(homeOnwerItemCnt);
		
		By HVACvaluation = By.xpath("//input[contains(@id,'AlterHVAC_input')]");
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(bldAppDetailInfoFrame);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.getElement(HVACvaluation).clear();
		elementUtil.doSendKeys(HVACvaluation, "2500");
		Thread.sleep(1000);
		elementUtil.doClick(saveAndClose);
	}

}
