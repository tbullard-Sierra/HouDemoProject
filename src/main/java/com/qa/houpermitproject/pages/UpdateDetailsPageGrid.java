package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class UpdateDetailsPageGrid extends BasePage{
	
		
	WebDriver driver;
	ElementUtil elementUtil; 
	
	public UpdateDetailsPageGrid(WebDriver driver) {
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

	By mileStone = By.xpath("//div[@id='_ctl29_ttAppStatus2']//span");
	By iframe = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerApplet:')]");
	By reviewsLnk = By.xpath("//li[@id='_ctl33_Reviews_tpApplInfo']//a");
	By reviewChkBox = By.xpath("//div[@class='content']//div[contains(@aria-describedby,'checkbox-selector')]");
	By reviewNumLnk = By.xpath("//div[contains(@aria-describedby,'ReviewNo')]/a");
	By recordResultsLnk = By.xpath("//div[contains(@id,'ttRecordReviewResults')]/a");
	
	By appDetailLnk = By.xpath("//li[@tabid='tpgApplDetails']/a");
	//By additinalItemDetails = By.xpath("//a[text()='Additional Items Details']/../preceding-sibling::div/following-sibling::div/div/../following-sibling::div/a[text()='Additional Items Details']");
	//By additionalItemDetailsChkBox = By.xpath("//a[text()='Additional Items Details']/../preceding-sibling::div/following-sibling::div/div");
	By addApplicantsChkBox = By.xpath("//a[text()='Additional Applicants']/../preceding-sibling::div/following-sibling::div/div");
	By addApplicantsLnk = By.xpath("//a[text()='Additional Applicants']/../preceding-sibling::div/following-sibling::div/div/../following-sibling::div/a[text()='Additional Applicants']");
	By homeOwnerAffdChkBox = By.xpath("//a[text()='Homeowner Affidavit']/../preceding-sibling::div/following-sibling::div/div");
	By homeOwnerAffd = By.xpath("//a[text()='Homeowner Affidavit']/../preceding-sibling::div/following-sibling::div/div/../following-sibling::div/a[text()='Homeowner Affidavit']");
	By addApplicantsBtn = By.xpath("//button[contains(@id,'grdApplicants_new')]/span");
	By bldAppDetailInfoFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerDetailApplet')]");
	
	//By capacityField = By.xpath("//div[contains(@aria-describedby,'gcFirstName')]/preceding-sibling::div/following-sibling::div/following-sibling::div[@aria-describedby='tooltip']");
	By capacityField = By.xpath("//div[@class='ui-widget-content slick-row  active even  ']//div[@class='slick-cell l3 r3  canEdit active error']");
	By openBtn = By.xpath("//div[contains(@id,'Content_grdApplicants_gcCapacity_inputContainer')]/button/span");
	
	By selectBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Select']");
	By capcity = By.xpath("//input[contains(@id,'grdApplicants_gcCapacity_input')]");
	
	By firstNameField = By.xpath("//div[contains(@class,'slick-row  active even  ')]//div[contains(@aria-describedby,'gcFirstName')]");
	By fisrtName = By.xpath("//div[@class='ui-widget-content slick-row  even active']//input[contains(@id,'Content_grdApplicants_gcFirstName')]");
	
	By lastNameField = By.xpath("//div[@row='0' and @class='ui-widget-content slick-row  even active']//div[contains(@aria-describedby,'gcLastName')]");
	By lastName = By.xpath("//div[@class='ui-widget-content slick-row  even active']//input[contains(@id,'Content_grdApplicants_gcLastName_input')]");
	
	By emailAddressField = By.xpath("//div[@row='0' and @class='ui-widget-content slick-row  even active']//div[contains(@aria-describedby,'gcEmail')]");
	By emailAddress = By.xpath("//div[@class='ui-widget-content slick-row  even active']//input[contains(@id,'Content_grdApplicants_gcEmail_input')]");
	
	By phoneNoField = By.xpath("//div[@row='0' and @class='ui-widget-content slick-row  even active']//div[contains(@aria-describedby,'gcPhone')]");
	By phoneNo = By.xpath("//div[@class='ui-widget-content slick-row  even active']//input[contains(@id,'Content_grdApplicants_gcPhone_input')]");
	
	
	By createNewContactChkBox = By.xpath("//div[contains(@aria-describedby,'CreateContact')]/div");
	By createNewApplicantChkBox = By.xpath("//div[contains(@aria-describedby,'CreateApplicant')]/div");
	By approveBtn = By.xpath("//button[contains(@id,'Content_grdApplicants_approve')]/span");
	By saveBtn = By.xpath("//button[@id='btSaveOnNav']/span");
	By saveAndCloseBtn = By.xpath("//button[@id='btnSaveClose']");
	
	
	By chkBox = By.xpath("//div[contains(@aria-describedby,'gcFirstName')]/preceding-sibling::div/following-sibling::div/div");
	
	By emailText = By.xpath("(//fieldset//div[contains(@class,'ui-widget-content slick-row')])[last()]//div[contains(@aria-describedby,'gcEmail')]");
	@Test
	public String updateDetailspageGrid(String confNo,String capacityTy,String fName,String lName,
			String email,String phNo)  {
		
		String text = null;

		try {
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
		elementUtil.switchToFrameByWebElement(iframe);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doClick(appDetailLnk);
		Thread.sleep(2000);
		elementUtil.doClick(addApplicantsChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(addApplicantsLnk);
		Thread.sleep(2000);

		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(bldAppDetailInfoFrame);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doClick(addApplicantsBtn);
		Thread.sleep(2000);
		elementUtil.doClick(capacityField);
		Thread.sleep(2000);
		elementUtil.doClick(openBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(2000);
		By capacityTyChkBox = By.xpath("(//div[text()='"+capacityTy+"'])[1]/preceding-sibling::div/following-sibling::div/div");
		elementUtil.doClick(capacityTyChkBox);
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(bldAppDetailInfoFrame);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(3000);
		elementUtil.doClick(firstNameField);
		Thread.sleep(3000);
		elementUtil.doSendKeys(fisrtName, fName);
		Thread.sleep(2000);
		elementUtil.doClick(lastNameField);
		Thread.sleep(2000);
		elementUtil.doSendKeys(lastName, lName);
		Thread.sleep(2000);
		elementUtil.doClick(emailAddressField);
		Thread.sleep(2000);
		elementUtil.doSendKeys(emailAddress, email);
		Thread.sleep(2000);
		elementUtil.doClick(phoneNoField);
		Thread.sleep(2000);
		elementUtil.doSendKeys(phoneNo, phNo);
		//elementUtil.doClick(createNewContactChkBox);
		Thread.sleep(2000);
		//elementUtil.doClick(createNewApplicantChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(approveBtn);
		Thread.sleep(5000);
		elementUtil.doClick(saveBtn);
		Thread.sleep(5000);
		elementUtil.doClick(saveAndCloseBtn);
		
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(iframe);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.doClick(appDetailLnk);
		Thread.sleep(2000);
		elementUtil.doClick(addApplicantsChkBox);
		Thread.sleep(2000);
		elementUtil.doClick(addApplicantsLnk);
		Thread.sleep(2000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(bldAppDetailInfoFrame);
		elementUtil.doSwitchToFrame("viewTab");
		By emailtxt = By.xpath("(//fieldset//div[contains(@class,'ui-widget-content slick-row')])[last()]//div[text()='"+email+"']");
		elementUtil.doClick(emailtxt);
		Thread.sleep(2000);
		text = elementUtil.doGetText(emailtxt);
		System.out.println("Applicant Email is: "+text);
		
		}catch(Exception e) {
			
		}
		
		return text;
		
	}

}
