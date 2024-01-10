package pageUIs;

public class CF306_ImageUI {
	public final static String PHOTO_FRAME_FORM = "xpath=//div[@class='ant-upload-drag-container']";
	public final static String OPTION_FORM = "xpath=//div[@class='flex']/div[2]";
	public final static String FIRST_OPTION_FORM = "xpath=(//div[@class='flex']/div[2])[1]";
	public final static String ICON_FORMAT_FORM = "xpath=//div[@class='flex']/div[2]/preceding::div[1]";
	public final static String FIRST_PHOTO_FRAME_FORM = "xpath=(//div[@class='ant-upload-drag-container'])[1]";
	
	public final static String FIRST_INPUT_IMAGE = "xpath=(//input[@type='file'])[1]";
	public final static String FIRST_IMAGE_FORM = "xpath=(//img[contains(@src,'data:image/')])[1]";
	public final static String INPUT_MENU = "xpath=//div[text()='選択肢']//ancestor::div[2]/descendant::input";
	public final static String ERROR_TOAST_FILE_IMAGE = "xpath=//span[text()='アップロード可能なファイル形式は、 PNG、JPG、JPEG、GIF、JFIFのみです。']";
}
