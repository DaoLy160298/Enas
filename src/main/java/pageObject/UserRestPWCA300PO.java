package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserLoginUI;
import pageUIs.UserRestPWUI;

public class UserRestPWCA300PO extends BasePage {
	public WebDriver driver;

	public UserRestPWCA300PO(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrlTextRestPW(WebDriver driver) {
		sleepInSecond(1);
		return getPageUrl(driver);
	}

	public UserLoginPO getBackBrowser() {
		backToPage(driver);
		return PageGeneratorManager.getUserLogin(driver);
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
		waitForElementVisible(driver, UserRestPWUI.NOTE_TEXT_CA300);
		return getFontSize(driver, UserRestPWUI.NOTE_TEXT_CA300);
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

	public String getNotiText() {
		waitForElementVisible(driver, UserRestPWUI.NOTE_TEXT_CA300);
		return getElementText(driver, UserRestPWUI.NOTE_TEXT_CA300);
	}

	public String getPlaceholderText(String nameInput) {
		waitForElementVisible(driver, UserRestPWUI.DYNAMIC_INPUT,nameInput);
		return getElementAttribute(driver, UserRestPWUI.DYNAMIC_INPUT, "placeholder",nameInput);
	}

	public String getTextRestPwButton() {
		waitForElementClickable(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
		return getElementText(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
	}

	public void clickRestPW() {
		waitForElementClickable(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
		clickToElement(driver, UserRestPWUI.REST_PASSWPORD_BUTTON);
	}

	public String getErrorRestPW() {
		waitForElementVisible(driver, UserRestPWUI.ERROR_TEXT);
		return getElementText(driver, UserRestPWUI.ERROR_TEXT);
	}

	public void inputValue(String nameInput,String emailInvalid) {
		waitForElementVisible(driver, UserRestPWUI.DYNAMIC_INPUT,nameInput);
		sendkeyToElement(driver, UserRestPWUI.DYNAMIC_INPUT, emailInvalid,nameInput);
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

	public String getUrlScreenNewResetPW(WebDriver driver) {
		sleepInSecond(2);
		return getPageUrl(driver);
		
	}

	public String getTextNoteCA301() {
		sleepInSecond(2);
		waitForElementVisible(driver, UserRestPWUI.NOTE_TEXT_CA301_CA302);
		return getElementText(driver, UserRestPWUI.NOTE_TEXT_CA301_CA302);
	}


	
	

}
