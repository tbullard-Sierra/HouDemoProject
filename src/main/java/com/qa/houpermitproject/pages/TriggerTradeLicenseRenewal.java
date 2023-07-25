package com.qa.houpermitproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.AppUtil;
import com.qa.houpermitproject.utils.ElementUtil;


public class TriggerTradeLicenseRenewal extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil ;
	AppUtil appUtil;
	
	public TriggerTradeLicenseRenewal(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		appUtil = new AppUtil(driver);
		this.driver = driver;
	}
	
	By userId = By.xpath("//input[@id='userId']");
	By password = By.xpath("//input[@id='password']");
	By signInBtn = By.xpath("//button[text()='Sign In']");
	By header = By.xpath("//div[@id='moduleHeaderContainer']//a[text()='My Infor']");
	
	By tradeLicenseMenu = By.xpath("//div[@class='inforApplicationNav']/ul/li/a[text()='Trade License']");
	By licenseOption = By.xpath("//li[@id='TrdLcns']//ul//li/a[text()='License']");
	By lookUpAppOpt = By.xpath("//li[@id='TrdLcnsLcnsLkpLcns']//a[text()='Lookup Licenses']");
	
	By licenseTxtBox = By.xpath("//label[text()='License #']//following-sibling::input");
	By searchBtn = By.xpath("//button[@id='_ctl0_btn_Search']");
	
	By licenseChkBox = By.xpath("//div/a[text()='TACLB5599E']/../preceding-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");
	By lookupLicenseFrame = By.xpath("//iframe[@title='Lookup Licenses (TLL) ']");
	
	//By expireCheckBox = By.xpath("//div[text()='Expire']/preceding-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");
	By selectBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Select']");
	By saveBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Save']");
	
	
	By tradeLicenseInfoViewerFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.TradeLicense.TradeLicenseViewerApplet')]");
	By mileStone = By.xpath("//div[contains(@id,'ttAppStatus2')]//span");
	By logsLnk = By.xpath("//li[contains(@id,'_Logs_tpApplInfo')]//a");
	By addLogBtn = By.xpath("//button[contains(@id,'gEventLog_new')]/span");
	By logTypeBtn = By.xpath("//div[@id='ebLogType_inputContainer']//button/span");
	By logStartDate = By.xpath("//div[@id='ebLogFromDate_timeContainer']/input[@id='ebLogFromDate_input']");
	By logStartTime = By.xpath("//div[@id='ebLogFromDate_timeContainer']/input[@id='ebLogFromDate_time']");
	By logToDate = By.xpath("//div[@id='ebLogToDate_timeContainer']/input[@id='ebLogToDate_input']");
	By logToTime = By.xpath("//div[@id='ebLogToDate_timeContainer']/input[@id='ebLogToDate_time']");
	By logStartedBy = By.xpath("//div[@id='ebStartedBy_inputContainer']/input");
	
	By licenseDescLnk = By.xpath("//li[contains(@id,'LicenseDescription_tpApplInfo')]/a");
	By nextRenewalTxtBox = By.xpath("//div[contains(@id,'ebNextRenewal_timeContainer')]/input[contains(@id,'ebNextRenewal_input')]");
	By expiresTxtBox = By.xpath("//div[contains(@id,'ebExpireDttm_timeContainer')]/input[contains(@id,'ebExpireDttm_input')]");
	
	By licenseDetailsLnk = By.xpath("//li[contains(@id,'LicenseDetails_tpApplInfo')]//a");
	By licenseDetailPageLnk = By.xpath("//div[contains(@aria-describedby,'Description')]/a[text()='License Information Detail Page']");
	
	
	List<String> msg = new ArrayList<String>();
	
	
	public List<String> triggerTLRenewal(String licenseNo,String logType,String startDt,String stopDt,
			String startedBy) {
		
		String mileSt = null;
		String mileSt1 = null;
		String nextRnwDt = null;
		String expDt = null;
		try {
		elementUtil.doClick(tradeLicenseMenu);
		Thread.sleep(1000);
		elementUtil.doClick(licenseOption);
		Thread.sleep(1000);
		elementUtil.clickElementByJS(elementUtil.getElement(lookUpAppOpt));
		Thread.sleep(1000);
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//		elementUtil.doSwitchToFrame("_Task_Tab_Content1");
//		elementUtil.doSwitchToFrame("viewTab");
		appUtil.switchToLookUpLicensesFrame();
		elementUtil.doSendKeys(licenseTxtBox, licenseNo);
		elementUtil.doClick(searchBtn);
		By licenseLnk = By.xpath("//div/a[text()='"+licenseNo+"']");
		Thread.sleep(1000);
		elementUtil.doClick(licenseLnk);
		Thread.sleep(1000);
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//		Thread.sleep(1000);
//		elementUtil.switchToFrameByWebElement(tradeLicenseInfoViewerFrame);
//		Thread.sleep(1000);
//		elementUtil.doSwitchToFrame("viewTab");
		appUtil.switchToTradeLicenseInfoViewerFrame();
		Thread.sleep(1000);
		mileSt= elementUtil.doGetText(mileStone);
		//System.out.println("Milestone is: "+mileSt);
		elementUtil.doClick(logsLnk);
		Thread.sleep(1000);
		elementUtil.doClick(addLogBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		//Thread.sleep(2000);
		elementUtil.doClick(logTypeBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__1");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		By expireCheckBox = By.xpath("//div[text()='"+logType+"']/preceding-sibling::div[contains(@aria-describedby,'checkbox-selector')]/div");
		elementUtil.doClick(expireCheckBox);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(1000);
		elementUtil.doClick(logStartDate);
		Thread.sleep(2000);
		//elementUtil.doClear(logStartDate);
		//Thread.sleep(2000);
		elementUtil.doSendKeys(logStartDate, startDt);
		Thread.sleep(2000);
		//elementUtil.doSendKeys(logStartTime, "10:10");
		Thread.sleep(2000);
		elementUtil.doClick(logToDate);
		Thread.sleep(1000);
		elementUtil.doSendKeys(logToDate, stopDt);
		Thread.sleep(2000);
		//elementUtil.doSendKeys(logToTime, "10:10");
		Thread.sleep(1000);
		elementUtil.doSendKeys(logStartedBy, startedBy);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(saveBtn);
//		elementUtil.switchToDefaultContent();
//		elementUtil.doSwitchToFrame("menuAndView");
//		elementUtil.doSwitchToFrame("hansenView");
//		Thread.sleep(1000);
//		elementUtil.switchToFrameByWebElement(tradeLicenseInfoViewerFrame);
//		Thread.sleep(1000);
//		elementUtil.doSwitchToFrame("viewTab");
		appUtil.switchToTradeLicenseInfoViewerFrame();
		Thread.sleep(2000);
		mileSt1= elementUtil.doGetText(mileStone);
		//System.out.println("Milestone is: "+mileSt1);
		elementUtil.doClick(licenseDescLnk);
		nextRnwDt = elementUtil.getTextByJS(elementUtil.getElement(nextRenewalTxtBox));
		//System.out.println("Next Renewal Date is: "+nextRnwDt);
		expDt = elementUtil.getTextByJS(elementUtil.getElement(expiresTxtBox));
		//System.out.println("Expiry Date is: "+expDt);
		
		msg.add(mileSt);
		msg.add(mileSt1);
		msg.add(nextRnwDt);
		msg.add(expDt);
		
		}catch(Exception e) {
			
		}
		
		return msg;
		
	}
	
	By resoucesLnk = By.xpath("//li[@id='Rsrcs']/a");
	By codeDefMgmtLnk = By.xpath("//li[@class='activeHeader']//li[@id='RsrcsCdDfntnMngmntCdDfntnMngmnt']/a");
	By agencyIntegrationLnk = By.xpath("//li[@qaid='Root_EnhancementCodeTables_AgencyIntegration__header']/ins/span");
	By tdlrLnk = By.xpath("//li[@qaid='Root_EnhancementCodeTables_AgencyIntegration_TDLR__header']/ins/span");
	By licenseLnk = By.xpath("//li[@qaid='Root_EnhancementCodeTables_AgencyIntegration_TDLR_License__header']/a");
	By codeDefMgmtIframe = By.xpath("//iframe[@title='Code Definition Management (RCDM) ']");
	By licNoTxtBox = By.xpath("//div//label[text()='LicenseNumber']/following-sibling::input");
	By searchBtnCDMR = By.xpath("//button[@id='btnSearch']/span");
	By editBtn = By.xpath("//button[@id='sGrid_editMode']/span");
	By expireInputBox = By.xpath("//div[@id='sGrid_License_ExpiryDate_inputContainer']/input");
	By chckBox = By.xpath("//div[contains(@aria-describedby,'checkbox-selector')]/div");
	By approveBtn = By.xpath("//button[@id='sGrid_approve']/span");
	
	
	public String expirepermit(String licenseNum,String expDate) {
		
		String modExpDate = null;
		try {
			
				elementUtil.doClick(resoucesLnk);
				elementUtil.doClick(codeDefMgmtLnk);
				appUtil.switchToCodeDefMgmtFrame();
//				elementUtil.switchToDefaultContent();
//				elementUtil.doSwitchToFrame("menuAndView");
//				elementUtil.doSwitchToFrame("hansenView");
//				elementUtil.switchToFrameByWebElement(codeDefMgmtIframe);
//				elementUtil.doSwitchToFrame("viewTab");
				elementUtil.doClick(agencyIntegrationLnk);
				elementUtil.doClick(tdlrLnk);
				elementUtil.doClick(licenseLnk);
				elementUtil.doSendKeys(licNoTxtBox, licenseNum);
				elementUtil.doClick(searchBtnCDMR);
				driver.findElement(editBtn).click();
				elementUtil.doClick(editBtn);
				Thread.sleep(2000);
				By expInputBox = By.xpath("(//div[text()='"+licenseNum+"']/following-sibling::div)[4]");
				elementUtil.doClick(expInputBox);
				elementUtil.clickElementByJS(elementUtil.getElement(expireInputBox));
				elementUtil.doSendKeys(expireInputBox, expDate);
				driver.findElement(chckBox).click();
				elementUtil.doClick(chckBox);
				Thread.sleep(2000);
				elementUtil.doClick(approveBtn);
				Thread.sleep(3000);
				modExpDate = elementUtil.doGetText(expInputBox);
			
		}catch(Exception e) {
			
		}
		
		return modExpDate;
	}
		
	


}
	


