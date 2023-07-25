package com.qa.houpermitproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author MahendraNath
 *
 */
public class AppUtil {

	
	WebDriver driver;
	
	
	public AppUtil(WebDriver driver) {
		this.driver =driver;
		
	}
	
	By codDefMgmtIframe = By.xpath("//iframe[@title='Code Definition Management (RCDM) ']");
	By bldAppInfoViewFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerApplet:')]");
	By reviewRecordResultsFrame = By
			.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgReviewRecordResultApplet:')]");
	By payFeePaymentFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgFeePayApplet')]");
	By startAppIframe = By.xpath("//iframe[@title='Start Application (BPSA) ']");
	By bldAppDetailInfoFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerDetailApplet')]");
	By tradeLicenseInfoViewerFrame = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.TradeLicense.TradeLicenseViewerApplet')]");
	
	public void switchToTradeLicenseInfoViewerFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(tradeLicenseInfoViewerFrame));
		driver.switchTo().frame("viewTab");
	}
	
	public void switchToLookUpLicensesFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame("_Task_Tab_Content1");
		driver.switchTo().frame("viewTab");
	}
	public void switchToCodeDefMgmtFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(codDefMgmtIframe));
		driver.switchTo().frame("viewTab");
	}
	
	public void switchToLookUpAppsFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame("_Task_Tab_Content1");
		driver.switchTo().frame("viewTab");
	}
	
	public void switchToBldAppInfoVieweFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(bldAppInfoViewFrame));
		driver.switchTo().frame("viewTab");
	}
	
	public void switchToBldReviewRecordResultsFrame() {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(reviewRecordResultsFrame));
		driver.switchTo().frame("viewTab");
	}
	
	public void switchPayFeePaymentFrame() {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(payFeePaymentFrame));
		driver.switchTo().frame("viewTab");	
	}
	
	public void switchToStartAppFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(startAppIframe));
		driver.switchTo().frame("viewTab");	
	}
	
	public void swithToBldAppDetailInfoViewer() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menuAndView");
		driver.switchTo().frame("hansenView");
		driver.switchTo().frame(driver.findElement(bldAppDetailInfoFrame));
		driver.switchTo().frame("viewTab");	
	}
	
	
	
	
	
	
	
}
