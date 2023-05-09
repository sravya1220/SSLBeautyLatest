package com.techouts.ssbweb.testscripts.PDP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.github.dockerjava.api.model.Repository;
import com.sslweb.automation.ssbpdpcheckdelivery.model.SSBPDPCheckDelivery;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPDPCheckDeliveryAction;
import com.sslweb.automation.test.page.actions.SSBPDPVerifyDetailsAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPVerifyDeliveryDetailsTest extends AbstractTest  {
	
	private SSBPDPCheckDeliveryAction ssbpdpdeliverydetailsAction;

	private static final String TEST_CASE_NAME = "SSB_PDP_CheckDelivery"; 
	private static final int SERIAL_NO = 2;
	private static final Logger LOG = Logger.getLogger(SSBPDPVerifyDeliveryDetailsTest.class.getName());

	public SSBPDPVerifyDeliveryDetailsTest() {
		new SSBPDPCheckDelivery().init(DRIVER);
		ssbpdpdeliverydetailsAction = new SSBPDPCheckDeliveryAction(DRIVER,REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
		WebElementOperationsWeb.captureScreenShotOnPass(DRIVER, TEST_CASE_NAME, "ShopperstopBeautyApplicationOpened");
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verify Delivery Details in PDP page", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyDeliveryDetails() {
		try {			
			ssbpdpdeliverydetailsAction.NavigateToPDP(TEST_CASE_NAME, PDP_SHEET,SERIAL_NO);
			ssbpdpdeliverydetailsAction.PDPVerifyDelivery(TEST_CASE_NAME, PDP_SHEET,SERIAL_NO);			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "VerifyProductDetails");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			addRetryTest(new Object() {}.getClass().getEnclosingMethod().getName());
			handleOnException("VerifyProductDetailsFailed", e);
		}
	}
	
	
}


