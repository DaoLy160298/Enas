package pageUIs;

public class UserRegisterUI {
	public static final String TITLE_CA200_TEXT = "xpath=//span[text()='ユーザー登録']";
	public static final String DYNAMIC_BUTTON = "xpath=//div[text()='%s']";
	
	public static final String POLICY_TEXTLINK = "xpath=//span[text()='個人情報保護方針']";
	public static final String AGREE_TEXT = "xpath=//span[text()='に同意する']";
	public static final String LOGIN_TEXTLINK = "xpath=//a[@href='/auth/login/']";
	
	public static final String AGREE_CHECBOX = "xpath=//span[@class='checkbox-prefix ant-wave-target css-xb0j7l']";
	
	public static final String DYNAMIC_TEXT_LABEL = "xpath=//div[text()='%s']";
	public static final String DYNAMIC_INPUT_TEXT = "xpath=//div[text()='%s']/parent::div/following-sibling::div/input";
	
	public static final String DYNAMIC_TEXT_ERROR= "xpath=//div[text()='%s']/parent::div/following-sibling::div[contains(@class,'text-error')]";
	public static final String SUBMIT_BUTTON = "xpath=//button[@type='submit']";
	
	public static final String TITLE_CA202_TEXT = "xpath=//div[text()='ご登録ありがとうございます。']";
	public static final String NOTI_SEND_SUCCESS_CA202 = "xpath=//div[contains(text(),'にメールを送信しました。メールから利用開始してください')]";
	public static final String OUTLOOK_BUTTON = "xpath=//div[text()='Outlook']";
	
	public static final String DYNAMIC_INPUT_CA203 = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_TEXTLABEL_CA203 = "xpath=//label[@for='%s']//div//span[1]";
	public static final String DYNAMIC_PLACEHOLDER_CA203 = "xpath=//input[@id='%s']";
	public static final String SITE_TYPE_PLACEHOLDER_CA203 = "xpath=//input[@id='site_type']/parent::span/following-sibling::span";
	public static final String DYNAMIC_DROPDOWN_INPUT_CA203 = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_VALUE_CA203 = "xpath=//div[text()='%s']";
//	public static final String DYNAMIC_ICON_RADIOBUTTON_CA203= "xpath=//div[@id='%s']//input[@type='radio'][@value='1']";
	public static final String DYNAMIC_ICON_RADIOBUTTON_CA203= "xpath=//span[text()='%s']";
	public static final String DYNAMIC_VALUE_RADIOBUTTON_CA203= "xpath=//div[@id='%s']//span[text()='%s']";
	
	public static final String TITLE_CA203_TEXT = "xpath=//span[text()='会員本登録']";
	public static final String NEXT_OR_COMPLETE_BUTTON = "xpath=//span[contains(text(),'%s')]";
	
	public static final String NOTI_SUCESS_TEXT1= "xpath=//div[text()='会員本登録完了']/following-sibling::div/div[1]";
	public static final String NOTI_SUCESS_TEXT2 = "xpath=//div[text()='会員本登録完了']/following-sibling::div/div[2]";
	
	public static final String DYNAMIC_MEMBERSHIP_ERROR_TEXT = "xpath=//div[@id= '%s']/div";
	public static final String DYNAMIC_SECONDS_TIMES_DROPDOWN ="xpath=//input[@id='%s']/parent::span/following-sibling::span";
}
