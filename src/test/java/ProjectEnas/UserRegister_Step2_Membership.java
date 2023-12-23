package ProjectEnas;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.testng.TestInstanceParameter;
import pageObject.CommonPO;
import pageObject.Login_ThirdPO;
import pageObject.UserHomePO;
import pageObject.UserLoginPO;
import pageObject.UserRegisterCA200PO;
import pageObject.UserRegisterCA201PO;
import pageObject.UserRegisterCA203PO;
import testdata.UserDataMapper;
import testdata.UserMembershipData;

public class UserRegister_Step2_Membership extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws IOException {
		driver = getBrowserDriver(browserName);
		userData = UserDataMapper.getUserData();
		userMembershipData = UserMembershipData.getUserMembershipData();
		email = userData.getemailSuccess();
		password = userData.getPassword();
		userLoginPage = PageGeneratorManager.getUserLogin(driver);
		
		log.info("Click text lin Create account");
		userRegisterCA200Page = userLoginPage.clickCreateAccountLink();
		textNotiSend = userData.getemailSuccess().concat("にメールを送信しました。メールから利用開始してください。");
		log.info("Access screen CA201");
		userRegisterCA200Page.clickAgreeCheckbox();
		log.info("Click button Register Mail");
		userRegisterCA201Page = userRegisterCA200Page.clickMailButton("メールアドレスで登録");
		
		//Comment de login truc tiep
//		log.info("Input Valid Email");
//		userLoginPage.inputValid("email",userData.getemailSuccess() );
//		log.info("Input value Password");
//		userLoginPage.inputValid("password", userData.getPassword());
//		log.info("Click button Submit");
//		userRegisterCA203Page = userLoginPage.clickSubmitButtonStatus1();
	
	}
	@Test
	public void CA202_01_Check_Success() {
		log.info("Input Name" + userData.getNameUser());
		userRegisterCA201Page.inputValue("名前",userData.getNameUser());
		log.info("Input Valid Email" + userData.getemailSuccess());
		userRegisterCA201Page.inputValue("メールアドレス",userData.getemailSuccess());
		log.info("Input Valid Password" + userData.getPassword());
		userRegisterCA201Page.inputValue("パスワード", userData.getPassword());
		userRegisterCA201Page.inputValue("パスワード（確認）", userData.getConfirmPassword());
		log.info("Click on the Submit button");
		userRegisterCA201Page.clickSubmitButton();		
		
	}
	@Test
	public void CA203_01_Login_Site_Third() {
		log.info("Click on the Outlook button");
		loginThirdPage = userRegisterCA201Page.clickOutlook();
		log.info("Login account site third");
		
//		loginThirdPage.loginMicrosoft();
		loginThirdPage.enterValueLoginMicrosoft("email", userData.getemailExist());
		loginThirdPage.clickSubmit();
		loginThirdPage.enterValuePassword("password", password);
		loginThirdPage.clickSubmit();
		loginThirdPage.clickSubmit();
		log.info("Click url Email");
		loginThirdPage.clickTabListEmail();
		userRegisterCA203Page = loginThirdPage.clickUrlEmailMemembership("/verify/register?expires");
		
	}
	@Test
	public void CA203_02_Check_UI() {
		log.info("Check text label");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("project_name"),"プロジェクト名");
		Assert.assertEquals(userRegisterCA203Page.getPlaceholder("project_name"),"プロジェクト名を入力してください。");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("domain"),"サイトのドメイン");
		Assert.assertEquals(userRegisterCA203Page.getPlaceholder("domain"),"サイトのドメインを入力してください。");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("site_type"),"サイトタイプ");
		Assert.assertEquals(userRegisterCA203Page.getPlaceholderSiteType(),"サイトタイプを選択してください。");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("site_plan"),"導入する予定のサイト");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("project_name"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("domain"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("site_type"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("site_plan"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("project_name"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("project_name"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("domain"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("site_type"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("site_plan"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getForSizeButton("次へ"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getColorButton("次へ"),"#FFFFFF");
		
	}
	@Test
	public void CA203_03_Check_Input_Blank() {
		log.info("Click button Next When leaving the fields blank");
		userRegisterCA203Page.clickNextButtonOrCompleteButton("次へ");
		log.info("Verify displayed error blank");
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("project_name_help"), userMembershipData.getErrorBlank());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getErrorBlank());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("site_type_help"), userMembershipData.getErrorBlank());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("site_plan_help"), userMembershipData.getErrorBlank());
	}
	@Test
	public void CA203_04_Check_Input_InValid() {
		log.info("Check input value");
		userRegisterCA203Page.inputValueCA203("project_name",userMembershipData.getNameProjectInputs().get(1).getProjectName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("project_name_help"), userMembershipData.getNameProjectInputs().get(1).getErrorProjectName());
		
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(2).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(2).getErrordomainName());
	
		log.info("Enter full space then click out of the inputbox");
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(3).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(3).getErrordomainName());
//		userRegisterCA203Page.clickOutInput("domain");
//		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getErrorBlank());
	
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(4).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(4).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(5).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(5).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(6).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(6).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(7).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(7).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(8).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(8).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(9).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(9).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(10).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(10).getErrordomainName());
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(11).getDomainName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("domain_help"), userMembershipData.getDomainInputs().get(11).getErrordomainName());		
		
	}
	@Test
	public void CA203_05_Check_Input_Valid() {
		log.info("Check input value");
		userRegisterCA203Page.inputValueCA203("project_name",userMembershipData.getNameProjectInputs().get(0).getProjectName());
		log.info("Verify text "+ userRegisterCA203Page.isUnDisplayErrorCA203("project_name_help"));
		Assert.assertEquals(userRegisterCA203Page.isUnDisplayErrorCA203("project_name_help"),true);
		
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(0).getDomainName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("domain_help"));
		userRegisterCA203Page.inputValueCA203("domain",userMembershipData.getDomainInputs().get(1).getDomainName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("domain_help"));
		
		userRegisterCA203Page.selectValueDropdown("site_type",userMembershipData.getSiteTypeDropdowns().get(0).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		System.out.println("chạy tới đây");
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(1).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(2).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(3).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(4).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(5).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(6).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(7).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		userRegisterCA203Page.selectClickSecordTimes("site_type",userMembershipData.getSiteTypeDropdowns().get(8).getSiteType(),userMembershipData.getSiteTypeDropdowns().get(8).getSiteType());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_type_help"));
		
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsitePlanRadiobuttons().get(0).getSitePlan());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_plan_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsitePlanRadiobuttons().get(1).getSitePlan());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("site_plan_help"));
		userRegisterCA203Page.clickNextButtonOrCompleteButton("次へ");
	}
	
	//@Test
