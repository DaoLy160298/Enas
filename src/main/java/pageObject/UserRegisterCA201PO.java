package pageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CommonsUI;
import pageUIs.Login_Third_UI;
import pageUIs.UserRegisterUI;

public class UserRegisterCA201PO extends BasePage {
	public WebDriver driver;

	public UserRegisterCA201PO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayTextTitleCA201() {
		sleepInSecond(2);
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA200_TEXT);
		return isElementDisplayed(driver, UserRegisterUI.TITLE_CA200_TEXT);
	}

	public boolean isDisplayTextLabelCA201(String textLabel) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXT_LABEL, textLabel);
		return isElementDisplayed(driver, UserRegisterUI.DYNAMIC_TEXT_LABEL, textLabel);
	}

	public String getPlaceholder(String textInput) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_INPUT_TEXT, textInput);
		return getElementAttribute(driver, UserRegisterUI.DYNAMIC_INPUT_TEXT, "placeholder", textInput);
	}

	public String getColorTextLabelCA201(String textLable) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXT_LABEL, textLable);
		return getHexaColorFromRGBA(getColor(driver, UserRegisterUI.DYNAMIC_TEXT_LABEL, textLable)).toUpperCase();
	}

	public String getFontSizeTextLabelCA201(String textLable) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXT_LABEL, textLable);
		return getFontSize(driver, UserRegisterUI.DYNAMIC_TEXT_LABEL, textLable);

	}

	public String getColorTextTitleCA201() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA200_TEXT);
		return getHexaColorFromRGBA(getColor(driver, UserRegisterUI.TITLE_CA200_TEXT)).toUpperCase();
	}

	public String getFontSizeTextTitleCA201() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA200_TEXT);
		return getFontSize(driver, UserRegisterUI.TITLE_CA200_TEXT);
	}

	public void inputValue(String textInput, String value) {
		waitForAllElementVisible(driver, UserRegisterUI.DYNAMIC_INPUT_TEXT, textInput);
		sendkeyToElement(driver, UserRegisterUI.DYNAMIC_INPUT_TEXT, value, textInput);

	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, UserRegisterUI.SUBMIT_BUTTON);
		clickToElement(driver, UserRegisterUI.SUBMIT_BUTTON);
	}

	public boolean isUnDisplayErrorInput(String value) {
		return isElementUndisplayed(driver, UserRegisterUI.DYNAMIC_TEXT_ERROR, value);
	}

	public String getTextError(String value) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXT_ERROR,value);
		return getElementText(driver, UserRegisterUI.DYNAMIC_TEXT_ERROR,value);
	}

	public String getlinkUrlSendSuccess() {
		sleepInSecond(2);
		return getPageUrl(driver);
	}

	public boolean isDisplayTextTitleCA202() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA202_TEXT);	
		return isElementDisplayed(driver, UserRegisterUI.TITLE_CA202_TEXT);	
	}

	public String getTextNoti() {
		waitForElementVisible(driver, UserRegisterUI.NOTI_SEND_SUCCESS_CA202);	
		return getElementText(driver, UserRegisterUI.NOTI_SEND_SUCCESS_CA202);
		
	}

	public Login_ThirdPO clickOutlook() {
		waitForElementClickable(driver, UserRegisterUI.OUTLOOK_BUTTON);
		clickToElement(driver, UserRegisterUI.OUTLOOK_BUTTON);
		
		return PageGeneratorManager.login_ThirdPage(driver);
	}



}
