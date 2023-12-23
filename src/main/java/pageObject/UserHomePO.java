package pageObject;

import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.tokens.FlowEntryToken;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserHomePageUI;

public class UserHomePO extends BasePage{
	public WebDriver driver;
	

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayTitleText(String valueTitle) {
		waitForAllElementVisible(driver, UserHomePageUI.FORM_TITLE_TEXT,valueTitle);
		return isElementDisplayed(driver, UserHomePageUI.FORM_TITLE_TEXT,valueTitle);
	}

	public boolean isDisplayButton(String textButton) {
		waitForAllElementVisible(driver, UserHomePageUI.FORM_BUTTON,textButton);
		return isElementDisplayed(driver,UserHomePageUI.FORM_BUTTON,textButton);
	}

	public String getHomePageUrl(WebDriver driver) {
		sleepInSecond(3);
		return getPageUrl(driver);
	}

	public DemoDrapDropPO openPageDemo(String url) {
		sleepInSecond(5);
		openNewTab(driver, url);
		return PageGeneratorManager.getDemoDrapDropPage(driver);
	}

}
