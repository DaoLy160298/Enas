package ProjectEnas;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.UserRestPWCA300PO;
import pageObject.UserHomePO;
import pageObject.UserLoginPO;
import utilities.DataHelper;

public class UserLogin extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException {
		driver = getBrowserDriver(browserName);
		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		txtLabelEmail = "メールアドレス";
		txtLabelPW = "パスワード";
		txtLoginButton = "ログイン";
		urlRestPWPage = "/auth/password/reset/";
		passValid = "Amela@123";
		emailValid = "testamela21@gmail.com";
		passwordInvalid = DataHelper.getDataHelper().getPassword();
		emailInvalid = DataHelper.getDataHelper().getEmailAddress();
		errorBlank = "必須項目です。";
		errorInvalid = "メールアドレス、またはパスワードが違います。再度確認し、ご入力ください。";
		urlHomePage = "stack-product.com";
	}

	@Test
	public void CA000_01_CheckUI() {
		log.info("Check text label");
		Assert.assertEquals(userLoginPage.getTextLabel("email"), txtLabelEmail);
		Assert.assertEquals(userLoginPage.getTextLabel("password"), txtLabelPW);
		log.info("Check placeholder");
		Assert.assertEquals(userLoginPage.getTextPlaceholder("email"), "メールアドレス");
		Assert.assertEquals(userLoginPage.getTextPlaceholder("password"), "半角英数字記号8文字以上");
		log.info("Check color, font-size input");
		Assert.assertEquals(userLoginPage.getFontSizeTextLabel("email"), "14px");
		Assert.assertEquals(userLoginPage.getFontSizeTextLabel("password"), "14px");
		Assert.assertEquals(userLoginPage.getColorTextLabel("email"), "#333D5A");
		Assert.assertEquals(userLoginPage.getColorTextLabel("password"), "#333D5A");
		log.info("Check text and status button");
		Assert.assertEquals(userLoginPage.getTextSubmitButton(), txtLoginButton);
		verifyTrue(userLoginPage.isSubmitButtonEnable());
	}

	@Test
	public void CA000_02_Check_TextLink() {
		log.info("Check texlink Rest PW");
		assertTrue(userLoginPage.isDisplayRestPWTextLink());
		log.info("Check click textlink Rest PW");
		restPasswordPage = userLoginPage.clickRestPW();
		log.info("Check link url screen RestPW"+ restPasswordPage.getUrlTextRestPW(driver));
		verifyTrue(restPasswordPage.getUrlTextRestPW(driver).contains(urlRestPWPage));
		log.info("Check text button Google Login");
		userLoginPage = restPasswordPage.getBackBrowser();

		log.info("Check text button Facebook Login");

		log.info("Check text button Microsoft Login");
	}

	@Test
	public void CA000_03_Email_Blank() {
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		log.info("Click button Submit");
		userLoginPage.clickSubmitButton();
		log.info("Verify error Email");
		Assert.assertEquals(userLoginPage.getTextErrorBlank("email"), errorBlank);
	}

	@Test
	public void CA000_04_Password_Blank() {
		log.info("Clear value Password input");
		userLoginPage.clearValue("password");
		log.info("Input value Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Verify error Password");
		Assert.assertEquals(userLoginPage.getTextErrorBlank("password"), errorBlank);
	}

	@Test
	public void CA000_05_Email_InValid() {
		log.info("Input InValid Email");
		userLoginPage.inputValid("email", emailInvalid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		log.info("Click button Submit");
		userLoginPage.clickSubmitButton();
		log.info("Verify error");
		Assert.assertEquals(userLoginPage.getErrorInvalid(), errorInvalid);
	}

	@Test
	public void CA000_06_Password_InValid() {
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passwordInvalid);
		log.info("Click button Submit");
		userLoginPage.clickSubmitButton();
		log.info("Verify error");
		Assert.assertEquals(userLoginPage.getErrorInvalid(), errorInvalid);
	}

	@Test
	public void CA000_07_Login_Success() {
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		log.info("Click button Submit");
		homePage = userLoginPage.clickSubmitButton();
		log.info("Open screen HomePage");
		System.out.println(homePage.getHomePageUrl(driver));
		verifyTrue(homePage.getHomePageUrl(driver).contains(urlHomePage) );
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	private UserLoginPO userLoginPage;
	private UserRestPWCA300PO restPasswordPage;
	private UserHomePO homePage;
	private String txtLabelEmail, txtLabelPW, txtLoginButton;
	private String urlRestPWPage, urlHomePage;
	private String emailValid, passValid;
	private String emailInvalid, passwordInvalid;
	private String errorBlank, errorInvalid;
}
