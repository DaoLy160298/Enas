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
import testdata.UserFormMapper;
import utilities.Environment;

public class CF305_EnterTextMultiLine extends BaseTest {
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
		userForm = UserFormMapper.getUserForm();
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		log.info("Click button Submit");
		userHomePage = userLoginPage.clickSubmitButton();
		
	}
	@Test
	public void TC01a_Check_UI_Menu() {
		log.info("Open link");
		demoDrapDropPage = userHomePage.openPageDemo(GlobalConstants.DEV_FORM_EDIT);
		demoDrapDropPage.drapAndDropPosition("テキスト入力(複数行)");
		log.info("Check the text title of the functional component in the menu");
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("テキスト入力(複数行)"));
		
		log.info("Check display item in the menu");
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("タイトル"));
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("サンプルテキスト"));
		Assert.assertEquals(demoDrapDropPage.getRequiredTextLabel(), "必須") ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("概要説明")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("補足説明")) ;
		
		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル","テキスト入力(複数行)"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("サンプルテキスト",""));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("概要説明","この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("補足説明","この項目の補足説明を入力"));
		
		log.info("Check color");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("テキスト入力(複数行)"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("タイトル"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("必須"),"#333D5A");
//		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("サンプルテキスト"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("概要説明"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("補足説明"),"#333D5A");
		log.info("Check font-size");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("テキスト入力(複数行)"),"18px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("タイトル"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("必須"),"14px");
//		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("サンプルテキスト"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("概要説明"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("補足説明"),"14px");
	}
	@Test
	public void TC01b_Check_UI_Form() {
		
		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm("テキスト入力(複数行)"));
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(""));
		verifyTrue(demoDrapDropPage.checkPlaceholderGeneralExForm("この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.checkPlaceholderAdditionalExForm("この項目の補足説明を入力"));
		
		log.info("Check color");
		Assert.assertEquals(demoDrapDropPage.getColorTitleComponentForm(),"#333D5A");
//		Assert.assertEquals(demoDrapDropPage.getColorSampleTextareaForm(),"#C0C3CC");
//		Assert.assertEquals(demoDrapDropPage.getColorGeneralExForm(),"#C0C3CC");
//		Assert.assertEquals(demoDrapDropPage.getColorAdditionalExForm(),"#C0C3CC");
		log.info("Check font-size");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextTitleForm(),"14px");
//		Assert.assertEquals(demoDrapDropPage.getFontSizeSampleTextareaForm(),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeGeneralExForm(),"12px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeAdditionalExForm(),"12px");
		Assert.assertEquals(demoDrapDropPage.getTextCountCharacters(),"文字数 500文字以内");
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
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(0).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(0).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(1).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(1).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(2).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(2).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(3).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(3).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(4).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(4).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(5).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(5).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(6).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(6).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(7).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(7).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル",userForm.getTitleComponents().get(8).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm(userForm.getTitleComponents().get(8).getTitleComponentText()));
		
		log.info("Check enter value text Title component in the Form");
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(0).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(0).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(1).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(1).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(2).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(2).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(3).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(3).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(4).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(4).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(5).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(5).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(6).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(6).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(7).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(7).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(8).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",userForm.getTitleComponents().get(8).getTitleComponentText()));

	}
	@Test
	public void TC_04_Check_change_value_Sample_Explanation() {
		log.info("Check input sample text in the menu");
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(0).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(0).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(1).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(1).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(2).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(2).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(3).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(3).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(4).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(4).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(5).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(5).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(6).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(6).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(7).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(7).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト",userForm.getSampleTexts().get(8).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextareaForm(userForm.getSampleTexts().get(8).getSampleText()));
	}
	@Test
	public void TC_05_Check_change_value_General_Explanation() {
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(0).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(0).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(1).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(1).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(2).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(2).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(3).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(3).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(4).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(4).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(5).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(5).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(6).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(6).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(7).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(7).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",userForm.getGeneralExplantions().get(8).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkValueGeneralExForm(userForm.getGeneralExplantions().get(8).getGeneralExplantion()));
		
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(0).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(0).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(1).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(1).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(2).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(2).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(3).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(3).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(4).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(4).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(5).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(5).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(6).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(6).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(7).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(7).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(8).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",userForm.getGeneralExplantions().get(8).getGeneralExplantion()));
		
	}
	@Test
	public void TC_06_Check_change_value_Additional_Explanation() {
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(0).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(0).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(1).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(1).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(2).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(2).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(3).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(3).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(4).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(4).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(5).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(5).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(6).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(6).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(7).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(7).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",userForm.getAdditionalExplantions().get(8).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(8).getAdditionalExplantion()));
		
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(0).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(0).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(1).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(1).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(2).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(2).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(3).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(3).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(4).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(4).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(5).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(5).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(6).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(6).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(7).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(7).getAdditionalExplantion()));
		demoDrapDropPage.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(8).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",userForm.getAdditionalExplantions().get(8).getAdditionalExplantion()));
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private UserHomePO userHomePage;
	private UserLoginPO userLoginPage;
	private String emailValid, passValid,urlHomePage;
	UserDataMapper userData;
	private CommonDrapDropPO demoDrapDropPage;
	UserFormMapper userForm;
}
