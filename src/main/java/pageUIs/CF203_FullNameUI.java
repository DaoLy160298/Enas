package pageUIs;

public class CF203_FullNameUI {
	public final static String NAME_TITLE_COMPONENT_FORM = "xpath=(//textarea[@placeholder='この項目の概要説明を入力'])[2]/preceding::div[contains(@contenteditable,'true')]";
	public final static String NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM = "xpath=(//div[text()='セイ'])[2]/preceding::div/following-sibling::div[contains(@contenteditable,'true')]";
	public final static String DYNAMIC_NAME_TEXTLABEL_FORM = "xpath=(//div[text()='%s'])[2]";
	public final static String DYNAMIC_NAME_VALUE_INPUT_FORM = "xpath=(//div[text()='%s'])[2]/following-sibling::div";
	public final static String VALUE_DEFAULT_NAME_RADIOBUTTON = "xpath=//span[text()='%s']/preceding::span[2]";

	public final static String TITLE_FURIGANA_FORM_SELECTED = "xpath=(//textarea[@placeholder='この項目の概要説明を入力'])[2]/preceding::div[contains(@contenteditable,'true')]";
}
