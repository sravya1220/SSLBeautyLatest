package com.techouts.ssbweb.testscripts.CartPage;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.cartpageverifyapplycouponsample.model.CartPageVerifyApplyCouponSample;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBCartPageApplyCouponSampleAction;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBPDPVerifyDetailsAction;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.UserBackofficeLoginFunctionalityCheck;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageApplyCouponSampleTest extends AbstractTest   {

	private  SSBCartPageApplyCouponSampleAction ssbcartpageApplyCouponSample;

	private static final String TEST_CASE_NAME = "SSB_CartPage_Private_Verify_CartPage_ApplyCoupon_Functionality"; 
	private SSBLoginFunctionalityAction ssbLoginActions;
	private static final int SERIAL_NO = 2;
	private SSBPDPVerifyDetailsAction ssbpdpverifydetailsAction;

	public SSBCartPageApplyCouponSampleTest() {
		new SSBPDPVerifyDetails().init(DRIVER);
		new CartPageVerifyApplyCouponSample().init(DRIVER);
		new UserLoginFunctionalityCheck().init(DRIVER);
		new UserLoginFunctionalityCheck().init(DRIVER);
		new UserBackofficeLoginFunctionalityCheck().init(DRIVER);
		ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
		ssbcartpageApplyCouponSample = new SSBCartPageApplyCouponSampleAction(DRIVER, REPOSITORY);
		ssbpdpverifydetailsAction = new SSBPDPVerifyDetailsAction(DRIVER,REPOSITORY);

	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verfiying Apply Coupon Functionality")
	public void verifyCartPageDefaultFunctionalities() {
		try {

			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");
			ssbLoginActions.LoginFunctionalityClick(TEST_CASE_NAME, mobilelogin.getMobileno());
			//ssbLoginActions.openNewTab(TEST_CASE_NAME);
		//	getSslBackofficeUrl();
		//	User backofficelogin = Objects.requireNonNull(CredentialProvider.getUser("E010"),
		//			"Backoffice Login credential should not be null");
		//	ssbLoginActions.backofficeLoginFunctionality(TEST_CASE_NAME, backofficelogin.getEmail(), backofficelogin.getPassword());
		//	ssbLoginActions.backofficeMobileNumberVerication(TEST_CASE_NAME,mobilelogin.getMobileno(),0);
		//	WebElementOperationsWeb.handleParentTab(DRIVER ,0);
			ssbLoginActions.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
		//	ssbLoginActions.backofficeGetOtp(TEST_CASE_NAME);
		//	getSslDecryptUrl();
			ssbLoginActions.enterOtp(TEST_CASE_NAME,0);
			ssbLoginActions.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
			ssbpdpverifydetailsAction.NavigateToPDP(TEST_CASE_NAME, PDP_SHEET,SERIAL_NO);
			ssbcartpageApplyCouponSample.ClickonAddToCartProduct(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonAddToCartClick(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonApplyCouponIcon1(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.sendAndApplyCoupon(TEST_CASE_NAME, CARTPAGE_SHEET, SERIAL_NO);
			ssbcartpageApplyCouponSample.ClickonRemoveBtn(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.VerifyGetShoppingButton(TEST_CASE_NAME);

		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "ApplyCoupon");
			handleOnException("ClearAll Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}

