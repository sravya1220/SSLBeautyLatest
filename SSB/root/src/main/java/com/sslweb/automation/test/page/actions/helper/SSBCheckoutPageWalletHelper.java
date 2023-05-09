package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusingcreditcard.model.CheckoutFlowCreditCard;
import com.sslweb.automation.checkoutpageusingdebitcard.model.CheckoutFlowDebitCard;
import com.sslweb.automation.checkoutpageusingwallet.model.CheckoutFlowWallet;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageWalletHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to get discount payment through
	// wallet
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Net Banking 7. Enter Bank Name
	 * 8. Click on Pay Now
	 */

	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageWalletHelper.class);

	public SSBCheckoutPageWalletHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Clicking on Type of payment
	public void ClickonWalletCheckbox() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowWallet.getWalletClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on wallet checkbox: " + CheckoutFlowWallet.getWalletClick(),
					e);
		}
	}

	// Sending Wallet OTP
	public void SendWalletOTP(String testCaseName, String token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowWallet.getEnterWalletOTP())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowWallet.getEnterWalletOTP(), token);
				WebElementOperationsWeb.park(2);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to enter OTP textbox [" + CheckoutFlowWallet.getEnterWalletOTP() + "]");
			}
		} catch (Exception e) {
			handleOnException("Error occured while entering OTP [" + CheckoutFlowWallet.getEnterWalletOTP() + "]", e);
		}
	}

	// Clicking on Verify
	public void ClickonVerify() {
		try {
			WebElementOperationsWeb.BtnEnableVerification(CheckoutFlowWallet.getVerifyAndProceedButton());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Verify: " + CheckoutFlowWallet.getVerifyAndProceedButton(),
					e);
		}
	}

	public void cartClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getCartHeader())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowCreditCard.getCartHeader());
			} else {
				LOG.error("Error in clicking Cart header");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Cart: " + CheckoutFlowDebitCard.getCartHeader(),
					e);
		}		
	}

	public void productRemoveBtn() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getProductRemoveBtn())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowCreditCard.getProductRemoveBtn());
			} else {
				LOG.error("Error in clicking product remove Button");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on product remove Button: " + CheckoutFlowDebitCard.getProductRemoveBtn(),
					e);
		}
	}

	public void productRemove() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getRemoveBtn())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowCreditCard.getRemoveBtn());
			} else {
				LOG.error("Error in clicking product proceed remove Button");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on product proceed remove Button:" + CheckoutFlowDebitCard.getProceedButton(),
					e);
		}
	}


}
