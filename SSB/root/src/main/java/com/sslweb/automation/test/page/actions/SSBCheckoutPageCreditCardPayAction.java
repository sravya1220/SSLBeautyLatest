package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageNavigationHelper;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageCreditCardPayHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageCreditCardPayAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBCheckoutPageNavigationHelper ssbcheckoutNavigation;
	private SSBCheckoutPageCreditCardPayHelper ssbcheckoutcreditcardpay;

	public SSBCheckoutPageCreditCardPayAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcheckoutcreditcardpay = new SSBCheckoutPageCreditCardPayHelper(driver, repository);
		ssbcheckoutNavigation = new SSBCheckoutPageNavigationHelper(driver, repository);
		js = (JavascriptExecutor) driver;
		// ssbclearallfilterFunctionalityHelper = new
		// SSBPLPClearAllFunctionalityHelper(driver);
	}

	public void NavigatetoCartPage(String testCaseName) {
		try {
			WebElementOperationsWeb.park(10);
			ssbcheckoutNavigation.ClickonAddtoCart();
			WebElementOperationsWeb.park(15);
			ssbcheckoutNavigation.ClickonCartIcon();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void ClickingonProceedNow(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutNavigation.ClickonPlaceorder();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void SigninFlow(String testCaseName, String Mobileno, String OTP) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.sendMobileno(testCaseName, Mobileno);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonProceed();
			WebElementOperationsWeb.park(20);
			// ssbcheckoutNavigation.sendOTP(testCaseName, OTP);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonLogin();
			WebElementOperationsWeb.park(20);
			ssbcheckoutNavigation.ClickonPlaceorder();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Signin");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void AddingAddress(String sheetname, String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			/*
			 * For Creating new Address ssbcheckoutNavigation.ClickonAddnewAddress();
			 * WebElementOperationsWeb.park(2);
			 * ssbcheckoutNavigation.sendFullName(sheetname, serialno, testCaseName);
			 * WebElementOperationsWeb.park(1);
			 * ssbcheckoutNavigation.sendMobileNumber(sheetname, serialno, testCaseName);
			 * WebElementOperationsWeb.park(1); ssbcheckoutNavigation.sendPincode(sheetname,
			 * serialno, testCaseName); WebElementOperationsWeb.park(3);
			 * ssbcheckoutNavigation.sendAddress(sheetname, serialno, testCaseName);
			 * WebElementOperationsWeb.park(1);
			 * ssbcheckoutNavigation.ClickonAddDefaultAddress();
			 * WebElementOperationsWeb.park(1);
			 * ssbcheckoutNavigation.ClickonAddresstypeHome();
			 * WebElementOperationsWeb.park(1);
			 * ssbcheckoutNavigation.ClickonAddnewaddressSelect();
			 * WebElementOperationsWeb.park(3);
			 * WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName,
			 * "AllFieldsDisplayed"); WebElementOperationsWeb.park(3);
			 */
			ssbcheckoutNavigation.ClickonAddressbox();
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonProceedtoPayment();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void EnteringCreditCardDetails(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutcreditcardpay.ClickonCreditcard();
			WebElementOperationsWeb.park(15);
			WebElementOperationsWeb.switchToFrame(driver, 0);
			ssbcheckoutcreditcardpay.writeToCardNumber(sheetname, serialno);
			WebElementOperationsWeb.switchToDefaultContentFrame(driver);
			WebElementOperationsWeb.park(1);
			WebElementOperationsWeb.switchToFrame(driver, 1);
			ssbcheckoutcreditcardpay.writeNameOnCard(sheetname, serialno);
			WebElementOperationsWeb.switchToDefaultContentFrame(driver);
			WebElementOperationsWeb.park(1);
			WebElementOperationsWeb.switchToFrame(driver, 2);
			ssbcheckoutcreditcardpay.sendExpMonth(sheetname, serialno);
			WebElementOperationsWeb.park(1);
			WebElementOperationsWeb.switchToDefaultContentFrame(driver);
			WebElementOperationsWeb.switchToFrame(driver, 3);
			ssbcheckoutcreditcardpay.sendExpYear(sheetname, serialno);
			WebElementOperationsWeb.park(1);
			WebElementOperationsWeb.switchToDefaultContentFrame(driver);
			WebElementOperationsWeb.switchToFrame(driver, 4);
			ssbcheckoutcreditcardpay.writeToCvv(sheetname, serialno);
			WebElementOperationsWeb.park(1);
			WebElementOperationsWeb.switchToDefaultContentFrame(driver);
			ssbcheckoutcreditcardpay.ClickonSaveCard();
			WebElementOperationsWeb.park(3);
			ssbcheckoutcreditcardpay.paynowBtnEnableVerification();
			WebElementOperationsWeb.park(1);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void CCBankPageSimulateSuccessClick(String testCaseName, int Serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(5);
			ssbcheckoutcreditcardpay.writeCCCardOTP(testCaseName, Serialno);
			WebElementOperationsWeb.park(5);
			ssbcheckoutcreditcardpay.ClickonSubmitSuccess();
			WebElementOperationsWeb.park(10);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("Failure occured while payment", e);
		}
	}

	public void removeProduct(String testCaseName) {
		try {
			ssbcheckoutcreditcardpay.cartClick();
			WebElementOperationsWeb.park(3);

			ssbcheckoutcreditcardpay.productRemove();
			ssbcheckoutcreditcardpay.productRemoveBtn();

	WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "removeProduct");
		} catch (Exception e) {
			handleOnException("product not removed", e);
		}
	}

}
