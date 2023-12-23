package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.Login_Third_UI;

public class Login_ThirdPO extends BasePage {
	public WebDriver driver;

	public Login_ThirdPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterValueLoginMicrosoft(String nameInput, String emailValid) {
		if (getElementSize(driver, Login_Third_UI.USER_ANOTHER_ACCOUT_BUTTON) > 0) {
			clickToElement(driver, Login_Third_UI.USER_ANOTHER_ACCOUT_BUTTON);
		}
		waitForElementVisible(driver, Login_Third_UI.MICROSOFT_LOGIN_INPUT, nameInput);
		sendkeyToElement(driver, Login_Third_UI.MICROSOFT_LOGIN_INPUT, emailValid, nameInput);

	}

	public void enterValuePassword(String nameInput, String emailValid) {

		waitForElementVisible(driver, Login_Third_UI.MICROSOFT_LOGIN_INPUT, nameInput);
		sendkeyToElement(driver, Login_Third_UI.MICROSOFT_LOGIN_INPUT, emailValid, nameInput);

	}

	public void clickSubmit() {
		waitForElementClickable(driver, Login_Third_UI.MICROSOFT_SUBMIT_BUTTON);
		clickToElement(driver, Login_Third_UI.MICROSOFT_SUBMIT_BUTTON);
	}

	public void clickTabListEmail() {
		sleepInSecond(10);
		waitForElementClickable(driver, Login_Third_UI.TAB_EMAIL_OUTLOOK);
		clickToElement(driver, Login_Third_UI.TAB_EMAIL_OUTLOOK);
	}

	public UserRestPWCA302PO clickUrlEmail(String url) {
		waitForElementClickable(driver, Login_Third_UI.URL_OUT_LOOK);
		clickToElement(driver, Login_Third_UI.URL_OUT_LOOK);
		sleepInSecond(5);
		switchToWindowByUrl(driver, "password/re-new?expires");

		return PageGeneratorManager.getRestPWCA302Page(driver);
	}

	public UserRegisterCA203PO clickUrlEmailMemembership(String url) {
		waitForElementClickable(driver, Login_Third_UI.URL_OUTLOOK_MEMBERSHIP, url);
		clickToElement(driver, Login_Third_UI.URL_OUTLOOK_MEMBERSHIP, url);
		sleepInSecond(5);
		switchToWindowByUrl(driver, "auth/register/membership/");

		return PageGeneratorManager.getUserRegisterCA203Page(driver);
	}

	public void loginMicrosoft() {

	}

}
