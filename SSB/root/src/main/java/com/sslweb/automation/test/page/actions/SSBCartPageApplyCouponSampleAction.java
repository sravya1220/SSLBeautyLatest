package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCartPageApplyCouponSampleHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageApplyCouponSampleAction extends GlobalExceptionHandler {
	
	private static final Logger LOG = Logger.getLogger(SSBCartPageApplyCouponSampleAction.class);
	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	public JavascriptExecutor js;

	private SSBCartPageApplyCouponSampleHelper ssbcartpageApplyCouponSample;
	//private  SSBPLPClearAllFunctionality ssbLoginFunctionalityValidator;
	
	public SSBCartPageApplyCouponSampleAction(WebDriver driver, ExcelRepository repository){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcartpageApplyCouponSample = new SSBCartPageApplyCouponSampleHelper(driver,repository);
		js = (JavascriptExecutor) driver;
		//ssbclearallfilterFunctionalityHelper = new SSBPLPClearAllFunctionalityHelper(driver);
	}
	
	public void ClickOnProductClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcartpageApplyCouponSample.L1categorymousehover();
			WebElementOperationsWeb.park(5);
			ssbcartpageApplyCouponSample.L2Catogorymousehover();
			WebElementOperationsWeb.park(5);
			ssbcartpageApplyCouponSample.ClickOnProductClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonAddToCartProduct(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(15);
			js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.park(5);
			ssbcartpageApplyCouponSample.ClickonAddToCartProduct();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonAddToCartClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 100);
			WebElementOperationsWeb.park(5);
			ssbcartpageApplyCouponSample.ClickonAddToCartClick();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonApplyCouponIcon1(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcartpageApplyCouponSample.ClickonApplyCouponIcon1();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void sendAndApplyCoupon(String testCaseName, String sheetName, int serialNo){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.sendCoupon(testCaseName,sheetName,serialNo);
			ssbcartpageApplyCouponSample.ClickonApplyCouponClick1();
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.ClickonRemoveCoupon1();

			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonRemoveBtn(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			ssbcartpageApplyCouponSample.ClickRemoveBtn();
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.ProductRemoveBtn();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonRemoveCoupon1(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.ClickonRemoveCoupon1();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonApplyCouponIcon2(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.ClickonApplyCouponIcon2();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	public void ClickonApplyCouponClick2(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.ClickonApplyCouponClick2();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	public void ClickonRemoveCoupon2(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			js.executeScript("window.scrollBy(0,-100)"," ");
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.ClickonRemoveCoupon2();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void VerifyGetShoppingButton(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbcartpageApplyCouponSample.GetShoppingBtn();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "GetShoppingBtn");	
		} catch (Exception e) {
			handleOnException("GetShoppingBtn not able to found", e);
		}
	}
	
	
}
