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
import pageObject.DemoDrapDropPO;
import pageObject.UserHomePO;
import pageObject.UserLoginPO;
import testdata.UserDataMapper;
import utilities.Environment;

public class DemoDrapDrop extends BaseTest {
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
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		log.info("Click button Submit");
		userHomePage = userLoginPage.clickSubmitButton();
	
		
		
	}
	@Test
	public void Demo_Drap_Drop() {
		log.info("Open link");
		demoDrapDropPage = userHomePage.openPageDemo("https://form-build.dev.stack-product.com/survey/form-edit");
		demoDrapDropPage.drapAndDropPosition("email");
	}
	//@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private UserHomePO userHomePage;
	private UserLoginPO userLoginPage;
	private String emailValid, passValid,urlHomePage;
	UserDataMapper userData;
	private DemoDrapDropPO demoDrapDropPage;
}
