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
import pageObject.CommonDrapDropPO;
import pageObject.UserHomePO;
import pageObject.UserLoginPO;
import testdata.UserDataMapper;
import utilities.Environment;

public class CommonDrapDrop extends BaseTest {
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
	public void TC01_Demo_Drap_Drop() {
		log.info("Open link");
		demoDrapDropPage = userHomePage.openPageDemo(GlobalConstants.DEV_FORM_EDIT);
		demoDrapDropPage.drapAndDropPosition("Email");
		
		log.info("Check display item in the menu");
		//Assert.assertEquals(demoDrapDropPage.getTitleTextMenu("メールアドレス"),"メールアドレス");
		Assert.assertEquals(demoDrapDropPage.getRequiredTextLabel(), "必須") ;
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
//		demoDrapDropPage.isDisplayTextLabeInputlMenu();
//		demoDrapDropPage.getValueInputMenu();
//		demoDrapDropPage.isDisplayTextLabelInputMenu();
//		demoDrapDropPage.getValueInputMenu();

		log.info("Check textlabel Title");
		log.info("Check placeholder Title");
		log.info("Check value Title");
	}
	@Test
	public void TC02_Click_On_Switch_Required() {
		log.info("Click on the Switch button");
		demoDrapDropPage.clickRequiredButton();
		log.info("Enable icon checked Switch button");
		verifyFalse(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		log.info("Check display text required in the Form");
		verifyTrue(demoDrapDropPage.checkDisplayTextRequiredForm(true));
		
		log.info("Check the Required button ");
		demoDrapDropPage.clickRequiredButton();
		log.info("Uncheck icon checked Switch button");
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		log.info("Check undisplay text required in the Form");
		verifyTrue(demoDrapDropPage.checkDisplayTextRequiredForm(false));
		
	}
	@Test
	public void TC_03_Check_change_value_Title_Component() {
		log.info("Check input Title component in the menu");
		demoDrapDropPage.inputValueComponentMenu("タイトル","Title Component");
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm("Title Component"));
		log.info("Check input email in the menu");
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト","a@gmail.com");
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm("a@gmail.com"));
		
	}
	@Test
	public void TC_04_Check_change_value_General_Explanation() {
		demoDrapDropPage.textareaValueComponentMenu("概要説明","概要説明dddd");
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm("概要説明dddd"));
		
		demoDrapDropPage.enterValueGeneralExForm("test general");
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明","test general"));
		
	}
	@Test
	public void TC_05_Check_change_value_Additional_Explanation() {
		demoDrapDropPage.textareaValueComponentMenu("補足説明","補足説明xxxxxxx");
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm("補足説明xxxxxxx"));
		demoDrapDropPage.enterValueAdditionalExForm("test Additional explanation");
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明","test Additional explanation"));
	}
	//@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private UserHomePO userHomePage;
	private UserLoginPO userLoginPage;
	private String emailValid, passValid,urlHomePage;
	UserDataMapper userData;
	private CommonDrapDropPO demoDrapDropPage;
}
