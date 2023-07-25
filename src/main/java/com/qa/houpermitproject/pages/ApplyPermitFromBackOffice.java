package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class ApplyPermitFromBackOffice extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public ApplyPermitFromBackOffice(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	By selectBtn = By.xpath("//div[@class='modal-buttonset']/button[text()='Select']");
	By iframe = By.xpath("//iframe[contains(@data-auto-applet-id,'Hansen.CDR.Building.BldgApplicationViewerApplet:')]");
	By buildingPerMenu = By.xpath("//div[@class='inforApplicationNav']/ul/li/a[text()='Building Permits']");
	By applicationOption = By.xpath("//li[@id='BldngPrmts']//ul//li/a[text()='Application']");
	By startApp = By.xpath("//li[@id='BldngPrmtsAplctnStrtAplctn']//a[text()='Start Application']");
	By appTyBtn = By.xpath(
			"//div[@id='APTypeEditBox_inputContainer']//input[@id='APTypeEditBox_input']/following-sibling::button");
	By startAppIframe = By.xpath("//iframe[@title='Start Application (BPSA) ']");

	By stNoTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStNum_input')]");
	By preDirTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebPreDir_input')]");
	By stNameTxtBox = By.xpath("//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]");
	By stNameBtn = By.xpath(
			"//input[contains(@id,'BldgApplicationAddress_Content_StreetebStName_input')]/following-sibling::button/span");
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
	By HVACvaluation = By.xpath("//input[contains(@id,'AlterHVAC_input')]");
	@Test
	public String applyMechPermitFromBackOffice(String appTy,String strNo,String preDir,String streetName,String email,
			String wrkTy, String occupTy,String applName, String descOfWrk,String fullName,String init1,String init2
			,String init3,String init4,String printName,String HAVCvaluation) {
		
		String applicationNum = null;
		try {
		Thread.sleep(3000);
		elementUtil.doClick(buildingPerMenu);
		Thread.sleep(3000);
		elementUtil.doClick(applicationOption);
		Thread.sleep(3000);
		elementUtil.clickElementByJS(elementUtil.getElement(startApp));
		Thread.sleep(3000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(3000);
		
		By applTy = By.xpath("//input[@id='APTypeEditBox_input']");
		elementUtil.doSendKeys(applTy, appTy);
		
		elementUtil.doClick(appTyBtn);
		Thread.sleep(3000);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("__modalFrame__0");
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(3000);
		By appTyChkBox = By.xpath("//div[text()='"+appTy+"']/preceding-sibling::div/following-sibling::div/div");
		//elementUtil.waitForElementToBeVisible(appTyChkBox, 20);
		//elementUtil.doClick(appTyChkBox);
		elementUtil.clickElementByJS(elementUtil.getElement(appTyChkBox));
//		By applTy = By.xpath("//input[@id='APTypeEditBox_input']");
//		elementUtil.doSendKeys(applTy, "MECS");
//		elementUtil.doClick(applTy);
		Thread.sleep(3000);
		elementUtil.switchToDefaultContent();
		elementUtil.doClick(selectBtn);
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(startAppIframe);
		elementUtil.doSwitchToFrame("viewTab");
		Thread.sleep(1000);
		elementUtil.doSendKeys(stNoTxtBox, strNo);
		Thread.sleep(1000);
		elementUtil.doSendKeys(preDirTxtBox, preDir);
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
		Thread.sleep(2000);
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
		elementUtil.doSendKeys(workTy, wrkTy);
		elementUtil.doClick(workTy);
		elementUtil.doSendKeys(occupancyTy, occupTy);
		elementUtil.doClick(occupancyTy);
		elementUtil.doSendKeys(apName, applName);
		elementUtil.doSendKeys(descOfWork, descOfWrk);
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
		//elementUtil.waitForElementToBeVisible(appNo, 30);
		Thread.sleep(3000);
		applicationNum = elementUtil.doGetText(appNo);
		System.out.println("Application Number: "+applicationNum);
		//elementUtil.waitForElementToBeClickable(appNo, 30);
		Thread.sleep(3000);
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
		
		elementUtil.doSendKeys(hOwnerFN, fullName);
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit1, init1);
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit2, init2);
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit3, init3);
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOwnerInit4, init4);
		Thread.sleep(1000);
		elementUtil.doSendKeys(hOnwerPrintName, printName);
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
		elementUtil.switchToDefaultContent();
		elementUtil.doSwitchToFrame("menuAndView");
		elementUtil.doSwitchToFrame("hansenView");
		elementUtil.switchToFrameByWebElement(bldAppDetailInfoFrame);
		elementUtil.doSwitchToFrame("viewTab");
		elementUtil.getElement(HVACvaluation).clear();
		elementUtil.doSendKeys(HVACvaluation, HAVCvaluation);
		Thread.sleep(1000);
		elementUtil.doClick(saveAndClose);
		}catch(Exception e) {
			
		}
		
		return applicationNum;
	}


}
