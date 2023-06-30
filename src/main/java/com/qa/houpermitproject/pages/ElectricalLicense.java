package com.qa.houpermitproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.houpermitproject.base.BasePage;
import com.qa.houpermitproject.utils.ElementUtil;

public class ElectricalLicense extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	public ElectricalLicense(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	By applyLink = By.xpath("(//a/span[text()='Register/Apply Now'])[1]");
	By licAndReg = By.xpath("//div//p[text()='Licenses and Registrations']");

	By elecMaster = By.xpath("//div//p[text()='Electrical Master / Contractor Registrations']");
	By liceCatList = By.xpath("//div[@class='droppy license-category searchable']//ul[@class='droppy-list ']/li");

	By licenceCato = By.xpath("//input[@id='license-category']");

	By licenceCatoClick = By.xpath("//input[@name='LicenseCategory']");
	By stateLicence = By.xpath("//input[@name='StateLicenseNumber']");
	By stateIssuedBy = By.xpath("//input[@name='StateIssuedBy']");
	By stateExpDate = By.xpath("//input[@name='StateExpireDate']");
	By driversLicense = By.xpath("//input[@name='DriversLicense']");
	By companyName = By.xpath("//input[@name='CompanyName']");
	By companyAddress = By.xpath("//textarea[@name='CompanyAddrress']");
	By companyPhone = By.xpath("//input[@name='CompanyPhone']");
	By insurancePolicyNo = By.xpath("//input[@name='InsurancePolicyNum']");
	By insuranceCompany = By.xpath("//input[@name='InsuranceCompany']");
	By insuranceExpDate = By.xpath("//input[@name='InsuranceExpireDate']");
	By addRow = By.id("detailPageGrid-addRowBtn-desktop");
	By contractorStateLicence = By
			.xpath("//div[@class='bbm-modal bbm-modal--open']//input[@name='StateLicenseNumber']");
	By saveRowBtn = By.xpath("//div[@class='bbm-modal bbm-modal--open']//button[text()='Save Row']");
	By saveAndContinueBtn = By.xpath("//button[text()='Save & Continue']");
	By submitBtn = By.xpath("//button[text()='Submit']");
	By finalSubmitBtn = By.xpath("//div[@id='Modal_Confirmation']//button[text()='Submit']");
	By backBtn = By.xpath("//div[@id='Modal_Confirmation']//button[text()='Back']");

	By confNumber = By.xpath("//div[@class='submit-instrument']//a[@id='InstrumentDetailLink']");

	public String createElectricPermit(String licenCat, String stateLincense, String issuedBy, String stExpDate,
			String driverLicNo, String compName, String CompAdd, String compPhNo, String InsPolNo, String insCompName,
			String insExpDate, String contStateLicense) throws InterruptedException {

		elementUtil.clickElementByJS(elementUtil.getElement(applyLink));
		Thread.sleep(1000);
		elementUtil.clickElementByJS(elementUtil.getElement(licAndReg));
		Thread.sleep(1000);
		elementUtil.clickElementByJS(elementUtil.getElement(elecMaster));
		Thread.sleep(1000);
		elementUtil.doClick(licenceCato);
		Thread.sleep(1000);
		By item = By.xpath("//ul[@class='droppy-list openUp']//li/span[text()='" + licenCat + "']");
		elementUtil.clickElementByJS(elementUtil.getElement(item));
		Thread.sleep(1000);
		elementUtil.doSendKeys(stateLicence, stateLincense);
		elementUtil.doSendKeys(stateIssuedBy, issuedBy);
		elementUtil.doSendKeys(stateExpDate, stExpDate);
		elementUtil.doSendKeys(driversLicense, driverLicNo);
		elementUtil.doSendKeys(companyName, compName);
		elementUtil.doSendKeys(companyAddress, CompAdd);
		elementUtil.doSendKeys(companyPhone, compPhNo);
		elementUtil.doSendKeys(insurancePolicyNo, InsPolNo);
		elementUtil.doSendKeys(insuranceCompany, insCompName);
		elementUtil.doSendKeys(insuranceExpDate, insExpDate);
		elementUtil.clickElementByJS(elementUtil.getElement(addRow));
		elementUtil.doSendKeys(contractorStateLicence, contStateLicense);
		elementUtil.doClick(saveRowBtn);
		//elementUtil.scrollPageDown();
		//elementUtil.scrollIntoView(elementUtil.getElement(stateIssuedBy));
		elementUtil.clickElementByJS(elementUtil.getElement(saveAndContinueBtn));
		Thread.sleep(3000);
		//elementUtil.doClick(saveAndContinueBtn);
		//Thread.sleep(3000);
		//elementUtil.doClick(saveAndContinueBtn);
		elementUtil.clickElementByJS(elementUtil.getElement(saveAndContinueBtn));
		Thread.sleep(3000);
		//elementUtil.waitForElementToBeClickable(submitBtn, 30);
		elementUtil.clickElementByJS(elementUtil.getElement(submitBtn));
		Thread.sleep(3000);
		elementUtil.doClick(finalSubmitBtn);
		Thread.sleep(3000);
		String confNum = elementUtil.doGetText(confNumber);

		return confNum;
	}

}