//	public void CA203_06_Check_Action_Success() {
//		log.info("Check input value");
//		userRegisterCA203Page.inputValueCA203("project_name","a");
//		userRegisterCA203Page.inputValueCA203("domain","a");
//		userRegisterCA203Page.selectValueDropdown("site_type","ECサイト");
//		userRegisterCA203Page.ChoseValueRadiobutton("自社サイト");
//	}
	
	@Test
	public void CA204_01_Check_UI() {
		log.info("Check text title");
		verifyTrue(userRegisterCA203Page.isDisplayTitleText());
		log.info("Check text label");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("size_staff"),"従業員規模");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("size_staff"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("size_staff"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("company_name"),"会社名");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("company_name"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("company_name"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getPlaceholder("company_name"),"会社名を選択してください。");
		Assert.assertEquals(userRegisterCA203Page.getTextLabel("company_phone"),"電話番号");
		Assert.assertEquals(userRegisterCA203Page.getForSizeTextLabel("company_phone"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getColorTextLabel("company_phone"),"#333D5A");
		Assert.assertEquals(userRegisterCA203Page.getPlaceholder("company_phone"),"電話番号を入力してください。");
		Assert.assertEquals(userRegisterCA203Page.getForSizeButton("完了"),"16px");
		Assert.assertEquals(userRegisterCA203Page.getColorButton("完了"),"#FFFFFF");
	}
	@Test
	public void CA204_02_Check_Input_Blank() {
		log.info("Click button Complete When leaving the fields blank");
		userRegisterCA203Page.clickNextButtonOrCompleteButton("完了");
		log.info("Verify displayed error blank");
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("size_staff_help"), userMembershipData.getErrorBlank());
		
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getErrorBlank());
		
	}
	@Test
	public void CA204_03_Check_Input_Vaild() {
		
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(10).getcompanyName());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_name_help"), userMembershipData.getCompanyNameInputs().get(10).getErrorCompanyName());
		
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(2).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(2).getErrorCompanyPhone());
		
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(3).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(3).getErrorCompanyPhone());
		
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(4).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(4).getErrorCompanyPhone());
		
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(5).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(5).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(6).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(6).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(7).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(7).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(8).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(8).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(9).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(9).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(10).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(10).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(11).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(11).getErrorCompanyPhone());
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(12).getCompanyPhone());
		Assert.assertEquals(userRegisterCA203Page.getTextErrorCA203("company_phone_help"), userMembershipData.getcompanyPhoneInputs().get(12).getErrorCompanyPhone());
	}
	
	@Test
	public void CA204_04_Check_Action_Success() {
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(0).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(1).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(2).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(3).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(4).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(5).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(6).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		userRegisterCA203Page.ChoseValueRadiobutton(userMembershipData.getsizeStaffRadiobutton().get(7).getSizeStaff());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("size_staff_help"));
		  
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(0).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(1).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(2).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(3).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(4).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(5).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(6).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(7).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(8).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		userRegisterCA203Page.inputValueCA203("company_name",userMembershipData.getCompanyNameInputs().get(9).getcompanyName());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_name_help"));
		
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(0).getCompanyPhone());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_phone_help"));
		userRegisterCA203Page.inputValueCA203("company_phone",userMembershipData.getcompanyPhoneInputs().get(1).getCompanyPhone());
		verifyTrue(userRegisterCA203Page.isUnDisplayErrorCA203("company_phone_help"));
		
		
//		log.info("Check input value");
//		userRegisterCA203Page.ChoseValueRadiobutton("個人");
//		userRegisterCA203Page.inputValueCA203("company_name","daoly");
//		userRegisterCA203Page.inputValueCA203("company_phone","0987654321");
		userRegisterCA203Page.clickNextButtonOrCompleteButton("完了");
		log.info(userRegisterCA203Page.getUrlSuccess());
		verifyTrue(userRegisterCA203Page.getUrlSuccess().contains("stack-product.com/auth/register/success/"));
		Assert.assertEquals(userRegisterCA203Page.getTextNotiSuccess(),"正常に会員登録が完了しました。引き続きサービスをご利用ください。");
		userHomePage = userRegisterCA203Page.clickButtonRedirectHomePage("ホームページ画面へ");
		
	}
	//@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private UserLoginPO userLoginPage;
	private UserRegisterCA200PO userRegisterCA200Page;
	private UserRegisterCA201PO userRegisterCA201Page;
	private UserRegisterCA203PO userRegisterCA203Page;
	private CommonPO commonPage;
	private UserLoginPO loginPage;
	private UserHomePO userHomePage;
	private Login_ThirdPO loginThirdPage;
	UserDataMapper userData;
	UserMembershipData userMembershipData;
	private String textNotiSend;
	String email,password;
}
