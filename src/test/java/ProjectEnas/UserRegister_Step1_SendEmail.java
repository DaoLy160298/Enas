package ProjectEnas;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.CommonPO;
import pageObject.UserLoginPO;
import pageObject.UserRegisterCA200PO;
import pageObject.UserRegisterCA201PO;
import testdata.UserDataMapper;
import utilities.AccountUserData;
import utilities.CSVDataReader;

public class UserRegister_Step1_SendEmail extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException {
		driver = getBrowserDriver(browserName);
		userData = UserDataMapper.getUserData();

		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		log.info("Click text link Create account");
		userRegisterCA200Page = userLoginPage.clickCreateAccountLink();
		
	}

	@Test
	public void CA200_01_CheckUI() {
		log.info("Verify text title");
		userRegisterCA200Page.isDisplayTextTitleCA200();
		log.info("Check color, font-size");
		Assert.assertEquals(userRegisterCA200Page.getColorTitleCAS200(), "#333D5A");
		Assert.assertEquals(userRegisterCA200Page.getFontSizeTitleCA200(), "20px");
		log.info("Check text link 個人情報保護方針");
		Assert.assertEquals(userRegisterCA200Page.getAgreeTextLink(), "個人情報保護方針に同意する");
		log.info("Check text buttons default");
		userRegisterCA200Page.isDisplayclickButtons("メールアドレスで登録");
		userRegisterCA200Page.isDisplayclickButtons("Googleアカウントでログイン");
		userRegisterCA200Page.isDisplayclickButtons("Facebookアカウントでログイン");
		userRegisterCA200Page.isDisplayclickButtons("Microsoftアカウントでログイン");
		log.info("Check button disable");
		userRegisterCA200Page.isDisableButtons("メールアドレスで登録");
		userRegisterCA200Page.isDisableButtons("Googleアカウントでログイン");
		userRegisterCA200Page.isDisableButtons("Facebookアカウントでログイン");
		userRegisterCA200Page.isDisableButtons("Microsoftアカウントでログイン");
	}

	@Test
	public void CA200_02_CheckTextLink() {
		log.info("Check click on Logo");
		commonPage = userRegisterCA200Page.clickLogoButton(driver);
		Assert.assertEquals(commonPage.getUrlPage(driver), "https://enas.jp/");
		log.info("Back screen CA200");
		userRegisterCA200Page = commonPage.clickBackBrowser();
//		log.info("Click text link 個人情報保護方針");
//		commonPage = userRegisterCA200Page.clickPolicyTextLink();
//		Assert.assertEquals(commonPage.getPageUrl(driver), "");
//		userRegisterCA200Page = commonPage.clickBackBrowser();
		log.info("Click textlink Login");
		loginPage = userRegisterCA200Page.clickLoginTextLink();
		verifyTrue(loginPage.getPageUrl(driver).contains("product.com/auth/login/"));
		log.info("Click textlink Register");
		userRegisterCA200Page = loginPage.clickCreateAccountLink();

	}

	// @Test
	public void CA200_03_CheckRegisterButtons() {

	}

	@Test
	public void CA201_04_CheckUI(){
		log.info("Access screen CA201");
		userRegisterCA200Page.clickAgreeCheckbox();
		log.info("Click button Register Mail");
		userRegisterCA201Page = userRegisterCA200Page.clickMailButton("メールアドレスで登録");

		log.info("Verify text title");
		userRegisterCA201Page.isDisplayTextTitleCA201();
		log.info("Check text lablel");
		userRegisterCA201Page.isDisplayTextLabelCA201("名前");
		userRegisterCA201Page.isDisplayTextLabelCA201("メールアドレス");
		userRegisterCA201Page.isDisplayTextLabelCA201("パスワード");
		userRegisterCA201Page.isDisplayTextLabelCA201("パスワード（確認）");
		log.info("Check text placeholder input");
		Assert.assertEquals(userRegisterCA201Page.getPlaceholder("名前"), "名前");
		Assert.assertEquals(userRegisterCA201Page.getPlaceholder("メールアドレス"), "メールアドレス");
		Assert.assertEquals(userRegisterCA201Page.getPlaceholder("パスワード"), "半角英数字記号8文字以上32文字以下");
		Assert.assertEquals(userRegisterCA201Page.getPlaceholder("パスワード（確認）"), "半角英数字記号8文字以上32文字以下");
		log.info("Chect text color");
		Assert.assertEquals(userRegisterCA201Page.getColorTextTitleCA201(), "#333D5A");
		Assert.assertEquals(userRegisterCA201Page.getColorTextLabelCA201("名前"), "#333D5A");
		Assert.assertEquals(userRegisterCA201Page.getColorTextLabelCA201("メールアドレス"), "#333D5A");
		Assert.assertEquals(userRegisterCA201Page.getColorTextLabelCA201("パスワード"), "#333D5A");
		Assert.assertEquals(userRegisterCA201Page.getColorTextLabelCA201("パスワード（確認）"), "#333D5A");
		log.info("Check font-size");
		Assert.assertEquals(userRegisterCA201Page.getFontSizeTextTitleCA201(), "20px");
		Assert.assertEquals(userRegisterCA201Page.getFontSizeTextLabelCA201("名前"), "14px");
		Assert.assertEquals(userRegisterCA201Page.getFontSizeTextLabelCA201("メールアドレス"), "14px");
		Assert.assertEquals(userRegisterCA201Page.getFontSizeTextLabelCA201("パスワード"), "14px");
		Assert.assertEquals(userRegisterCA201Page.getFontSizeTextLabelCA201("パスワード（確認）"), "14px");
		log.info("Check click on Logo");
//		commonPage = userRegisterCA201Page.clickLogoButton(driver);
//		Assert.assertEquals(commonPage.getUrlPage(driver), "https://enas.jp/");

	}

	@Test
	public void CA201_05_Check_Input_Blank() {
		log.info("Click on the Submit button");
		userRegisterCA201Page.clickSubmitButton();
		log.info("Verify undisplay error Name input");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("名前"), true);
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"), userData.geterrorTextBlank());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"), userData.geterrorTextBlank());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"), userData.geterrorTextBlank());
	}

	@Test
	public void CA201_06_Check_Name_Valid() {
		log.info("Input Name Hiragana " + userData.getNameInputs().get(0).getName());
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(0).getName());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("名前"), true);
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(1).getName());
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("名前"), true);
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(3).getName());

	}
	@Test
	public void CA201_07_Check_Name_InValid_Format() {
		log.info("Input Name Number fullwidth " + userData.getNameInputs().get(3).getName());
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(3).getName());
		Assert.assertEquals(userRegisterCA201Page.getTextError("名前"), userData.getNameInputs().get(3).geterrorName());

		log.info("Input Name katatana halfwidth " + userData.getNameInputs().get(4).getName());
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(4).getName());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("名前"), userData.getNameInputs().get(4).geterrorName());

		log.info("Input Name Special characters " + userData.getNameInputs().get(5).getName());
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(5).getName());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("名前"), userData.getNameInputs().get(5).geterrorName());

	}

	@Test
	public void CA201_07_Check_Name_InValid_Length() {
		log.info("Input Name has 1 character " + userData.getNameInputs().get(6).getName());
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(6).getName());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("名前"), userData.getNameInputs().get(6).geterrorName());

		log.info("Input Name has 31 character " + userData.getNameInputs().get(7).getName());
		userRegisterCA201Page.inputValue("名前", userData.getNameInputs().get(7).getName());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("名前"), userData.getNameInputs().get(7).geterrorName());

	}
	
	@Test
	public void CA201_08_Check_Email_Valid() {
		log.info("Input Valid Email" + userData.getEmailInputs().get(0).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(0).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("メールアドレス"), true);

		log.info("Input Valid Email" + userData.getEmailInputs().get(1).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(1).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("メールアドレス"), true);

		log.info("Input Valid Email" + userData.getEmailInputs().get(2).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(2).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("メールアドレス"), true);

		log.info("Input Valid Email" + userData.getEmailInputs().get(3).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(3).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("メールアドレス"), true);
	}

	@Test
	public void CA201_09_Check_Email_InValid_Length(){
		log.info("Input InValid Email" + userData.getEmailInputs().get(4).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(4).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(4).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(5).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(5).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(5).getErrorEmail());
	}
	@Test
	public void CA201_09_Check_Email_InValid_Format(){
		log.info("Input InValid Email" + userData.getEmailInputs().get(6).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(6).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(6).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(7).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(7).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(7).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(8).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(8).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(8).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(9).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(9).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(9).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(10).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(10).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(10).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(11).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(11).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(11).getErrorEmail());

		log.info("Input InValid Email" + userData.getEmailInputs().get(12).getEmail());
		userRegisterCA201Page.inputValue("メールアドレス", userData.getEmailInputs().get(12).getEmail());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.getEmailInputs().get(12).getErrorEmail());

	}

	@Test
	public void CA201_10_Check_Password_Valid() {
		log.info("Input Valid Password" + userData.getPasswordInputs().get(0).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(0).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(0).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード"), true);
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード（確認）"), true);
		log.info("Input Valid Password" + userData.getPasswordInputs().get(1).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(1).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(1).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード"), true);
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード（確認）"), true);
		log.info("Input Valid Password" + userData.getPasswordInputs().get(2).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(2).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(2).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード"), true);
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード（確認）"), true);
	}

	@Test
	public void CA201_11_Check_Password_InValid_Format() {
		log.info("Input InValid Password" + userData.getPasswordInputs().get(3).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(3).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(3).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(3).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(3).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(4).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(4).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(4).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(4).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(4).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(5).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(5).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(4).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(5).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(5).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(6).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(6).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(6).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(6).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(6).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(7).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(7).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(7).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(7).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(7).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(8).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(8).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(8).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(8).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(8).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(9).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(9).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(9).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(9).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(9).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(10).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(10).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(10).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(10).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(10).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(11).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(11).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(11).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(11).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(11).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(12).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(12).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(12).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(12).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(12).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(13).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(13).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(13).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(13).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(13).geterrorConfirmPassword());
	}
	@Test
	public void CA201_11_Check_Password_InValid_Length() {
		log.info("Input InValid Password" + userData.getPasswordInputs().get(14).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(14).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(14).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(14).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(14).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(15).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(15).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(15).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード"),
				userData.getPasswordInputs().get(15).geterrorPassword());
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(15).geterrorConfirmPassword());

		log.info("Input InValid Password" + userData.getPasswordInputs().get(16).getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPasswordInputs().get(16).getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getPasswordInputs().get(16).getconfirmPassword());
		log.info("Verify display error");
		Assert.assertEquals(userRegisterCA201Page.isUnDisplayErrorInput("パスワード"), true);
		Assert.assertEquals(userRegisterCA201Page.getTextError("パスワード（確認）"),
				userData.getPasswordInputs().get(16).geterrorConfirmPassword());

	}

	@Test
	public void CA201_12_Check_Email_Exist() {
		log.info("Input Name" + userData.getNameUser());
		userRegisterCA201Page.inputValue("名前",userData.getNameUser());
		log.info("Input Valid Email" + userData.getemailExist());
		userRegisterCA201Page.inputValue("メールアドレス",userData.getemailExist());
		log.info("Input Valid Password" + userData.getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getConfirmPassword());
		log.info("Click on the Submit button");
		userRegisterCA201Page.clickSubmitButton();
		Assert.assertEquals(userRegisterCA201Page.getTextError("メールアドレス"),
				userData.geterrorTextEmailExist());
		
	}

	

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserLoginPO userLoginPage;
	private UserRegisterCA200PO userRegisterCA200Page;
	private CommonPO commonPage;
	private UserLoginPO loginPage;
	private UserRegisterCA201PO userRegisterCA201Page;
	UserDataMapper userData;
	
//	private CSVReader csvReader;
//	String[] csvCell;
//	String CSV_PATH = "D:/TaiLieu/DuAn/ENAS/dataTest/accountUser.csv";
}
