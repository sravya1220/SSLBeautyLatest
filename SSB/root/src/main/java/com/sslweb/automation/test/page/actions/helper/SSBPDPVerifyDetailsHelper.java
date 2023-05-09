package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.ssbpdpverifydetails.model.VerifyDetailsPDP;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.SSBBackofficeLoginFunctionality;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPVerifyDetailsHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private ExcelRepository repository;
	private static final Logger LOG = Logger.getLogger(SSBPDPVerifyDetailsHelper.class);

	public SSBPDPVerifyDetailsHelper(WebDriver driver,ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository, "Repository cannot be null ");

	}
	// Navigation to PDP page from Home Page

	public void sendDecryptText(String decryptValue) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getEnterTextInDecrypt())) {
				WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getEnterTextInDecrypt(), decryptValue);
			} else {
				LOG.error("Please enter a valid decryptValue");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending decryptValue "
					+ SSBBackofficeLoginFunctionality.getEnterTextInDecrypt(), e);
			}
		}
	public void clickOnDecryptbutton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnDecryptButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnDecryptButton());
			} else {
				LOG.error("Error in clicking Decrypt button ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Decrypt button  "
					+ SSBBackofficeLoginFunctionality.getClickOnDecryptButton(), e);
			}
		}
	// Search Box
	public void sendProductID(String testCaseName, String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getSearchBarPLP())) {
				WebElementOperationsWeb.enterKeysWithEnter(driver, VerifyDetailsPDP.getSearchBarPLP(), repository.readStringFrom(sheetName, Sheet.PdpPage.PRODUCT_CODE, serialNo));

			} else {
				throw new ShoppersStopBusinessException("Unable to send product code ["
						+ VerifyDetailsPDP.getSearchBarPLP() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "ProductDetails");
			handleOnException("Error occured while sending product code [" + VerifyDetailsPDP.getSearchBarPLP() + "]", e);
		}
	}

	// Clicking on Product card to navigate to PDP
	public void ClickonProductCard() {
		try {
			WebElementOperationsWeb.jsClick(driver, VerifyDetailsPDP.getProductCardClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Product Card: " + VerifyDetailsPDP.getProductCardClick(), e);
		}
	}

	// PDP Page

	// Clicking on Product Image
	public void ClickonProductImage() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getProductImageClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Product Image: " + VerifyDetailsPDP.getProductImageClick(),
					e);
		}
	}

	// Clicking on Close Button
	public void ClickonCloseButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getCloseButton());

		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking CloseButton: " + VerifyDetailsPDP.getCloseButton(),
					e);
		}
	}

	// Product Details Check in PDP

	// Verifying Product Details
	public void VerifyProductDetails() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getProductDetailsCheck())) {
			throw new ShoppersStopBusinessException(
					"Product Details label [" + VerifyDetailsPDP.getProductDetailsCheck() + "] is not displayed");
		}
	}

	public void VerifyProductName() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getProductName())) {
			throw new ShoppersStopBusinessException(
					"Product Name label [" + VerifyDetailsPDP.getProductName() + "] is not displayed");
		}
	}
	
	public void VerifyProductRatings() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getRatings())) {
			throw new ShoppersStopBusinessException(
					"Product Ratings [" + VerifyDetailsPDP.getRatings() + "] is not displayed");
		}
	}
	// Verifying Product Price
	public void VerifyProductPrice() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getProductPriceCheck())) {
			throw new ShoppersStopBusinessException(
					"Product Price label [" + VerifyDetailsPDP.getProductPriceCheck() + "] is not displayed");
		}
	}
	public void VerifyAddToCart() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getAddToCartButton())) {
			throw new ShoppersStopBusinessException(
					"AddToCartButton [" + VerifyDetailsPDP.getAddToCartButton() + "] is not displayed");
		}
	}
	public void VerifyBuyNow() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getBuyNowButton())) {
			throw new ShoppersStopBusinessException(
					"BuyNow Button [" + VerifyDetailsPDP.getBuyNowButton() + "] is not displayed");
		}
	}
	// Verify Easy Returns click

	public void EasyReturnsClick() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getEasyReturnsClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Easy Returns button: "
					+ VerifyDetailsPDP.getEasyReturnsClick(), e);
		}
	}
	// Verify Authentic product click

	public void AuthenticProductClick() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getAuthenticProductClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Authentic Product Click: "
					+ VerifyDetailsPDP.getAuthenticProductClick(), e);
		}
	}

	// Exit from Easy returns and Authentication pop up 
	public void CloseOkayButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getClickingButtonEasyR());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Okay Button: " + VerifyDetailsPDP.getClickingButtonEasyR(),
					e);
		}
	}

	public void HowtouseClick() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getHowtoUseClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Howtouse Button: " + VerifyDetailsPDP.getHowtoUseClick(), e);
		}
	}
	// WishList Icon
	public void WishListIcon() {
		try {
			WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getWishListIcon());
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getWishListIcon());
			WebElementOperationsWeb.park(5);
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Wishlist Button: " + VerifyDetailsPDP.getWishListIcon(), e);
		}
	}
	
	public void removeWishList() {
		try {
			WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getRemoveWishList());
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getRemoveWishList());
			WebElementOperationsWeb.park(5);
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Wishlist Button: " + VerifyDetailsPDP.getWishListIcon(), e);
		}
	}
	public void WishListCountVerification() {
		try {
			WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getTopWishlistIcon());
			String wishlistCount=WebElementOperationsWeb.getText(driver, VerifyDetailsPDP.getTopWishlistIcon());
			if(wishlistCount.length()<1) {
				LOG.error("Product not added to wishlist");
			}
			
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Wishlist Button: " + VerifyDetailsPDP.getWishListIcon(), e);
		}
	}

}
