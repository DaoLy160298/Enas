package pageUIs;

public class UserLoginUI {
//	public static final String REGISTER_TEXTLINK = "xpath=(//a[contains(text(),'アカウントをお持ちでない方はこちら')])[1]";
	public static final String DYNAMIC_INPUT= "xpath=//input[@name='%s']";
	public static final String DYNAMIC_TEXT_LABEL = "xpath=//input[@name='%s']/parent::div/preceding-sibling::div/div";
	
	public static final String SUBMIT_BUTTON = "xpath=//button[@type='submit']";
	public static final String RESET_PASSWORD_TEXTLINK = "xpath=//a[contains(text(),'パスワードをお忘れの方はこちら')]";
	
	public static final String DYNAMIC_ERROR_BLANK_TEXT = "xpath=//input[@name='%s']/parent::div/following-sibling::div";
	public static final String ERROR_INVALID = "xpath=//div[contains(@class,'text-error')]";
	public static final String CREATE_ACCOUNT_LINK = "xpath=//a[@href='/auth/register/']";
	
}
