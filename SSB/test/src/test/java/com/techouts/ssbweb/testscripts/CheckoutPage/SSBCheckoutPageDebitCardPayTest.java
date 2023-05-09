package com.techouts.ssbweb.testscripts.CheckoutPage;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
//import com.sslweb.automation.checkoutpageusingcreditcard.model.CheckoutPageUsingCreditCard;
import com.sslweb.automation.checkoutpageusingdebitcard.model.CheckoutPageUsingDebitCard;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageDebitCardPayAction;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBPDPVerifyDetailsAction;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.UserBackofficeLoginFunctionalityCheck;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageDebitCardPayTest extends AbstractTest {

	private SSBCheckoutPageDebitCardPayAction ssbcheckoutpagedebitcardpay;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingDBCard";
	private static final int SERIAL_NO = 1;
	private SSBLoginFunctionalityAction ssbLoginActions;
	private SSBPDPVerifyDetailsAction ssbpdpverifydetailsAction;
	
	public SSBCheckoutPageDebitCardPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new CheckoutPageUsingDebitCard().init(DRIVER);
		new SSBPDPVerifyDetails().init(DRIVER);
		new UserLoginFunctionalityCheck().init(DRIVER);
		new UserBackofficeLoginFunctionalityCheck().init(DRIVER);
		ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
		ssbpdpverifydetailsAction = new SSBPDPVerifyDetailsAction(DRIVER,REPOSITORY);
		ssbcheckoutpagedebitcardpay = new SSBCheckoutPageDebitCardPayAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page CreditCard Functionalities check")
	public void verifyCreditcardpayatcheckout() {
		try {
			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");
			ssbLoginActions.LoginFunctionalityClick(TEST_CASE_NAME, mobilelogin.getMobileno());
		//	ssbLoginActions.openNewTab(TEST_CASE_NAME);
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
			ssbcheckoutpagedebitcardpay.AddToCartFunctionality(TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpay.EnteringDebitCardDetails(CHECKOUT_PAGE, TEST_CASE_NAME, SERIAL_NO);
			ssbcheckoutpagedebitcardpay.removeProduct(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Debit Card Default Functionality");
			handleOnException("ClearAll Validation Failed", e);
		}
	}

	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}
