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
import testdata.UserFullNameFormMapper;
import utilities.Environment;

public class CF203_Full_Name extends BaseTest {
	private WebDriver driver;

	Environment environment;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException{
		driver = getBrowserDriver(browserName);
		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		passValid = "Amela@123";
		userData = UserDataMapper.getUserData();
		userFullNameForm = UserFullNameFormMapper.getUserFullNameForm();
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
	public void TC_01a_Check_UI_Default_Menu() {
		log.info("Open link");
		demoDrapDropPage = userHomePage.openPageDemo(GlobalConstants.DEV_FORM_EDIT);
		demoDrapDropPage.drapAndDropPosition("氏名（性名別）");
		
		log.info("Check the text title of the functional component in the menu");
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("氏名（性名別）"));
		
		log.info("Check display item in the menu");
		Assert.assertEquals(demoDrapDropPage.getRequiredTextLabel(), "必須") ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("表示設定")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("名前（タイトル）")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("姓")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("名")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("フリガナ（タイトル）")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("セイ")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("メイ")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("概要説明")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("補足説明")) ;
		
		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）","名前"));
		verifyTrue(demoDrapDropPage.isSelectRadiobutton("名前とフリガナを表示"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("姓","山田"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名","太郎"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）","名前（フリガナ）"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("セイ","ヤマダ"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("メイ","タロウ"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("概要説明","この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("補足説明","この項目の補足説明を入力"));
		
		log.info("Check color");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("氏名（性名別）"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("表示設定"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("名前（タイトル）"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("姓"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("名"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("フリガナ（タイトル）"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("セイ"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("メイ"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("概要説明"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorTexLabel("補足説明"),"#333D5A");
		log.info("Check font-size");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("氏名（性名別）"),"18px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("必須"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("表示設定"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("名前（タイトル）"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("姓"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("名"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("フリガナ（タイトル）"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("セイ"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("メイ"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("概要説明"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextLabel("補足説明"),"14px");
	}
	@Test
	public void TC_01b_Check_UI_Default_Form() {
		
		log.info("Check the default When entering the screen");
		Assert.assertEquals(demoDrapDropPage.checkValueNameTitleComponent(),"名前");
		verifyTrue(demoDrapDropPage.checkPlaceholderGeneralExForm("この項目の概要説明を入力"));
		
		verifyTrue(demoDrapDropPage.checkTextlableName("姓"));
		verifyTrue(demoDrapDropPage.checkTextlableName("名"));
		Assert.assertEquals(demoDrapDropPage.checkValueNameFuriganaTitleComponent(),"名前（フリガナ）");
		verifyTrue(demoDrapDropPage.checkTextlableName("セイ"));
		verifyTrue(demoDrapDropPage.checkTextlableName("メイ"));
		verifyTrue(demoDrapDropPage.checkPlaceholderAdditionalExForm("この項目の補足説明を入力"));
		
		log.info("Check the default display when entering the screen");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),"山田");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),"太郎");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),"ヤマダ");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),"タロウ");
		
		log.info("Check color");
		Assert.assertEquals(demoDrapDropPage.getColorFullNameForm(),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorNameForm("姓"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorNameForm("名"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorFuriganaForm(),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorNameForm("セイ"),"#333D5A");
		Assert.assertEquals(demoDrapDropPage.getColorNameForm("メイ"),"#333D5A");

		log.info("Check font-size");
		Assert.assertEquals(demoDrapDropPage.getFontSizeTextTitleForm(),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeNameTextForm("姓"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeNameTextForm("名"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeFuriganaTitle(),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeNameTextForm("セイ"),"14px");
		Assert.assertEquals(demoDrapDropPage.getFontSizeNameTextForm("メイ"),"14px");
		
	}
	
	@Test
	public void TC_02_Click_On_Switch_Required() {
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
	public void TC_03a_Check_Action_Select_Name_Radiobutton_Menu() {
		log.info("Click on the 名前のみ表示");
		demoDrapDropPage.clickNameRadiobutton("名前のみ表示");
		log.info("Check icon selected in the radiobutton 名前のみ表示");
		demoDrapDropPage.isSelectRadiobutton("名前のみ表示");
		
		log.info("Check the display when clicking the radio button for 名前のみ表示");
		Assert.assertEquals(demoDrapDropPage.getRequiredTextLabel(), "必須") ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("表示設定")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("名前（タイトル）")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("姓")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("名")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("概要説明")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("補足説明")) ;
		
		verifyTrue(demoDrapDropPage.isUnDisplayTitleTextLabelMenu("フリガナ（タイトル）")) ;
		verifyTrue(demoDrapDropPage.isUnDisplayTitleTextLabelMenu("セイ")) ;
		verifyTrue(demoDrapDropPage.isUnDisplayTitleTextLabelMenu("メイ")) ;
		
		
		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）","名前"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("姓","山田"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名","太郎"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("概要説明","この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("補足説明","この項目の補足説明を入力"));
		
	}
	@Test
	public void TC_03b_Check_Display_Item_Select_Name_Radiobutton_Form() {
		Assert.assertEquals(demoDrapDropPage.checkValueNameTitleComponent(),"名前");
		verifyTrue(demoDrapDropPage.checkPlaceholderGeneralExForm("この項目の概要説明を入力"));
		
		verifyTrue(demoDrapDropPage.checkTextlableName("姓"));
		verifyTrue(demoDrapDropPage.checkTextlableName("名"));
		verifyTrue(demoDrapDropPage.isUnDisplayNameFuriganaTitleComponent());
		verifyTrue(demoDrapDropPage.isUndisplayTextlableName("セイ"));
		verifyTrue(demoDrapDropPage.isUndisplayTextlableName("メイ"));
		verifyTrue(demoDrapDropPage.checkPlaceholderAdditionalExForm("この項目の補足説明を入力"));
		
		log.info("Check the default display when entering the screen");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),"山田");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),"太郎");
		verifyTrue(demoDrapDropPage.isUnDisplayValueNameCF203("セイ"));
		verifyTrue(demoDrapDropPage.isUnDisplayValueNameCF203("メイ"));
	}
	@Test
	public void TC_04a_Check_Action_Select_Name_Furigana_Radiobutton_Menu() {
		log.info("Click on the フリガナのみ表示");
		demoDrapDropPage.clickNameRadiobutton("フリガナのみ表示");
		log.info("Check icon selected in the radiobutton フリガナのみ表示");
		demoDrapDropPage.isSelectRadiobutton("フリガナのみ表示");
		
		log.info("Check the display when clicking the radio button for フリガナのみ表示");
		Assert.assertEquals(demoDrapDropPage.getRequiredTextLabel(), "必須") ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("表示設定")) ;
		verifyTrue(demoDrapDropPage.isUnDisplayTitleTextLabelMenu("名前（タイトル）")) ;
		verifyTrue(demoDrapDropPage.isUnDisplayTitleTextLabelMenu("姓")) ;
		verifyTrue(demoDrapDropPage.isUnDisplayTitleTextLabelMenu("名")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("概要説明")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("補足説明")) ;
		
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("フリガナ（タイトル）")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("セイ")) ;
		verifyTrue(demoDrapDropPage.isDisplayTitleTextLabelMenu("メイ")) ;
		
		
		log.info("Check the default When entering the screen");
		verifyTrue(demoDrapDropPage.checkStatusUnCheckRequiredSwitch());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）","名前（フリガナ）"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("セイ","ヤマダ"));
		verifyTrue(demoDrapDropPage.checkInputValueMenu("メイ","タロウ"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("概要説明","この項目の概要説明を入力"));
		verifyTrue(demoDrapDropPage.getPlaceholderTextarea("補足説明","この項目の補足説明を入力"));
		
	}
	@Test
	public void TC_04b_Check_Display_Item_Select_Name_Furigana_Radiobutton_Form() {
		verifyTrue(demoDrapDropPage.checkValueNameFuriTitle("名前（フリガナ）"));
		verifyTrue(demoDrapDropPage.checkPlaceholderGeneralExForm("この項目の概要説明を入力"));
		
		verifyTrue(demoDrapDropPage.isUndisplayTextlableName("姓"));
		verifyTrue(demoDrapDropPage.isUndisplayTextlableName("名"));
		
		verifyTrue(demoDrapDropPage.checkTextlableName("セイ"));
		verifyTrue(demoDrapDropPage.checkTextlableName("メイ"));
		verifyTrue(demoDrapDropPage.checkPlaceholderAdditionalExForm("この項目の補足説明を入力"));
		
		log.info("Check the default display when entering the screen");
		verifyTrue(demoDrapDropPage.isUnDisplayValueNameCF203("姓"));
		verifyTrue(demoDrapDropPage.isUnDisplayValueNameCF203("名"));
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),"ヤマダ");
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),"タロウ");
	}
	
	@Test
	public void TC_05_Check_Change_Value_FullName_Title() {
		log.info("Click on the 名前とフリガナを表示");
		demoDrapDropPage.clickNameRadiobutton("名前とフリガナを表示");
		log.info("Check icon selected in the radiobutton 名前とフリガナを表示");
		demoDrapDropPage.isSelectRadiobutton("名前とフリガナを表示");
		
		log.info("Check input FullName in the menu");
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(0).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(0).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(1).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(1).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(2).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(2).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(3).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(3).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(4).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(4).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(5).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(5).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(6).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(6).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(7).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(7).getfullNameTitle()));
		demoDrapDropPage.inputValueComponentMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(8).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFullNameForm(userFullNameForm.getTitleFullNames().get(8).getfullNameTitle()));
		
		log.info("Check enter value text Title FullName in the Form");
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(0).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(0).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(1).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(1).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(2).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(2).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(3).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(3).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(4).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(4).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(5).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(5).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(6).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(6).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(7).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(7).getfullNameTitle()));
		demoDrapDropPage.enterValueTitleFullNameInForm(userFullNameForm.getTitleFullNames().get(8).getfullNameTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("名前（タイトル）",userFullNameForm.getTitleFullNames().get(8).getfullNameTitle()));

	}
	@Test
	public void TC_06_Check_Change_LastName() {
		log.info("Check input LastName in the menu");
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(0).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(0).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(1).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(1).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(2).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(2).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(3).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(3).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(4).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(4).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(5).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(5).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(6).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(6).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(7).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(7).getlastName());
		demoDrapDropPage.inputValueComponentMenu("姓",userFullNameForm.getLastNameInputs().get(8).getlastName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("姓"),userFullNameForm.getLastNameInputs().get(8).getlastName());
	
	}
	@Test
	public void TC_07_Check_Change_FirstName() {
		log.info("Check input LastName in the menu");
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(0).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(0).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(1).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(1).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(2).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(2).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(3).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(3).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(4).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(4).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(5).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(5).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(6).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(6).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(7).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(7).getfirstName());
		demoDrapDropPage.inputValueComponentMenu("名",userFullNameForm.getfirstNameInputs().get(8).getfirstName());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("名"),userFullNameForm.getfirstNameInputs().get(8).getfirstName());
	
	}
	@Test
	public void TC_08_Check_Change_FullName_Furigana_Title() {
		log.info("Check input FullName in the menu");
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(0).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(0).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(1).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(1).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(2).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(2).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(3).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(3).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(4).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(4).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(5).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(5).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(6).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(6).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(7).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(7).getFuriganaTitle()));
		demoDrapDropPage.inputValueComponentMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(8).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkChangeValueFuriganaForm(userFullNameForm.getTitleFuriganaInputs().get(8).getFuriganaTitle()));
		
		log.info("Check enter value text Title FullName Furigana in the Form");
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(0).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(0).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(1).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(1).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(2).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(2).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(3).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(3).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(4).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(4).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(5).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(5).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(6).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(6).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(7).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(7).getFuriganaTitle()));
		demoDrapDropPage.enterValueTitleFuriganaInForm(userFullNameForm.getTitleFuriganaInputs().get(8).getFuriganaTitle());
		verifyTrue(demoDrapDropPage.checkInputValueMenu("フリガナ（タイトル）",userFullNameForm.getTitleFuriganaInputs().get(8).getFuriganaTitle()));
	}
	@Test
	public void TC_09_Check_Change_LastName_Furigana() {
		log.info("Check input LastName in the menu");
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(0).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(0).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(1).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(1).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(2).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(2).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(3).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(3).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(4).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(4).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(5).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(5).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(6).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(6).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(7).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(7).getLastNameFuri());
		demoDrapDropPage.inputValueComponentMenu("セイ",userFullNameForm.getLastNameFuriInputs().get(8).getLastNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("セイ"),userFullNameForm.getLastNameFuriInputs().get(8).getLastNameFuri());
	
	}
	@Test
	public void TC_10_Check_Change_FirstName_Furigana() {
		log.info("Check input LastName in the menu");
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(0).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(0).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(1).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(1).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(2).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(2).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(3).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(3).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(4).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(4).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(5).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(5).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(6).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(6).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(7).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(7).getfirstNameFuri());
		demoDrapDropPage.inputValueComponentMenu("メイ",userFullNameForm.getfirstNameFurriInputs().get(8).getfirstNameFuri());
		Assert.assertEquals(demoDrapDropPage.getValueNameCF203("メイ"),userFullNameForm.getfirstNameFurriInputs().get(8).getfirstNameFuri());
	
	}
	
	@Test
	public void TC_11_Check_change_value_General_Explanation() {
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
	public void TC_12_Check_change_value_Additional_Explanation() {
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
	UserFullNameFormMapper userFullNameForm;
}
