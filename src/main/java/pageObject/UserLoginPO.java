package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserLoginUI;
import pageUIs.UserRegisterUI;

public class UserLoginPO extends BasePage{
	public WebDriver driver;

	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}


	public String getTextLabel(String valueInput) {
		waitForElementVisible(driver, UserLoginUI.DYNAMIC_TEXT_LABEL,valueInput);
		return getElementText(driver, UserLoginUI.DYNAMIC_TEXT_LABEL,valueInput);
		
	}

	public String getTextPlaceholder(String valueInput) {
		waitForElementVisible(driver, UserLoginUI.DYNAMIC_INPUT,valueInput);
		return getElementAttribute(driver,UserLoginUI.DYNAMIC_INPUT, "placeholder",valueInput);
	}
	public String getFontSizeTextLabel(String valueInput) {
		waitForElementVisible(driver, UserLoginUI.DYNAMIC_TEXT_LABEL,valueInput);
		return getFontSize(driver, UserLoginUI.DYNAMIC_TEXT_LABEL,valueInput);
	}
	public String getColorTextLabel(String valueInput) {
		waitForElementVisible(driver, UserLoginUI.DYNAMIC_TEXT_LABEL,valueInput);
		return getHexaColorFromRGBA(getColor(driver, UserLoginUI.DYNAMIC_TEXT_LABEL,valueInput)).toUpperCase();
	}

	public String getTextSubmitButton() {
		waitForElementClickable(driver, UserLoginUI.SUBMIT_BUTTON);
		return getElementText(driver, UserLoginUI.SUBMIT_BUTTON);
	}

	public boolean isSubmitButtonEnable() {
		waitForElementClickable(driver, UserLoginUI.SUBMIT_BUTTON);
		return isElementEnabled(driver, UserLoginUI.SUBMIT_BUTTON);
	}

	public boolean isDisplayRestPWTextLink() {
		waitForElementClickable(driver, UserLoginUI.RESET_PASSWORD_TEXTLINK);
		return isElementDisplayed(driver, UserLoginUI.RESET_PASSWORD_TEXTLINK);
	}

	public UserRestPWCA300PO clickRestPW() {
		waitForElementClickable(driver, UserLoginUI.RESET_PASSWORD_TEXTLINK);
		clickToElement(driver, UserLoginUI.RESET_PASSWORD_TEXTLINK);
		return PageGeneratorManager.getRestPWCA300Page(driver);
	}

	public void inputValid(String valueInput,String passValue) {
		waitForElementVisible(driver, UserLoginUI.DYNAMIC_INPUT, valueInput);
		sendkeyToElement(driver, UserLoginUI.DYNAMIC_INPUT, passValue, valueInput);
	}
	

	public UserHomePO clickSubmitButton() {
		waitForElementClickable(driver, UserLoginUI.SUBMIT_BUTTON);
		clickToElement(driver, UserLoginUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getTextErrorBlank(String inputValue) {
		waitForElementVisible(driver, UserLoginUI.DYNAMIC_ERROR_BLANK_TEXT,inputValue);
		return getElementText(driver, UserLoginUI.DYNAMIC_ERROR_BLANK_TEXT,inputValue);
	}

	public void clearValue(String valueInput) {
		clearValueInElementPressKey(driver, UserLoginUI.DYNAMIC_INPUT,valueInput);
		
	}

	public String getErrorInvalid() {
		waitForElementVisible(driver, UserLoginUI.ERROR_INVALID);
		return getElementText(driver, UserLoginUI.ERROR_INVALID);
	}

	public UserRegisterCA200PO clickCreateAccountLink() {
		sleepInSecond(2);
		waitForElementClickable(driver, UserLoginUI.CREATE_ACCOUNT_LINK);
		clickToElement(driver, UserLoginUI.CREATE_ACCOUNT_LINK);
		return PageGeneratorManager.getUserRegisterCA200Page(driver);
	}


	public UserRegisterCA203PO clickSubmitButtonStatus1() {
		waitForElementClickable(driver, UserLoginUI.SUBMIT_BUTTON);
		clickToElement(driver, UserLoginUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getUserRegisterCA203Page(driver);
	}
}
