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
import pageObject.Login_ThirdPO;
import pageObject.UserHomePO;
import pageObject.UserLoginPO;
import pageObject.UserRestPWCA300PO;
import pageObject.UserRestPWCA302PO;
import testdata.UserDataMapper;
import utilities.DataHelper;

public class UserRestPW extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException {
		driver = getBrowserDriver(browserName);
		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		userRestPWCA300Page = userLoginPage.clickRestPW();
		emailInvalid = DataHelper.getDataHelper().getEmailAddress();
		emailWrongFormat = DataHelper.getDataHelper().getFirstName();
		userData = UserDataMapper.getUserData();
		emailValid = userData.getemailSuccess();
		emailThirdLogin = userData.getemailExist();
		emailErrorBlank = "必須項目です。";
		emailErrorInvalid = "このメールアドレスでSTACKアカウントは登録されていません";
		passThirdLogin = userData.getPassword();
		passwordNew = userData.getPasswordNew();
		urlNewResetPWCA301 = "auth/password/resend-reset-mail/?email";
		urlNewResetPWCA302 = "auth/password/re-new?expires";
		pwErrorBlank = "必須項目です。";
		pwErrorLessMore = "8の最小文字数文字以上32の最大文字数文字以下でご入力ください。";
		confirmPWpwErrorNodDup = "確認用パスワードが一致していません。";
		pwErrorWrong = "半角英数字（大文字小文字混在）、記号を組み合わせたものにしてください。";
		urlHomePage = "stack-product.com";
	}

	@Test
	public void CA300_01_Check_UI() {
		log.info("Check text title");
		verifyTrue(userRestPWCA300Page.isDisplayTitleText());
		log.info("Check text noti");
		Assert.assertEquals(userRestPWCA300Page.getNotiText(), "登録いただいたメールアドレスを入力し、パスワード再設定ボタンを押してください。");
		log.info("Check text label");
		Assert.assertEquals(userRestPWCA300Page.getTextLabel("email"), "メールアドレス");
		log.info("Check text placeholder");
		Assert.assertEquals(userRestPWCA300Page.getPlaceholderText("email"), "メールアドレス");
		log.info("Check text font-size");
		Assert.assertEquals(userRestPWCA300Page.getFontSizeTextTitle(), "20px");
		Assert.assertEquals(userRestPWCA300Page.getFontSizeTextNote(), "14px");
		Assert.assertEquals(userRestPWCA300Page.getFontSizeTextLabel("email"), "14px");
		log.info("Check color");
		Assert.assertEquals(userRestPWCA300Page.getColorTextTitle(), "#333D5A");
		Assert.assertEquals(userRestPWCA300Page.getColorTextLabel("email"), "#333D5A");
		log.info("Check text and status button");
		Assert.assertEquals(userRestPWCA300Page.getTextRestPwButton(), "パスワード再設定");

	}

	@Test
	public void CA300_02_Email_Blank() {
		log.info("Click button Rest Password");
		userRestPWCA300Page.clickRestPW();
		log.info("Verify bug");
		Assert.assertEquals(userRestPWCA300Page.getErrorRestPW(), emailErrorBlank);
	}

	@Test
	public void CA300_03_Email_Wrong_Format() {
		log.info("Input email");
		userRestPWCA300Page.inputValue("email", emailWrongFormat);
		log.info("Click button Rest Password");
		userRestPWCA300Page.clickRestPW();
		log.info("Verify bug");
		Assert.assertEquals(userRestPWCA300Page.getErrorRestPW(), emailErrorInvalid);
	}

	@Test
	public void CA300_04_Email_Invalid() {
		log.info("Input email");
		userRestPWCA300Page.inputValue("email", emailInvalid);
		log.info("Click button Rest Password");
		userRestPWCA300Page.clickRestPW();
		log.info("Verify bug");
		Assert.assertEquals(userRestPWCA300Page.getErrorRestPW(), emailErrorInvalid);
	}

	@Test
	public void CA300_05_Email_Success() {
		log.info("Input email");
		userRestPWCA300Page.inputValue("email", emailValid);
		log.info("Click button Rest Password");
		userRestPWCA300Page.clickRestPW();
		log.info("Check text title");
		verifyTrue(userRestPWCA300Page.isDisplayTitleText());
		log.info("Check text note");
		System.out.println(userRestPWCA300Page.getTextNoteCA301());
		Assert.assertEquals(userRestPWCA300Page.getTextNoteCA301(), "入力頂いたメールアドレスに宛に、パスワード再発行のメールを送信しましたので、ご確認ください。");
		log.info("Check url screen" + userRestPWCA300Page.getUrlScreenNewResetPW(driver));
		System.out.println(userRestPWCA300Page.getUrlScreenNewResetPW(driver));
		verifyTrue(userRestPWCA300Page.getUrlScreenNewResetPW(driver).contains(urlNewResetPWCA301));
	}

	@Test
	public void CA302_01_Check_Mail() {
		thirdLoginPage = userRestPWCA300Page.openBrowser();
		log.info("Input account Outlook");
		thirdLoginPage.enterValueLoginMicrosoft("email", emailThirdLogin);
		thirdLoginPage.clickSubmit();
		thirdLoginPage.enterValueLoginMicrosoft("password", passThirdLogin);
		thirdLoginPage.clickSubmit();
		thirdLoginPage.clickSubmit();
		log.info("Click url Email");
		thirdLoginPage.clickTabListEmail();
		userRestPWCA302Page = thirdLoginPage.clickUrlEmail("password/re-new?expires");
		log.info("Check url screen" + userRestPWCA302Page.getUrlScreen(driver));
		// System.out.println(userRestPWCA302Page.getUrlScreenRestPWCA302(driver));
		// verifyTrue(userRestPWCA302Page.getUrlScreenRestPWCA302(driver).contains(urlNewResetPWCA302));
	}

	@Test
	public void CA302_02_Check_UI() {
		log.info("Check text title");
		verifyTrue(userRestPWCA302Page.isDisplayTitleText());
		log.info("Check text label" + userRestPWCA302Page.getTextLabel("password"));
		Assert.assertEquals(userRestPWCA302Page.getTextLabel("password"), "新しいパスワード");
		log.info("Check text label" + userRestPWCA302Page.getTextLabel("passwordConfirm"));
		Assert.assertEquals(userRestPWCA302Page.getTextLabel("passwordConfirm"), "新しいパスワード（確認用）");
		log.info("Check text placeholder");
		Assert.assertEquals(userRestPWCA302Page.getPlaceholderText("password"), "半角英数字記号8文字以上32文字以下");
		Assert.assertEquals(userRestPWCA302Page.getPlaceholderText("passwordConfirm"), "半角英数字記号8文字以上32文字以下");
		log.info("Check text font-size");
		Assert.assertEquals(userRestPWCA302Page.getFontSizeTextTitle(), "20px");
		Assert.assertEquals(userRestPWCA302Page.getFontSizeTextLabel("password"), "14px");
		Assert.assertEquals(userRestPWCA302Page.getFontSizeTextLabel("passwordConfirm"), "14px");
		log.info("Check color");
		Assert.assertEquals(userRestPWCA302Page.getColorTextTitle(), "#333D5A");
		Assert.assertEquals(userRestPWCA302Page.getColorTextLabel("password"), "#333D5A");
		Assert.assertEquals(userRestPWCA302Page.getColorTextLabel("passwordConfirm"), "#333D5A");
		log.info("Check text and status button");
		Assert.assertEquals(userRestPWCA302Page.getTextRestPwButton(), "パスワードを設定");
	}

	@Test
	public void CA302_03_PW_BLANK() {
		log.info("Click button RestButton");
		userRestPWCA302Page.clickRestButton();
		log.info("Verify error blank");
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("password"), pwErrorBlank);
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("passwordConfirm"), pwErrorBlank);
	}

	@Test
	public void CA_302_04_PW_Less_8_32() {
		log.info("Input pw less 8 character");
		userRestPWCA302Page.inputValue("password", "Amela@1");
		userRestPWCA302Page.inputValue("passwordConfirm", "Amela@1");
		log.info("Verify error");
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("password"), pwErrorLessMore);
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("passwordConfirm"), pwErrorLessMore);
	}

	@Test
	public void CA_302_05_PW_Wrong() {
		log.info("Input pw wrong");
		userRestPWCA302Page.inputValue("password", "Amela123");
		userRestPWCA302Page.inputValue("passwordConfirm", "Amela123");
		log.info("Verify error");
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("password"), pwErrorWrong);
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("passwordConfirm"), pwErrorWrong);
		userRestPWCA302Page.inputValue("password", "mela123@");
		userRestPWCA302Page.inputValue("passwordConfirm", "mela123@");
		log.info("Verify error");
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("password"), pwErrorWrong);
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("passwordConfirm"), pwErrorWrong);
		userRestPWCA302Page.inputValue("password", "入力くmela123@");
		userRestPWCA302Page.inputValue("passwordConfirm", "入力くmela123@");
		log.info("Verify error");
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("password"), pwErrorWrong);
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("passwordConfirm"), pwErrorWrong);

	}

	@Test
	public void CA_302_06_ConfirmPW_No_Duplicate() {
		log.info("Input pw wrong");
		userRestPWCA302Page.inputValue("password", "Amela@123");
		userRestPWCA302Page.inputValue("passwordConfirm", "Amela123@");
		log.info("Verify error");
		Assert.assertEquals(userRestPWCA302Page.getErrorPW("passwordConfirm"), confirmPWpwErrorNodDup);

	}

	@Test
	public void CA_302_07_Rest_PW_Success() {
		log.info("Input pw wrong");
		userRestPWCA302Page.inputValue("password", passwordNew);
		userRestPWCA302Page.inputValue("passwordConfirm", passwordNew);
		log.info("Verify error");
		userRestPWCA302Page.clickRestButton();
		log.info("Check Url screen");
		userRestPWCA302Page.getUrlScreen(driver);
		log.info("Check log text note");
		verifyTrue(userRestPWCA302Page.getTextNoteCA303().contains("以降、新しいパスワードにてログインできます。"));
		verifyTrue(userRestPWCA302Page.getTextNoteCA303().contains("引き続きサービスをご利用ください。"));
		Assert.assertEquals(userRestPWCA302Page.getFontSizeTextNote(), "14px");
		verifyTrue(userRestPWCA302Page.isEnableButtonLogin());
		log.info("Click button Login");
		userLoginPage = userRestPWCA302Page.clickButtonLogin();
	}
	@Test
	public void CA_302_08_Login_NewPW() {
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passwordNew);
		log.info("Click button Submit");
		homePage = userLoginPage.clickSubmitButton();
		log.info("Open screen HomePage");
		System.out.println(homePage.getHomePageUrl(driver));
		verifyTrue(homePage.getHomePageUrl(driver).contains(urlHomePage));
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	WebDriver driver;
	private UserLoginPO userLoginPage;
	private UserRestPWCA300PO userRestPWCA300Page;
	private UserRestPWCA302PO userRestPWCA302Page;
	private UserHomePO homePage;
	UserDataMapper userData;
	private Login_ThirdPO thirdLoginPage;
	private String emailInvalid, emailValid, emailWrongFormat;
	private String emailErrorBlank, emailErrorInvalid;
	private String emailThirdLogin, passThirdLogin;
	private String urlNewResetPWCA301, urlNewResetPWCA302,urlHomePage;
	private String passwordNew;
	private String pwErrorBlank, pwErrorLessMore, confirmPWpwErrorNodDup, pwErrorWrong;
}
