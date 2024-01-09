package ProjectEnas;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class CF306_SelectImage extends BaseTest {
	private WebDriver driver;

	Environment environment;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException {
		driver = getBrowserDriver(browserName);
		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		passValid = "Amela@123";
		userData = UserDataMapper.getUserData();
		emailValid = userData.getemailSuccess();
		userForm = UserFormMapper.getUserForm();
		times = 3;
//		String imgString = "D:/TaiLieu/DuAn/ENASPROJECT/DataTest/anh6MB.jpg";
		log.info("Input Valid Email");
		userLoginPage.inputValid("email", emailValid);
		log.info("Input value Password");
		userLoginPage.inputValid("password", passValid);
		log.info("Click button Submit");
		userHomePage = userLoginPage.clickSubmitButton();

	}

	@Test
	public void TC_01a_Check_UI_Menu() {
		log.info("Open link");
		demoDrapDropPage = userHomePage.openPageDemo(GlobalConstants.DEV_FORM_EDIT);
		demoDrapDropPage.drapAndDropPosition("画像選択");
		log.info("Check the text title of the functional component in the menu");
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("画像選択"));

		log.info("Check display item in the menu");
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("画像選択"));
		Assert.assertEquals(demoDrapDropPage.getRequiredTextLabel(), "必須");
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("タイトル"));
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("概要説明"));
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("補足説明"));
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("選択形式"));
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("選択肢"));
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("並び替え"));
//		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("選択肢追加"));
		log.info("Check default number of input Option");
		Assert.assertEquals(demoDrapDropPage.getCountInputOptionMenu(), 3);

		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル", "画像選択"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("概要説明", "この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("補足説明", "この項目の補足説明を入力"));
		verifyTrue(demoDrapDropPage.isSelectRadiobutton("ボタン（単一選択）"));
		log.info("Check default value of input: Option");
		Assert.assertEquals(demoDrapDropPage.getCountInputOptionMenu(), 3);

		log.info("Check color");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("画像選択"), "#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("必須"), "#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("タイトル"), "#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("概要説明"), "#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("補足説明"), "#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("選択肢"), "#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("並び替え"), "#4770EA");
//		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("選択肢追加"),"##4770EA");

		log.info("Check font-size");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("画像選択"), "18px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("必須"), "14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("タイトル"), "14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("概要説明"), "14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("補足説明"), "14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("選択形式"), "14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("選択肢"), "14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("並び替え"), "14px");
