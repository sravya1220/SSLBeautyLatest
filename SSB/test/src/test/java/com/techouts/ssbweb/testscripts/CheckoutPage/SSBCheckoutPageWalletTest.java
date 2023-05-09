package com.techouts.ssbweb.testscripts.CheckoutPage;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingwallet.model.CheckoutPageUsingWallet;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageWalletAction;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBPDPVerifyDetailsAction;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.UserBackofficeLoginFunctionalityCheck;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageWalletTest extends AbstractTest {
	
	
		private SSBCheckoutPageWalletAction ssbcheckoutpagenwallet;

		private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingWallet";
		private static final int SERIAL_NO = 4;
		private SSBLoginFunctionalityAction ssbLoginActions;
		private SSBPDPVerifyDetailsAction ssbpdpverifydetailsAction;
		
		public SSBCheckoutPageWalletTest() {
			new CheckoutPageUsingWallet().init(DRIVER);
			new CheckoutPageNavigationFlow().init(DRIVER);
			new SSBPDPVerifyDetails().init(DRIVER);
			new UserLoginFunctionalityCheck().init(DRIVER);
			new UserBackofficeLoginFunctionalityCheck().init(DRIVER);
			ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
			ssbpdpverifydetailsAction = new SSBPDPVerifyDetailsAction(DRIVER,REPOSITORY);
			ssbcheckoutpagenwallet = new SSBCheckoutPageWalletAction(DRIVER, REPOSITORY);
		}

		@BeforeMethod
		public void openShoppersStopPage() {
			getSslPage();
		}
		
		@Test(testName = TEST_CASE_NAME, description = "Checkout Page Wallet Functionalities check")
		public void verifyCreditcardpayatcheckout() {
			try {
				User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
						"Mobile Login credential should not be null");
				ssbLoginActions.LoginFunctionalityClick(TEST_CASE_NAME, mobilelogin.getMobileno());
				/*
				 * ssbLoginActions.openNewTab(TEST_CASE_NAME); getSslBackofficeUrl(); User
				 * backofficelogin = Objects.requireNonNull(CredentialProvider.getUser("E010"),
				 * "Backoffice Login credential should not be null");
				 * ssbLoginActions.backofficeLoginFunctionality(TEST_CASE_NAME,
				 * backofficelogin.getEmail(), backofficelogin.getPassword());
				 * ssbLoginActions.backofficeMobileNumberVerication(TEST_CASE_NAME,mobilelogin.
				 * getMobileno(),0); WebElementOperationsWeb.handleParentTab(DRIVER ,0);
				 */
				ssbLoginActions.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
				//ssbLoginActions.backofficeGetOtp(TEST_CASE_NAME);
				//getSslDecryptUrl();
				ssbLoginActions.enterOtp(TEST_CASE_NAME,0);
				ssbLoginActions.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
				ssbpdpverifydetailsAction.NavigateToPDP(TEST_CASE_NAME, PDP_SHEET,SERIAL_NO);
				ssbcheckoutpagenwallet.NavigatetoCartPage(TEST_CASE_NAME);
				ssbcheckoutpagenwallet.ClickingonProceedNow(TEST_CASE_NAME);
				ssbcheckoutpagenwallet.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO);
				ssbcheckoutpagenwallet.EnteringWalletDetails(TEST_CASE_NAME);
				ssbcheckoutpagenwallet.removeProduct(TEST_CASE_NAME);

			} catch (Exception e) {
				WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Wallet Payment");
				handleOnException("UPI payment Validation Failed", e);
			}
		}
		
		@AfterMethod()
		public boolean tearDown() {
			return true;
		}
	}




