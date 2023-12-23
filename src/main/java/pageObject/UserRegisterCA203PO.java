package pageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CommonsUI;
import pageUIs.UserRegisterUI;
import pageUIs.UserRestPWUI;

public class UserRegisterCA203PO extends BasePage {
	public WebDriver driver;

	public UserRegisterCA203PO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayTitleText() {
		waitForElementVisible(driver, UserRegisterUI.TITLE_CA203_TEXT);
		return isElementDisplayed(driver, UserRegisterUI.TITLE_CA203_TEXT);
	}

	public void inputValueCA203(String typeInput, String value) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_INPUT_CA203, typeInput);
		sendkeyToElement(driver, UserRegisterUI.DYNAMIC_INPUT_CA203, value, typeInput);
	}

	public void selectValueDropdown(String typeDropdown, String value) {
		clickToElement(driver, UserRegisterUI.DYNAMIC_DROPDOWN_INPUT_CA203, typeDropdown);
		// Chọn giá trị trong dropdown
		clickToElement(driver, UserRegisterUI.DYNAMIC_DROPDOWN_VALUE_CA203, value);

	}

	public void ChoseValueRadiobutton(String typeRadioButton) {
		waitForElementClickable(driver, UserRegisterUI.DYNAMIC_ICON_RADIOBUTTON_CA203, typeRadioButton);
		clickToElement(driver, UserRegisterUI.DYNAMIC_ICON_RADIOBUTTON_CA203, typeRadioButton);

	}

	public void clickNextButtonOrCompleteButton(String nameButton) {
		waitForElementClickable(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
		clickToElement(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
	}

	public String getTextLabel(String nameLabel) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXTLABEL_CA203, nameLabel);
		return getElementText(driver, UserRegisterUI.DYNAMIC_TEXTLABEL_CA203, nameLabel);
	}

	public String getPlaceholder(String nameLabel) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_PLACEHOLDER_CA203, nameLabel);
		return getElementAttribute(driver, UserRegisterUI.DYNAMIC_PLACEHOLDER_CA203, "placeholder", nameLabel);
	}

	public String getForSizeTextLabel(String nameLabel) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXTLABEL_CA203, nameLabel);
		return getFontSize(driver, UserRegisterUI.DYNAMIC_TEXTLABEL_CA203, nameLabel);
	}

	public String getColorTextLabel(String nameLabel) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_TEXTLABEL_CA203, nameLabel);
		return getHexaColorFromRGBA(getColor(driver, UserRegisterUI.DYNAMIC_TEXTLABEL_CA203, nameLabel)).toUpperCase();
	}

	public String getForSizeButton(String nameButton) {
		waitForElementVisible(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
		return getFontSize(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
	}

	public String getColorButton(String nameButton) {
		waitForElementVisible(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
		return getHexaColorFromRGBA(getColor(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton)).toUpperCase();
	}

	public String getUrlSuccess() {
		sleepInSecond(2);
		return getPageUrl(driver);

	}

	public String getTextNotiSuccess() {
		waitForElementVisible(driver, UserRegisterUI.NOTI_SUCESS_TEXT1);
		waitForElementVisible(driver, UserRegisterUI.NOTI_SUCESS_TEXT2);
		return getElementText(driver, UserRegisterUI.NOTI_SUCESS_TEXT1)
				.concat(getElementText(driver, UserRegisterUI.NOTI_SUCESS_TEXT2));

	}

	public UserHomePO clickButtonRedirectHomePage(String nameButton) {
		waitForElementClickable(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
		clickToElement(driver, UserRegisterUI.NEXT_OR_COMPLETE_BUTTON, nameButton);
		return PageGeneratorManager.getHomePage(driver);
	}

	public void checkIconLoading() {
		waitForElementVisible(driver, CommonsUI.LOADING_ICON);

	}

	public String getPlaceholderSiteType() {
		waitForElementVisible(driver, UserRegisterUI.SITE_TYPE_PLACEHOLDER_CA203);
		return getElementText(driver, UserRegisterUI.SITE_TYPE_PLACEHOLDER_CA203);
	}

	public String getTextErrorCA203(String nameInput) {
		waitForElementVisible(driver, UserRegisterUI.DYNAMIC_MEMBERSHIP_ERROR_TEXT, nameInput);
		return getElementText(driver, UserRegisterUI.DYNAMIC_MEMBERSHIP_ERROR_TEXT, nameInput);
	}

	public boolean isUnDisplayErrorCA203(String nameInput) {
//		waitForElementUndisplayed(driver, UserRegisterUI.DYNAMIC_MEMBERSHIP_ERROR_TEXT, nameInput);
		sleepInSecond(2);
		return isElementUndisplayed(driver, UserRegisterUI.DYNAMIC_MEMBERSHIP_ERROR_TEXT, nameInput);

	}

	public void selectClickSecordTimes(String valueParent,String valueChildren,String value) {
//		clickToElement(driver, UserRegisterUI.DYNAMIC_SECONDS_TIMES_DROPDOWN, typeDropdown);
//		// Chọn giá trị trong dropdown
//		clickToElement(driver, UserRegisterUI.DYNAMIC_DROPDOWN_VALUE_CA203, value);
		selectItemInCustomDropdown(driver, UserRegisterUI.DYNAMIC_SECONDS_TIMES_DROPDOWN,valueParent,UserRegisterUI.DYNAMIC_DROPDOWN_VALUE_CA203,valueChildren, value);
	}

	public void clickOutInput(String typeInput) {
		hoverMouseToElement(driver, UserRegisterUI.DYNAMIC_INPUT_CA203, typeInput);
		sleepInSecond(2);
	}

}
