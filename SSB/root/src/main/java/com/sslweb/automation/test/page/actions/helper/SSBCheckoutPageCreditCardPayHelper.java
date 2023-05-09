package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusingcreditcard.model.CheckoutFlowCreditCard;
import com.sslweb.automation.checkoutpageusingdebitcard.model.CheckoutFlowDebitCard;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageCreditCardPayHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to make a creditcard payment
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Credit/Debit Card 7. Enter Card
	 * Detail 8. Click on Pay
	 */

	private WebDriver driver = null;
	private ExcelRepository repository;
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageCreditCardPayHelper.class);

	public SSBCheckoutPageCreditCardPayHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Adding to cart, sign in and address is taken from parent class navigation
	// helper
	// Cart Page
	// Clicking on Type of payment
	public void ClickonCreditcard() {
		try {
			WebElementOperationsWeb.waitForElementVisible(driver, 15,
					CheckoutFlowCreditCard.getCreditCardDebitCardClick());
			WebElementOperationsWeb.click(driver, CheckoutFlowCreditCard.getCreditCardDebitCardClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Credit/Debit Card: "
					+ CheckoutFlowCreditCard.getCreditCardDebitCardClick(), e);
		}
	}

	// Adding Card Details
	// Card Number
	public void writeToCardNumber(String sheetName, int serialNo) {
		try {
			WebElementOperationsWeb.jsClick(driver,CheckoutFlowCreditCard.getCardDetails()); 
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCreditCard.getCardDetails(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CARD_NUMBER, serialNo));
				WebElementOperationsWeb.park(2);
			
		} catch (Exception e) {
			handleOnException(
					"Error occured while sending CreditCard Number [" + CheckoutFlowCreditCard.getCardDetails() + "]",
					e);
		}
	}

	public void writeNameOnCard(String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getNameonCard())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCreditCard.getNameonCard(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.NAME_ON_CARD, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Name on Card [" + CheckoutFlowCreditCard.getNameonCard() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while sending Name On Card [" + CheckoutFlowCreditCard.getNameonCard() + "]", e);
		}
	}

	public void sendExpMonth(String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getExp_Month())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCreditCard.getExp_Month(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CARD_MONTH, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Expiry Month [" + CheckoutFlowCreditCard.getExp_Month() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while selecting Expiry month [" + CheckoutFlowCreditCard.getExp_Month() + "]", e);
		}
	}

	public void sendExpYear(String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getExp_Year())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCreditCard.getExp_Year(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CARD_YEAR, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Expiry year [" + CheckoutFlowCreditCard.getExp_Year() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while selecting Expiry year [" + CheckoutFlowCreditCard.getExp_Year() + "]", e);
		}
	}
	public void writeToCvv(String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getCVV())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCreditCard.getCVV(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CVV, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Cvv textbox [" + CheckoutFlowCreditCard.getCVV() + "]");
			}
		} catch (Exception e) {
			handleOnException("Error occured while sending CVV Value [" + CheckoutFlowCreditCard.getCVV() + "]", e);
		}
	}

	// Confirming to add card for future payments
	public void ClickonSaveCard() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowCreditCard.getSaveCard());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Payment: " + CheckoutFlowCreditCard.getSaveCard(),
					e);
		}
	}

	// Clicking on Pay now
	public void paynowBtnEnableVerification() {
		try {
			WebElementOperationsWeb.BtnEnableVerification(CheckoutFlowCreditCard.getPayNow());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while checking paynow button enable status: " + CheckoutFlowCreditCard.getPayNow(),
					e);
		}
	}

	public void writeCCCardOTP(String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCreditCard.getCCCardOTP())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCreditCard.getCCCardOTP(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.PASSWORD, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the OTP textbox [" + CheckoutFlowCreditCard.getCCCardOTP() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while sending Card OTP Value [" + CheckoutFlowCreditCard.getCCCardOTP() + "]", e);
		}
	}

	// Clicking on Submit redirects to payment successfull page
	public void ClickonSubmitSuccess() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowCreditCard.getSubmitSuccess());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Submit Success: "
					+ CheckoutFlowCreditCard.getSubmitSuccess(), e);
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
