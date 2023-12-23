package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserLoginUI;
import pageUIs.UserRestPWUI;

public class UserRestPWCA302PO extends BasePage {
	public WebDriver driver;

	public UserRestPWCA302PO(WebDriver driver) {
		this.driver = driver;
	}


	public Login_ThirdPO openBrowser() {
		((JavascriptExecutor) driver).executeScript("window.open('https://outlook.office365.com/mail/','_blank');");

        // Switch to the new tab
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return PageGeneratorManager.login_ThirdPage(driver);
	}
	public boolean isDisplayTitleText() {
		waitForElementVisible(driver,UserRestPWUI.TITLE_TEXT);
		return isElementDisplayed(driver, UserRestPWUI.TITLE_TEXT);
	}

	public String getFontSizeTextTitle() {
		waitForElementVisible(driver,UserRestPWUI.TITLE_TEXT);
		return getFontSize(driver, UserRestPWUI.TITLE_TEXT);
	}
	public String getFontSizeTextNote() {
		waitForElementVisible(driver, UserRestPWUI.NOTE_TEXT_CA301_CA302);
		return getFontSize(driver, UserRestPWUI.NOTE_TEXT_CA301_CA302);
	}
	public String getFontSizeTextLabel(String nameInput) {
		waitForElementVisible(driver, UserRestPWUI.DYNMAIC_TEXT_LABEL,nameInput);
		return getFontSize(driver, UserRestPWUI.DYNMAIC_TEXT_LABEL,nameInput);
	}

	public String getColorTextTitle() {
		waitForElementVisible(driver, UserRestPWUI.TITLE_TEXT);
		return getHexaColorFromRGBA(getColor(driver, UserRestPWUI.TITLE_TEXT)).toUpperCase();
	}

	public String getColorTextLabel(String nameInput) {
		waitForElementVisible(driver, UserRestPWUI.DYNMAIC_TEXT_LABEL,nameInput);
		return getHexaColorFromRGBA(getColor(driver, UserRestPWUI.DYNMAIC_TEXT_LABEL,nameInput)).toUpperCase();
		
	}

	public String getTextLabel(String nameInput) {
		waitForElementVisible(driver, UserRestPWUI.DYNMAIC_TEXT_LABEL,nameInput);
		return getElementText(driver, UserRestPWUI.DYNMAIC_TEXT_LABEL,nameInput);
	}
	public String getPlaceholderText(String nameInput) {
		waitForElementVisible(driver, UserRestPWUI.DYNAMIC_INPUT,nameInput);
		return getElementAttribute(driver, UserRestPWUI.DYNAMIC_INPUT, "placeholder",nameInput);
	}


	public String getUrlScreen(WebDriver driver) {
		sleepInSecond(2);
		return getPageUrl(driver);
		
	}
	public String getTextRestPwButton() {
		waitForElementClickable(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
		return getElementText(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
	}


	public void clickRestButton() {
		waitForElementClickable(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
		clickToElement(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
	}


	public String getErrorPW(String nameInput) {
		waitForElementVisible(driver, UserRestPWUI.DYNAMIC_PW_ERROR,nameInput);
		return getElementText(driver, UserRestPWUI.DYNAMIC_PW_ERROR,nameInput);
	}


	public void inputValue(String nameInput,String value) {
		waitForElementVisible(driver, UserRestPWUI.DYNAMIC_INPUT,nameInput);
		sendkeyToElement(driver, UserRestPWUI.DYNAMIC_INPUT, value,nameInput);
	}


	public String getTextNoteCA303() {
		waitForElementVisible(driver, UserRestPWUI.NOTE_TEXT_CA301_CA302);
		return getElementText(driver, UserRestPWUI.NOTE_TEXT_CA301_CA302);
	}


	public boolean isEnableButtonLogin() {
		waitForElementClickable(driver, UserRestPWUI.LOGIN_BUTTON);
		return isElementEnabled(driver, UserRestPWUI.LOGIN_BUTTON);
	}


	public UserLoginPO clickButtonLogin() {
		waitForElementClickable(driver, UserRestPWUI.LOGIN_BUTTON);
		clickToElement(driver, UserRestPWUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserLogin(driver);
	}
	

}
