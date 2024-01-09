package pageUIs;

public class Common_DrapDrop_UI {
	public final static String DYNAMIC_DRAP_OR_ADD_COMPONENT_MENU = "xpath=//div[contains(@class,'sc-gsTDqH') and text()='%s']";
	
	public final static String DROP_POSITION = "xpath=((//div[@focusstate='normal'])[2]/following-sibling::div)[1]";
	
	public final static String DYNAMIC_TITLE_TEXTLABEL_MENU = "xpath=//div[text()='%s']";
	public final static String REQUIRED_TEXT_RADIOBUTTON = "xpath=//div[text()='必須']";
	public final static String REQUIRED_SWITCH_BUTTON = "xpath=//button[@role='switch']";
	
	public final static String REQUIRED_TEXT_IN_FORM = "xpath=//div[@focusstate='active']//span[text()='必須']";
	
	public final static String DYNAMIC_INPUT_VALUE_MENU = "xpath=//div[text()='%s']/following-sibling::input";
	public final static String TITLE_COMPONENT_FORM = "xpath=((//textarea[@placeholder='この項目の概要説明を入力'])[2]/preceding::div[contains(@contenteditable,'true')])[5]";
	public final static String DYNAMIC_TEXTAREA_PLACEHOLDER_MENU = "xpath=//div[text()='%s']/following-sibling::textarea";
	public final static String DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM = "xpath=//div[@focusstate='active']//div//span//textarea";
	public final static String DYNAMIC_EXPLANTION_MENU = "xpath=//div[text()='%s']/following-sibling::textarea";
	public final static String GENERAL_EXPLANTION_FORM = "xpath=//div[@contenteditable='true']/following-sibling::textarea[@placeholder='この項目の概要説明を入力']";
	public final static String ADDITIONAL_EXPLANTION_FORM = "xpath=//div[@draggable='true']/textarea[@placeholder='この項目の補足説明を入力']";
	
	public final static String COUNT_CHARACTERS = "xpath=//div[text()='文字数 500文字以内']";
	
	public final static String DYNAMIC_ICON_FUNCTION = "xpath=//img[@alt='%s']";
	 
	public final static String COMPONENT = "xpath=//div[@contenteditable='true']/parent::div[@draggable='true']";
	public final static String OUT_COMPONENT = "xpath=//div[@id='dropBoard']//div[2]";
	
	public final static String ICON_SELECT_RADIOBUTTON = "xpath=//span[text()='%s']/preceding::span[2]";
	
	public final static String INPUT_OPTION_MENU = "xpath=//div[text()='選択肢']//ancestor::div[2]/descendant::input";
	public final static String VALUE_OPTION_DEFAULT = "xpath=//span[contains(text(),'Option')]";
	public final static String FIRST_INPUT_OPTION_MENU = "xpath=(//div[text()='選択肢']//ancestor::div[2]/descendant::input)[1]";
	
	public final static String INPUT_FIELD_MENU = "xpath=//div[text()='項目追加 （最大10個）']//ancestor::div[2]/descendant::input";
	
	public final static String INPUT_OPTION_CF303_MENU = "xpath=//div[text()='選択肢（最大10個）']//ancestor::div[2]/descendant::input";
	public final static String OPTION_COLUMN_CF303_FORM = "xpath=//th[@class='ant-table-cell']";
	public final static String FIELD_ROW_CF303_FORM = "xpath=//tr[@class='ant-table-row ant-table-row-level-0']/td[1]";
	public final static String FORMAT_DEFAULT_RADIOBUTTON = "xpath=//tr[@class='ant-table-row ant-table-row-level-0']/td[2]/div/div";
	
	public final static String FIRST_INPUT_FIELD_CF303_MENU = "xpath=//div[text()='項目追加 （最大10個）']//ancestor::div[2]/descendant::input[1]";
	public final static String FIRST_INPUT_OPTION_CF303_MENU = "xpath=//div[text()='選択肢（最大10個）']//ancestor::div[2]/descendant::input[1]";
	
	public final static String FIRST_FIELD_ROW_CF303_FORM = "xpath=(//tr[@class='ant-table-row ant-table-row-level-0']/td[1])[1]";
	public final static String FIRST_OPTION_COLUMN_CF303_FORM = "xpath=//th[@class='ant-table-cell'][1]";
	
	public final static String FIRST_DYNAMIC_ICON_FUNCTION = "xpath=(//img[@alt='%s'])[1]";
	
	public final static String DYNAMIC_TITLE_COMPONENT_FORM = "xpath=//div[contains(text(), '%s') and @contenteditable='true']";
	public final static String DYNAMIC_SAMPLE_TEXT_INPUT_FORM = "xpath=//div[contains(text(), '%s') and @contenteditable='false']";
	public final static String ONE_COMPONENT_FORM = "xpath=//div[contains(text(), '%s') and @contenteditable='true']/parent::div";
}
