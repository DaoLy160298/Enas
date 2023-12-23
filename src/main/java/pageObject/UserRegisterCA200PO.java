package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CommonsUI;
import pageUIs.UserRegisterUI;

public class UserRegisterCA200PO extends BasePage{
	public WebDriver driver;

	public UserRegisterCA200PO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayTextTitleCA200() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA200_TEXT);
		return isElementDisplayed(driver, UserRegisterUI.TITLE_CA200_TEXT);
		
	}

	public String getColorTitleCAS200() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA200_TEXT);
		return getHexaColorFromRGBA(getColor(driver,UserRegisterUI.TITLE_CA200_TEXT)).toUpperCase();
	}

	public String getFontSizeTitleCA200() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA200_TEXT);
		return getFontSize(driver, UserRegisterUI.TITLE_CA200_TEXT);
	}
	public String getAgreeTextLink() {
		waitForElementVisible(driver, UserRegisterUI.POLICY_TEXTLINK);
		String policyText = getElementText(driver, UserRegisterUI.POLICY_TEXTLINK);
		String agreeText = getElementText(driver, UserRegisterUI.AGREE_TEXT);
		return policyText.concat(agreeText);
	}
	public boolean isDisplayclickButtons(String textButton) {
		waitForElementVisible(driver,UserRegisterUI.DYNAMIC_BUTTON, textButton);
		return isElementDisplayed(driver, UserRegisterUI.DYNAMIC_BUTTON, textButton);
	}

	public boolean isDisableButtons(String textButton) {
		waitForElementVisible(driver,UserRegisterUI.DYNAMIC_BUTTON, textButton);
		return !isElementEnabled(driver, UserRegisterUI.DYNAMIC_BUTTON, textButton);
	}

	public CommonPO clickButtonLogo() {
		waitForElementClickable(driver, CommonsUI.LOGO);
		clickToElement(driver, CommonsUI.LOGO);
		return PageGeneratorManager.getCommonPO(driver);
	}

	public CommonPO clickPolicyTextLink() {
		waitForElementClickable(driver, UserRegisterUI.POLICY_TEXTLINK);
		clickToElement(driver, UserRegisterUI.POLICY_TEXTLINK);
		return PageGeneratorManager.getCommonPO(driver);
	}

	public UserLoginPO clickLoginTextLink() {
		waitForElementClickable(driver, UserRegisterUI.LOGIN_TEXTLINK);
		clickToElement(driver, UserRegisterUI.LOGIN_TEXTLINK);
		return PageGeneratorManager.getUserLogin(driver);
	}

	public void clickAgreeCheckbox() {
		waitForElementClickable(driver, UserRegisterUI.AGREE_CHECBOX);
		clickToElement(driver, UserRegisterUI.AGREE_CHECBOX);
	}

	public UserRegisterCA201PO clickMailButton(String textButton) {
		sleepInSecond(2);
		waitForElementClickable(driver, UserRegisterUI.DYNAMIC_BUTTON,textButton);
		clickToElement(driver, UserRegisterUI.DYNAMIC_BUTTON,textButton);
		return PageGeneratorManager.getUserRegisterCA201Page(driver);
	}

	
	
}