//		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("選択肢追加"),"14px");
	}

	@Test
	public void TC01b_Check_UI_Form() {

		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkChangeValueTitleForm("画像選択"));
		verifyTrue(demoDrapDropPage.checkPlaceholderGeneralExForm("この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.checkPlaceholderAdditionalExForm("この項目の補足説明を入力"));
		verifyTrue(demoDrapDropPage.numberPhotoFrame(3));
		verifyTrue(demoDrapDropPage.numberValueOptionForm(3));

		log.info("Check color");
		Assert.assertEquals(demoDrapDropPage.getColorTitleComponentForm(), "#333D5A");

		log.info("Check font-size");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextTitleForm(), "14px");

		Assert.assertEquals(demoDrapDropPage.getFontSizeGeneralExForm(), "12px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeAdditionalExForm(), "12px");
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
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(0).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(0).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(1).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(1).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(2).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(2).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(3).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(3).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(4).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(4).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(5).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(5).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(6).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(6).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(7).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(7).getTitleComponentText()));
		demoDrapDropPage.inputValueComponentMenu("タイトル", userForm.getTitleComponents().get(8).getTitleComponentText());
		verifyTrue(demoDrapDropPage
				.checkChangeValueTitleForm(userForm.getTitleComponents().get(8).getTitleComponentText()));

		log.info("Check enter value text Title component in the Form");
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(0).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(0).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(1).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(1).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(2).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(2).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(3).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(3).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(4).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(4).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(5).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(5).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(6).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(6).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(7).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(7).getTitleComponentText()));
		demoDrapDropPage.enterValueTitleInForm(userForm.getTitleComponents().get(8).getTitleComponentText());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("タイトル",
				userForm.getTitleComponents().get(8).getTitleComponentText()));

	}

	@Test
	public void TC_04_Check_change_value_Sample_Explanation() {
		log.info("Check input sample text in the menu");
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(0).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(0).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(1).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(1).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(2).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(2).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(3).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(3).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(4).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(4).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(5).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(5).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(6).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(6).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(7).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(7).getSampleText()));
		demoDrapDropPage.inputValueComponentMenu("サンプルテキスト", userForm.getSampleTexts().get(8).getSampleText());
		verifyTrue(demoDrapDropPage.checkValueSampleTextForm(userForm.getSampleTexts().get(8).getSampleText()));
	}

	@Test
	public void TC_05_Check_change_value_General_Explanation() {
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(0).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(0).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(1).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(1).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(2).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(2).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(3).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(3).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(4).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(4).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(5).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(5).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(6).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(6).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(7).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(7).getGeneralExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("概要説明",
				userForm.getGeneralExplantions().get(8).getGeneralExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueGeneralExForm(userForm.getGeneralExplantions().get(8).getGeneralExplantion()));

		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(0).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(0).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(1).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(1).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(2).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(2).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(3).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(3).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(4).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(4).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(5).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(5).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(6).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(6).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(7).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(7).getGeneralExplantion()));
		demoDrapDropPage.enterValueGeneralExForm(userForm.getGeneralExplantions().get(8).getGeneralExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("概要説明",
				userForm.getGeneralExplantions().get(8).getGeneralExplantion()));

	}

	@Test
	public void TC_06_Check_change_value_Additional_Explanation() {
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(0).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(0).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(1).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(1).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(2).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(2).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(3).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(3).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(4).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(4).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(5).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(5).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(6).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(6).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(7).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(7).getAdditionalExplantion()));
		demoDrapDropPage.textareaValueComponentMenu("補足説明",
				userForm.getAdditionalExplantions().get(8).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage
				.checkValueAdditionalExForm(userForm.getAdditionalExplantions().get(8).getAdditionalExplantion()));

		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(0).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(0).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(1).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(1).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(2).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(2).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(3).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(3).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(4).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(4).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(5).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(5).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(6).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(6).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(7).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(7).getAdditionalExplantion()));
		demoDrapDropPage
				.enterValueAdditionalExForm(userForm.getAdditionalExplantions().get(8).getAdditionalExplantion());
		verifyTrue(demoDrapDropPage.checkTextareaValueTextareaMenu("補足説明",
				userForm.getAdditionalExplantions().get(8).getAdditionalExplantion()));
	}

	@Test
	public void TC_07_Check_Enter_Option_Input() {
		log.info("Check input Field text in the menu");
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(0).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(0).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(1).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(1).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(2).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(2).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(3).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(3).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(4).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(4).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(5).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(5).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(6).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(6).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(7).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(7).getSampleText()));
		demoDrapDropPage.inputValueOptionCF306(userForm.getSampleTexts().get(8).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Form(userForm.getSampleTexts().get(8).getSampleText()));
		demoDrapDropPage.clickOptionForm();
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(0).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(0).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(1).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(1).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(2).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(2).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(3).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(3).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(4).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(4).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(5).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(5).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(6).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(6).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(7).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(7).getSampleText()));
		demoDrapDropPage.inputValueCF306Form(userForm.getSampleTexts().get(8).getSampleText());
		verifyTrue(demoDrapDropPage.isCompareValueCF306Menu(userForm.getSampleTexts().get(8).getSampleText()));

	}

	@Test
	public void TC_08_Check_Create_Input_Field() {
		log.info("Click on the button 項目追加 so lan la: " + times);
		demoDrapDropPage.clickButtonCreateInputField("選択肢追加", times);
		log.info("Check number of input Field");
		verifyTrue(demoDrapDropPage.checkNumberInputOptionCF306(times));
		log.info("Check number of image in Form");
		verifyTrue(demoDrapDropPage.checkNumberInputOptionCF306(times));
	}

	@Test
	public void TC_09_Check_Choose_Checkbox() {
		log.info("Click on the ボタン（複数選択）");
		demoDrapDropPage.clickNameRadiobutton("ボタン（複数選択）");
		log.info("Check icon selected in the radiobutton ボタン（複数選択）");
		demoDrapDropPage.isSelectRadiobutton("ボタン（複数選択）");
		log.info("Check format checkbox in form");
		verifyTrue(demoDrapDropPage.checkFormatCheckboxCF306());

	}

	@Test
	public void TC_10_Upload_Image_Success() {
		demoDrapDropPage.uploadImg(beachFileBatch);
		log.info("Check file upload success");
		verifyTrue(demoDrapDropPage.isDisplayImage());
	}
	@Test
	public void TC_11_Upload_Image_Fail() {
		demoDrapDropPage.uploadImg(imageGreaterThan10MBBatch);
		log.info("Check display text error");
		verifyTrue(demoDrapDropPage.isDisplayToasError());
		demoDrapDropPage.uploadImg(imageFormatIncorrecBatch);
		log.info("Check display text error");
		verifyTrue(demoDrapDropPage.isDisplayToasError());
	}
	@Test
	public void TC_12_Check_Delete_Input() {
		int valueBeforDelete = demoDrapDropPage.countInputCF306();
		demoDrapDropPage.clickDelteFirstInput("delete");
		log.info("Check count input after deletion");
		int valueAfterDelete = demoDrapDropPage.countInputAfterDeleteCF306();
		 Assert.assertEquals(valueBeforDelete - valueAfterDelete, 1, "Input count should decrease by 1 after deletion");
		
	}

	// @AfterClass
	public void afterClass() {
		driver.quit();
	}

	private UserHomePO userHomePage;
	private UserLoginPO userLoginPage;
	private String emailValid, passValid;
	UserDataMapper userData;
	private CommonDrapDropPO demoDrapDropPage;
	UserFormMapper userForm;
	private String imgString;
	String beachFileName = "beach.jpg";
	String imageGreaterThan10MBName = "anh10MB.jpg";
	String imageFormatIncorrectName = "anh.heic";
	String projectPath = System.getProperty("user.dir");
	String beachFileBatch = projectPath + "\\UploadFileImg\\" + beachFileName;
	String imageGreaterThan10MBBatch = projectPath + "\\UploadFileImg\\" + imageGreaterThan10MBName;
	String imageFormatIncorrecBatch = projectPath + "\\UploadFileImg\\" + imageFormatIncorrectName;
	private int times;
}
