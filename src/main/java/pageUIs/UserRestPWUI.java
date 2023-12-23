package pageUIs;

public class UserRestPWUI {
	public static final String TITLE_TEXT = "xpath=//h2[text()='パスワードを忘れた方']";
	public static final String NOTE_TEXT_CA300 = "xpath=//form/p";
	public static final String DYNMAIC_TEXT_LABEL = "xpath=//input[@name='%s']/parent::div/preceding-sibling::div/div";
	public static final String DYNAMIC_INPUT = "xpath=//input[@name='%s']";
	public static final String REST_PASSWPORD_BUTTON = "xpath=//button[@type='submit']";
	public static final String ERROR_TEXT = "xpath=//div[contains(@class,'text-error')]";
	
	public static final String NOTE_TEXT_CA301_CA302 = "xpath=//h2/following-sibling::p";
	public static final String DYNAMIC_PW_ERROR = "xpath=//input[@name='%s']/parent::div/following-sibling::div[contains(@class,'text-error')]";
	public static final String LOGIN_BUTTON = "xpath=//span[text()='ログインへ']";
}
