package ProjectEnas;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.UserHomePO;
import pageObject.UserLoginPO;
import testdata.UserDataMapper;
import utilities.Environment;

public class UserHomePage extends BaseTest {
	private WebDriver driver;

	Environment environment;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException{
		driver = getBrowserDriver(browserName);
		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		passValid = "Amela@123";
		userData = UserDataMapper.getUserData();
		emailValid = userData.getemailSuccess();
		urlHomePage = "-product.com";
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		
		log.info("Click button Submit");
		userHomePage = userLoginPage.clickSubmitButton();
	
	}
	@Test
	public void HomePage_01_CheckUI() {
		System.out.println("Link url "+userHomePage.getHomePageUrl(driver));
		verifyTrue(userHomePage.getHomePageUrl(driver).contains(urlHomePage));
		log.info("Get text title");
		userHomePage.isDisplayTitleText("Web接客型フォーム");
		userHomePage.isDisplayTitleText("A/Bテストと最適化");
		userHomePage.isDisplayTitleText("マーケティング分析");
		log.info("Get text button");
		userHomePage.isDisplayButton("Web接客型フォームを開く");
		userHomePage.isDisplayButton("A/Bテストと最適化を開く");
		userHomePage.isDisplayButton("マーケティング分析を開く");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private UserHomePO userHomePage;
	private UserLoginPO userLoginPage;
	private String emailValid, passValid,urlHomePage;
	UserDataMapper userData;
	
}
