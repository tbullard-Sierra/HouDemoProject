package com.qa.houpermitproject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.houpermitproject.base.BaseTest;
import com.qa.houpermitproject.constants.Constants;
/**
 * This test is to approve Mechanical permit and check the milestone after approved.
 * @author MahendraNath
 *
 */
public class FeeMilestoneStatusCheckTest extends BaseTest{
	
	
	@Test(enabled = true)
	public void payFeeMileStoneStatusTest() {
		String confNum = "MECS2607";
		SoftAssert softAssert = new SoftAssert();
		
		String headerIPShomePage = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(), prop.getProperty("ipsUsername").trim(),
				prop.getProperty("ipsPassword").trim());
		System.out.println("IPS home page header: "+headerIPShomePage);
		softAssert.assertEquals(headerIPShomePage, Constants.IPS_HOME_PAGE_HEADER);
		
		String preScreenMileStoneMsg = backOffice.preScreenStatus(confNum);
		System.out.println("PreScreen milestone: "+preScreenMileStoneMsg);
		softAssert.assertEquals(preScreenMileStoneMsg, Constants.MILESTONE_PRE_SCREEN_MSG);
		
		String payFeeMileStoneMsg = backOffice.approvePermitAndSatusAwaitingFeePayment();
		System.out.println("Pay fees milestone message: "+payFeeMileStoneMsg);
		softAssert.assertEquals(payFeeMileStoneMsg, Constants.MILESTONE_FEE_PAYMENT_AWAITNG_MSG);
		
		softAssert.assertAll();
		
	}
	
	@Test (enabled = false)
	public void checkAwaitingFeePayMilestoneTest() {
		
		SoftAssert softAssert = new SoftAssert();
		
		String headerIPShomePage = ipsLogin.loginToBackOffice(prop.getProperty("IPSurl").trim(), prop.getProperty("ipsUsername").trim(),
				prop.getProperty("ipsPassword").trim());
		System.out.println("IPS home page header: "+headerIPShomePage);
		softAssert.assertEquals(headerIPShomePage, Constants.IPS_HOME_PAGE_HEADER);
		
		
		String msg = backOffice.checkStatusAwaitingFeePayment("MECS2606");
		System.out.println(msg);
		softAssert.assertEquals(msg, Constants.MILESTONE_FEE_PAYMENT_AWAITNG_MSG);
	}

}
