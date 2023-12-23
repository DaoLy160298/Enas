package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CommonsUI;

public class CommonPO extends BasePage{
	public WebDriver driver;

	public CommonPO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterCA200PO clickBackBrowser() {
		backToPage(driver);
		return PageGeneratorManager.getUserRegisterCA200Page(driver);
	}

	public String getUrlPage(WebDriver driver) {
		return getPageUrl(driver);
	}



	
	
}
