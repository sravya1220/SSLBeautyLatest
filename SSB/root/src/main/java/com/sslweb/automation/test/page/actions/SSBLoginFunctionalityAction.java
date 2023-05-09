package com.sslweb.automation.test.page.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	private SSBLoginFunctionalityHelper ssbLoginFunctionalityHelper;

	public SSBLoginFunctionalityAction(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginFunctionalityHelper = new SSBLoginFunctionalityHelper(driver); // classname objname = newclass name 
	}

	public void LoginFunctionalityClick(String testCaseName, String mobileNumber) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.clickOnAccount();
			WebElementOperationsWeb.park(2);
		} catch (Exception e) {
			handleOnException("Unable to click on Account icon", e);
		}
	}
	public void openNewTab(String testCaseName) {
		try {
			WebElementOperationsWeb.openingNewTab(driver);			
			WebElementOperationsWeb.windowHandle(driver);
			
		} catch (Exception e) {
			handleOnException("Error occured in opening new tab", e);
		}
	}

	public void backofficeLoginFunctionality(String testCaseName,String username, String password) {
		try {

			WebElementOperationsWeb.park(2);
			ssbLoginFunctionalityHelper.backofficeLoginEnterUsername(username);
			ssbLoginFunctionalityHelper.backofficeLoginEnterPassword(password);
			ssbLoginFunctionalityHelper.backofficeClickOnLoginButton();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "BackofficeLoginFunctionality");

		} catch (Exception e) {
			handleOnException("Error occured while login to backoffice", e);
		}
	}
	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {
			WebElementOperationsWeb.park(1);
			ssbLoginFunctionalityHelper.LoginEnterUsername(username);
			ssbLoginFunctionalityHelper.LoginProceed();	
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("Error occured while login to site", e);
		}
	}

	public void backofficeMobileNumberVerication( String testCaseName,String mobileNumber,int arrayNum) {
		try {			
			ssbLoginFunctionalityHelper.backofficeEnterInUserOtpModel("User OTP Model");
			WebElementOperationsWeb.park(2);
			ssbLoginFunctionalityHelper.backofficeClickOnUserOtpModel();
			ssbLoginFunctionalityHelper.backofficeClickOnSearchModel();
			ssbLoginFunctionalityHelper.backofficeEnterMobileNumber(mobileNumber);
			ssbLoginFunctionalityHelper.backofficeClickOnSearchButton();
			WebElementOperationsWeb.park(2);
			ssbLoginFunctionalityHelper.backofficeClickOnMobileNumberInResults();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "MobileNumber Verification in Backoffice");

		} catch (Exception e) {
			handleOnException("Error occured while verifying mobile number in backoffice", e);

		}
	}	
	
	public void backofficeGetOtp( String testCaseName) {
		try {
			Thread.sleep(2000);
			WebElementOperationsWeb.windowHandle(driver);
			Thread.sleep(2000);
			ssbLoginFunctionalityHelper.backofficeClickOnSearchButton();
			Thread.sleep(3000);
			ssbLoginFunctionalityHelper.backofficeClickOnMobileNumberInResultsToGetOtp();
			Thread.sleep(5000);
			ssbLoginFunctionalityHelper.getOTP(testCaseName);
			Thread.sleep(2000);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "MobileNumber Verification in Backoffice");

		} catch (Exception e) {
			handleOnException("Error occured while getting otp in backoffice", e);
		}
	}	
	
	
	public String decryptusingweb(String strToDecrypt) {
		try {		
			Thread.sleep(2000);
			ssbLoginFunctionalityHelper.sendDecryptText(strToDecrypt);
			ssbLoginFunctionalityHelper.clickOnDecryptbutton();
			WebElementOperationsWeb.park(3);
			String decryptedOTP = driver.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
			System.out.println(decryptedOTP);
			return decryptedOTP;
		} catch (Exception e) {
			System.out.println("Decrypting is not working as Expected");
		}
		return null;
	}
	public void Invalidnumpopup() {
		if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getInvalidNumPopup())) {
			throw new ShoppersStopBusinessException(
					"Sign in [" + LoginInvalidMobileNumber.getInvalidNumPopup() + PopUp_IS_DISPLAYED);
		}
	}

	/*
	 * public void LoginFunctionalityEnterOTP(String testCaseName) { try {
	 * 
	 * WebElementOperationsWeb.park(15);
	 * ssbLoginFunctionalityHelper.enterOtp(testCaseName);
	 * WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName,
	 * "Logged in Successfully"); } catch (Exception e) {
	 * handleOnException("Error occured while entering otp", e); } }
	 */

	public void LoginFunctionalityClickonLogInButton(String testCaseName) {
		try {
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LogInButtonClick();
			WebElementOperationsWeb.park(15);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("Error occured while clicking login buton", e);
		}
	}

	public void Logoutfunctionalitycheck(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LogOutClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("Error occured while doing logout", e);
		}
	}

	public void enterOtp(String testCaseName,int otpCheckbox) {
		//List<String> otp = Arrays.asList("1", "2", "3","4","5","6");
		String otpNum="891234";
		List<WebElement> otpTextbox = driver.findElements(By.xpath("//input[@type='tel']"));
		WebElementOperationsWeb.park(2);
		WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "enterOtpByDecrypting");

		for(int i=otpCheckbox; i<otpTextbox.size(); i++) {
			if(otpCheckbox==0) {
			WebElementOperationsWeb.sendKeys(otpTextbox.get(i),String.valueOf(otpNum.charAt(i)));
			}
			if(otpCheckbox==1) {
			WebElementOperationsWeb.sendKeys(otpTextbox.get(i),String.valueOf(otpNum.charAt(i-1)));
			}
			}
		//ssbLoginFunctionalityHelper.enterOtpByDecrypting(testCaseName,arrayNum,otpCheckbox)	;	
	}
	
}
