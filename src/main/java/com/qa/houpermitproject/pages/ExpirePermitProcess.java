package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;


/*
 * We Can delete this class. Method copied into TriggerTradeLicenseReewl Page class
 */
public class ExpirePermitProcess extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	public ExpirePermitProcess(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver =driver;
				
	}

	By userId = By.xpath("//input[@id='userId']");
	By password = By.xpath("//input[@id='password']");
	By signInBtn = By.xpath("//button[text()='Sign In']");
	By header = By.xpath("//div[@id='moduleHeaderContainer']//a[text()='My Infor']");
	
	By resoucesLnk = By.xpath("//li[@id='Rsrcs']/a");
	By codeDefMgmtLnk = By.xpath("//li[@class='activeHeader']//li[@id='RsrcsCdDfntnMngmntCdDfntnMngmnt']/a");
	By agencyIntegrationLnk = By.xpath("//li[@qaid='Root_EnhancementCodeTables_AgencyIntegration__header']/ins/span");
	By tdlrLnk = By.xpath("//li[@qaid='Root_EnhancementCodeTables_AgencyIntegration_TDLR__header']/ins/span");
	By licenseLnk = By.xpath("//li[@qaid='Root_EnhancementCodeTables_AgencyIntegration_TDLR_License__header']/a");
	By codeDefMgmtIframe = By.xpath("//iframe[@title='Code Definition Management (RCDM) ']");
	By licNoTxtBox = By.xpath("//div//label[text()='LicenseNumber']/following-sibling::input");
	By searchBtn = By.xpath("//button[@id='btnSearch']/span");
	By editBtn = By.xpath("//button[@id='sGrid_editMode']/span");
	By expireInputBox = By.xpath("//div[@id='sGrid_License_ExpiryDate_inputContainer']/input");
	By chckBox = By.xpath("//div[contains(@aria-describedby,'checkbox-selector')]/div");
	By approveBtn = By.xpath("//button[@id='sGrid_approve']/span");
	
	
	public void expirepermit(String licenseNum,String expDate) {
		
		//String headerText = null;
		try {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			//elementUtil = new ElementUtil(driver);
				
					
//				
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//				driver.manage().deleteAllCookies();
//				driver.get("https://cohipsuat.houstontx.gov/IPS_4_UAT/");
//				driver.switchTo().frame("menuAndView");
//				driver.switchTo().frame("hansenView");
//				driver.findElement(userId).sendKeys("mnath");
//				driver.findElement(password).sendKeys("Password!0");
//				driver.findElement(signInBtn).click();
//				
//				driver.switchTo().defaultContent();
//				driver.switchTo().frame("menuAndView");
//				headerText =driver.findElement(header).getText();
//				//elementUtil.launchURL("https://cohipsuat.houstontx.gov/IPS_4_UAT/");
//				//elementUtil.doSwitchToFrame("menuAndView");
//				//elementUtil.doSwitchToFrame("hansenView");
////				elementUtil.doSendKeys(userId, "mnath");
////				elementUtil.doSendKeys(this.password, "Password!0");
//				//elementUtil.doClick(signInBtn);
////				elementUtil.switchToDefaultContent();
////				elementUtil.doSwitchToFrame("menuAndView");
//				Thread.sleep(2000);
//				//headerText = elementUtil.doGetText(header);
//				System.out.println("Header Text is: "+headerText);
//		
//				Thread.sleep(2000);
			
				
				
				
				
				//driver.findElement(resoucesLnk).click();
				elementUtil.doClick(resoucesLnk);
				//driver.findElement(codeDefMgmtLnk).click();
				elementUtil.doClick(codeDefMgmtLnk);
				//AppUtil.switchToCodeDefMgmtFrame();
				
				//driver.switchTo().defaultContent();
				elementUtil.switchToDefaultContent();
				//driver.switchTo().frame("menuAndView");
				elementUtil.doSwitchToFrame("menuAndView");
				elementUtil.doSwitchToFrame("hansenView");
				//driver.switchTo().frame("hansenView");
				elementUtil.switchToFrameByWebElement(codeDefMgmtIframe);
				//driver.switchTo().frame(driver.findElement(codeDefMgmtIframe));
				elementUtil.doSwitchToFrame("viewTab");
				//driver.switchTo().frame("viewTab");
				
				//driver.findElement(agencyIntegrationLnk).click();
				elementUtil.doClick(agencyIntegrationLnk);
				//driver.findElement(tdlrLnk).click();
				elementUtil.doClick(tdlrLnk);
				//driver.findElement(licenseLnk).click();
				elementUtil.doClick(licenseLnk);
				//driver.findElement(licNoTxtBox).sendKeys("TACLB5599E");
				elementUtil.doSendKeys(licNoTxtBox, licenseNum);
				driver.findElement(searchBtn).click();
				elementUtil.doClick(searchBtn);
				driver.findElement(editBtn).click();
				elementUtil.doClick(editBtn);
				Thread.sleep(2000);
				By expInputBox = By.xpath("(//div[text()='"+licenseNum+"']/following-sibling::div)[4]");
				//driver.findElement(By.xpath("(//div[text()='TACLB5599E']/following-sibling::div)[4]")).click();
				elementUtil.doClick(expInputBox);
//				JavascriptExecutor js = ((JavascriptExecutor) driver);
//				js.executeScript("arguments[0].click();", driver.findElement(expireInputBox));
				elementUtil.clickElementByJS(elementUtil.getElement(expireInputBox));
				//driver.findElement(expireInputBox).sendKeys("7/21/2023");
				elementUtil.doSendKeys(expireInputBox, expDate);
				driver.findElement(chckBox).click();
				elementUtil.doClick(chckBox);
				Thread.sleep(2000);
				//driver.findElement(approveBtn).click();
				elementUtil.doClick(approveBtn);
			
		}catch(Exception e) {
			
		}
	}
}
