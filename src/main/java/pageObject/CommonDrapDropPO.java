package pageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import pageUIs.CF203_FullNameUI;
import pageUIs.CF306_ImageUI;
import pageUIs.CF307_SelectOptionUI;
import pageUIs.Common_DrapDrop_UI;
import pageUIs.UserRegisterUI;

public class CommonDrapDropPO extends BasePage {
	private WebDriver driver;

	public CommonDrapDropPO(WebDriver driver) {
		this.driver = driver;
	}

	public void drapAndDropPosition(String nameComponent) {
		// waitForElementClickable(driver,
		// Demo_DrapDrpp_UI.DYNAMIC_DRAP_OR_ADD_COMPONENT_MENU,nameComponent);
		sleepInSecond(1);
		drapAndDropComponent(driver, Common_DrapDrop_UI.DYNAMIC_DRAP_OR_ADD_COMPONENT_MENU,
				Common_DrapDrop_UI.DROP_POSITION, nameComponent);

	}

	public boolean isDisplayTitleTextLabelMenu(String text) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, text);
		return isElementDisplayed(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, text);
	}

	public String getRequiredTextLabel() {
		waitForElementVisible(driver, Common_DrapDrop_UI.REQUIRED_TEXT_RADIOBUTTON);
		return getElementText(driver, Common_DrapDrop_UI.REQUIRED_TEXT_RADIOBUTTON);

	}

	public boolean checkStatusUnCheckRequiredSwitch() {
		waitForElementClickable(driver, Common_DrapDrop_UI.REQUIRED_SWITCH_BUTTON);
		if (getElementAttribute(driver, Common_DrapDrop_UI.REQUIRED_SWITCH_BUTTON, "aria-checked").equals("false")) {
			return true;
		}
		return false;
	}

	public void clickRequiredButton() {
		waitForElementClickable(driver, Common_DrapDrop_UI.REQUIRED_SWITCH_BUTTON);
		clickToElement(driver, Common_DrapDrop_UI.REQUIRED_SWITCH_BUTTON);
	}

	public boolean checkDisplayTextRequiredForm(boolean shouldBeDisplayed) {
		if (shouldBeDisplayed) {
			waitForElementVisible(driver, Common_DrapDrop_UI.REQUIRED_TEXT_IN_FORM);
			return isElementDisplayed(driver, Common_DrapDrop_UI.REQUIRED_TEXT_IN_FORM);
		} else {
			return isElementUndisplayed(driver, Common_DrapDrop_UI.REQUIRED_TEXT_IN_FORM);
		}
	}

	public void inputValueComponentMenu(String nameInput, String value) {
		clearValueInElementPressKey(driver, Common_DrapDrop_UI.DYNAMIC_INPUT_VALUE_MENU, nameInput);
		//waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_INPUT_VALUE_MENU, nameInput);
		//clearValueInElementPressKey(driver, Common_DrapDrop_UI.DYNAMIC_INPUT_VALUE_MENU, nameInput);
		sendkeyToElement(driver, Common_DrapDrop_UI.DYNAMIC_INPUT_VALUE_MENU, value, nameInput);
	}

	public boolean checkChangeValueTitleForm(String value) {
		waitForElementVisible(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM);
		System.out.println("Vaule title in Form: " + getElementText(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM));
		if (getElementText(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM).equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkValueSampleTextForm(String value) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM,value);
		return isElementDisplayed(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM,value);

	}

	public void textareaValueComponentMenu(String nameTextarea, String value) {
		clearValueInElementPressKey(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, nameTextarea);
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, nameTextarea);
		clearValueInElementPressKey(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, nameTextarea);
		sendkeyToElement(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, value, nameTextarea);
	}

	public boolean checkValueAtribute(String locator, String valueInput) {
		waitForElementVisible(driver, locator);
		if (getElementAttribute(driver, locator, "value").equals(valueInput)) {
			System.out.println("Vaule title in Form: " + getElementAttribute(driver, locator, "value"));
			return true;
		} else {
			return false;
		}
	}

	public boolean checkValueGeneralExForm(String valueInput) {
		return checkValueAtribute(Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM, valueInput);
	}

	public boolean checkValuePlaceholder(String locator, String valueInput) {
		waitForElementVisible(driver, locator);
		if (getElementAttribute(driver, locator, "placeholder").equals(valueInput)) {
			System.out.println("Placeholder title in Form: " + getElementAttribute(driver, locator, "placeholder"));
			return true;
		} else {
			return false;
		}
	}

	public boolean checkPlaceholderGeneralExForm(String valueInput) {
		return checkValuePlaceholder(Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM, valueInput);
	}

	public boolean checkValueAdditionalExForm(String valueInput) {
		return checkValueAtribute(Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM, valueInput);
	}

	public boolean checkPlaceholderAdditionalExForm(String valueInput) {
		return checkValuePlaceholder(Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM, valueInput);
	}

	public void enterValueGeneralExForm(String value) {
		clearValueInElementPressKey(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM);
		waitForElementVisible(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM);
		sendkeyToElement(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM, value);

	}

	public boolean checkTextareaValueTextareaMenu(String nameTextarea, String value) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, nameTextarea);
		System.out.println("Value in the menu textarea: "
				+ getElementText(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, nameTextarea));
		if (getElementText(driver, Common_DrapDrop_UI.DYNAMIC_EXPLANTION_MENU, nameTextarea).equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public void enterValueAdditionalExForm(String value) {
		clearValueInElementPressKey(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM);
		waitForElementVisible(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM);
		sendkeyToElement(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM, value);
	}

	public void enterValueTitleInForm(String value) {

		clickToElement(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM);

		sendkeyToElement(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM, value);
	}

	public boolean checkInputValueMenu(String nameInput, String valueText) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_INPUT_VALUE_MENU, nameInput);
		String valueEnter = getElementAttribute(driver, Common_DrapDrop_UI.DYNAMIC_INPUT_VALUE_MENU, "value",
				nameInput);
		System.out.println("Gia tri nhap tu noi dung form: " + valueEnter);
		if (valueEnter.equals(valueText)) {
			return true;
		}
		return false;
	}

	public boolean getPlaceholderTextarea(String nameTextarea, String expectPlaceholder) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_TEXTAREA_PLACEHOLDER_MENU, nameTextarea);
		String valuePlaceholder = getElementAttribute(driver, Common_DrapDrop_UI.DYNAMIC_TEXTAREA_PLACEHOLDER_MENU,
				"placeholder", nameTextarea);
		System.out.println("Gia tri placeholder: " + valuePlaceholder);
		if (valuePlaceholder.equals(expectPlaceholder)) {
			return true;
		}
		return false;
	}

	public String getColorTexLabel(String nameTextLabel) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, nameTextLabel);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, nameTextLabel))
				.toUpperCase();

	}

	public String getFontSizeTextLabel(String nameTextLabel) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, nameTextLabel);
		return getFontSize(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, nameTextLabel);
	}

	public String getColorTitleComponentForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM)).toUpperCase();

	}

	public String getColorSampleTextForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM)).toUpperCase();
	}

	public String getColorSampleTextareaForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM))
				.toUpperCase();
	}

	public String getColorGeneralExForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM)).toUpperCase();
	}

	public String getColorAdditionalExForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM)).toUpperCase();
	}

	public String getFontSizeTitleComponentForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM);
	}

	public String getFontSizeSampleTextForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM);
	}

	public String getFontSizeSampleTextareaForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM);
	}

	public String getFontSizeGeneralExForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM);
	}

	public String getFontSizeAdditionalExForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.ADDITIONAL_EXPLANTION_FORM);
	}

	public boolean checkValueSampleTextareaForm(String value) {
		waitForElementVisible(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM);
		String valueSample = getElementAttribute(driver, Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_TEXTAREA_FORM,
				"placeholder");
		System.out.println("Vaule Sample Text Form: " + valueSample);
		if (valueSample.equals(value)) {
			return true;
		} else {
			return false;
		}

	}

	public String getTextCountCharacters() {
		waitForElementVisible(driver, Common_DrapDrop_UI.COUNT_CHARACTERS);
		return getElementText(driver, Common_DrapDrop_UI.COUNT_CHARACTERS);
	}

	public boolean isSelectRadiobutton(String valueRadiobutton) {
		String valueClass = getElementAttribute(driver, Common_DrapDrop_UI.ICON_SELECT_RADIOBUTTON, "class",
				valueRadiobutton);
		if (valueClass.contains("ant-radio-checked")) {
			return true;
		}
		return false;

	}

	public String checkValueNameTitleComponent() {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
		return getElementText(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
	}

	public boolean checkTextlableName(String nameTextlabel) {
		waitForElementVisible(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, nameTextlabel);
		return isElementDisplayed(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, nameTextlabel);
	}

	public String checkValueNameFuriganaTitleComponent() {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
		return getElementText(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
	}

	public String getValueNameCF203(String nameInput) {
		waitForElementVisible(driver, CF203_FullNameUI.DYNAMIC_NAME_VALUE_INPUT_FORM, nameInput);
		return getElementText(driver, CF203_FullNameUI.DYNAMIC_NAME_VALUE_INPUT_FORM, nameInput);
	}

	public void clickNameRadiobutton(String nameRadiobutton) {
		waitForElementVisible(driver, Common_DrapDrop_UI.ICON_SELECT_RADIOBUTTON, nameRadiobutton);
		clickToElement(driver, Common_DrapDrop_UI.ICON_SELECT_RADIOBUTTON, nameRadiobutton);
	}

	public boolean isUnDisplayTitleTextLabelMenu(String text) {
		return isElementUndisplayed(driver, Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, text);
	}

	public boolean isUnDisplayNameFuriganaTitleComponent() {
		return isElementUndisplayed(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
	}

	public boolean checkValueNameFuriTitle(String nameTextlabel) {
		String valueTextlabel = getElementText(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
		System.out.println("Name text label fullname furigan: " + valueTextlabel);
		if (valueTextlabel.equals(nameTextlabel)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isUndisplayTextlableName(String valueTextlabel) {
		System.out.println(isElementUndisplayed(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, valueTextlabel));
		return isElementUndisplayed(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, valueTextlabel);
	}

	public boolean isUnDisplayValueNameCF203(String valueInput) {
		return isElementUndisplayed(driver, CF203_FullNameUI.DYNAMIC_NAME_VALUE_INPUT_FORM, valueInput);
	}

	public String checkNameFuriganaTitleComponentForm() {
		waitForElementVisible(driver, CF203_FullNameUI.TITLE_FURIGANA_FORM_SELECTED);
		return getElementText(driver, CF203_FullNameUI.TITLE_FURIGANA_FORM_SELECTED);
	}

	public boolean checkChangeValueFullNameForm(String valeFullNameTitle) {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
		System.out.println(
				"Value in text title fullname: " + getElementText(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM));
		if (getElementText(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM).equals(valeFullNameTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkChangeValueFuriganaForm(String valeFullNameTitle) {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
		System.out.println("Value in text title fullname: "
				+ getElementText(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM));
		if (getElementText(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM)
				.equals(valeFullNameTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public void enterValueTitleFullNameInForm(String enterValue) {
		clickToElement(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
		sendkeyToElement(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM, enterValue);
	}

	public void enterValueTitleFuriganaInForm(String furiganaTitle) {
		clickToElement(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
		sendkeyToElement(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM, furiganaTitle);

	}

	public String getColorFullNameForm() {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
		return getHexaColorFromRGBA(getColor(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM)).toUpperCase();

	}

	public String getColorNameForm(String nameInput) {
		waitForElementVisible(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, nameInput);
		return getHexaColorFromRGBA(getColor(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, nameInput))
				.toUpperCase();
	}

	public String getColorFuriganaForm() {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
		return getHexaColorFromRGBA(getColor(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM))
				.toUpperCase();
	}

	public String getFontSizeTextTitleForm() {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
		return getFontSize(driver, CF203_FullNameUI.NAME_TITLE_COMPONENT_FORM);
	}

	public String getFontSizeNameTextForm(String nameInput) {
		waitForElementVisible(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, nameInput);
		return getFontSize(driver, CF203_FullNameUI.DYNAMIC_NAME_TEXTLABEL_FORM, nameInput);
	}

	public String getFontSizeFuriganaTitle() {
		waitForElementVisible(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
		return getFontSize(driver, CF203_FullNameUI.NAME_FURIGANA_TITLE_COMPONENT_TEXTLABEL_FORM);
	}

	public void clickIconDuplicate(String nameIcon, int times) {
		waitForElementClickable(driver, Common_DrapDrop_UI.DYNAMIC_ICON_FUNCTION, nameIcon);
		for (int i = 0; i < times; i++) {
			clickToElement(driver, Common_DrapDrop_UI.DYNAMIC_ICON_FUNCTION, nameIcon);
		}
	}

	public void clickIconDelete(String nameIcon, int times) {
		
		waitForElementClickable(driver, Common_DrapDrop_UI.DYNAMIC_ICON_FUNCTION, nameIcon);
		for (int i = 0; i < times; i++) {
		clickToElement(driver, Common_DrapDrop_UI.DYNAMIC_ICON_FUNCTION, nameIcon);
		}
	}

	

	public boolean checkCountAttributeElements(String locator, String expectedAttribute, String expectedText, int n) {
		int countActual = 0;

		List<WebElement> webElementList = getListWebElement(driver, locator);
		for (WebElement element : webElementList) {
			String valueString = element.getAttribute(expectedAttribute);
			if (valueString != null && valueString.contains(expectedText)) {
				System.out.println(valueString);
				countActual++;
			}
		}
		System.out.println("So luong phan giai thich "+countActual);
		return countActual == n;
	}
	public boolean checkCountElements(String locator, String expectedText, int n) {
		int countActual = 0;

		List<WebElement> webElementList = getListWebElement(driver, locator,expectedText);
		for (WebElement element : webElementList) {
			String valueString = element.getText();
			if (valueString.equals(expectedText)) {
				System.out.println(valueString);
				countActual++;
			}
		}

		System.out.println("Number of titles with the same value: "+countActual);
		return countActual == n;
	}

	public boolean checkCountTitleComponent(String valueTitle, int n) {
		return checkCountElements(Common_DrapDrop_UI.DYNAMIC_TITLE_COMPONENT_FORM, valueTitle, n);
	}

	public boolean checkCountTextSample(String textSample, int n) {
		return checkCountElements(Common_DrapDrop_UI.DYNAMIC_SAMPLE_TEXT_INPUT_FORM, textSample, n);
	}

	public boolean checkCountGeneralEx(String textGeneral, int n) {
		return checkCountAttributeElements(Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM, "value", textGeneral, n);
	}

	public boolean checkCountAdditionalEx(String textAdditional, int n) {
		return checkCountAttributeElements(Common_DrapDrop_UI.GENERAL_EXPLANTION_FORM, "value", textAdditional, n);
	}

	public boolean countComponentsAfterDeletion(String componentTitle, int expectedCount) {
		int actualCount = 0;
		List<WebElement> componentList = getListWebElement(driver, Common_DrapDrop_UI.TITLE_COMPONENT_FORM);
		for (WebElement component : componentList) {
			if (component.getText().equals(componentTitle)) {
				actualCount++;
			}
		}
		return actualCount == expectedCount;

	}

	public void clickComponent() {
		waitForElementClickable(driver, Common_DrapDrop_UI.COMPONENT);
		clickToElement(driver, Common_DrapDrop_UI.COMPONENT);
	}

	public void clickOutComponent() {
		waitForElementClickable(driver, Common_DrapDrop_UI.OUT_COMPONENT);
		clickToElement(driver, Common_DrapDrop_UI.OUT_COMPONENT);
	}

	public int getCountInputOptionMenu() {
		waitForElementVisible(driver, Common_DrapDrop_UI.INPUT_OPTION_MENU);
		int countInputOption = 0;
		List<WebElement> listInput = getListWebElement(driver, Common_DrapDrop_UI.INPUT_OPTION_MENU);
		for (WebElement webElement : listInput) {
			String textInputOption = webElement.getAttribute("value");
			System.out.println("gia tri option" + textInputOption);
			if (textInputOption.contains("Option")) {
				countInputOption++;
			}
		}
		return countInputOption;

	}

	public int getCountInputOptionCF303Menu() {
		waitForElementVisible(driver, Common_DrapDrop_UI.INPUT_OPTION_CF303_MENU);
		int countInputOption = 0;
		List<WebElement> listInput = getListWebElement(driver, Common_DrapDrop_UI.INPUT_OPTION_CF303_MENU);
		for (WebElement webElement : listInput) {
			String textInputOption = webElement.getAttribute("value");
			System.out.println("gia tri option" + textInputOption);
			if (textInputOption.contains("Option")) {
				countInputOption++;
			}
		}
		return countInputOption;

	}

	public int getCountInputFieldMenu() {
		waitForElementVisible(driver, Common_DrapDrop_UI.INPUT_FIELD_MENU);
		int countInputOption = 0;
		List<WebElement> listInput = getListWebElement(driver, Common_DrapDrop_UI.INPUT_FIELD_MENU);
		for (WebElement webElement : listInput) {
			String textInputOption = webElement.getAttribute("value");
			System.out.println("gia tri option" + textInputOption);
			if (textInputOption.contains("Field")) {
				countInputOption++;
			}
		}
		return countInputOption;

	}

	public String getColorColumnForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.OPTION_COLUMN_CF303_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.OPTION_COLUMN_CF303_FORM)).toUpperCase();
	}

	public String getColorRowForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.FIELD_ROW_CF303_FORM);
		return getHexaColorFromRGBA(getColor(driver, Common_DrapDrop_UI.FIELD_ROW_CF303_FORM)).toUpperCase();
	}

	public String getFontSizeColumnForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.OPTION_COLUMN_CF303_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.OPTION_COLUMN_CF303_FORM);
	}

	public String getFontSizeRowForm() {
		waitForElementVisible(driver, Common_DrapDrop_UI.FIELD_ROW_CF303_FORM);
		return getFontSize(driver, Common_DrapDrop_UI.FIELD_ROW_CF303_FORM);
	}

	public boolean checkFormatDefault() {
		waitForElementVisible(driver, Common_DrapDrop_UI.FORMAT_DEFAULT_RADIOBUTTON);
		String valueFormat = getElementAttribute(driver, Common_DrapDrop_UI.FORMAT_DEFAULT_RADIOBUTTON, "class");
		if (valueFormat.contains("rounded-full")) {
			return true;
		}
		return false;
	}

	public void enterInputOption(String locator, String valueEnter) {
		clearValueInElementPressKey(driver, locator);
		waitForElementVisible(driver, locator);
		sendkeyToElement(driver, locator, valueEnter);
	}

	public void inputValueFieldInput(String valueEnter) {
		enterInputOption(Common_DrapDrop_UI.FIRST_INPUT_FIELD_CF303_MENU, valueEnter);
	}

	public boolean checkValueFieldTextForm(String value) {
		waitForElementVisible(driver, Common_DrapDrop_UI.FIRST_FIELD_ROW_CF303_FORM);
		String valueText = getElementText(driver, Common_DrapDrop_UI.FIRST_FIELD_ROW_CF303_FORM);
		if (valueText.equals(value)) {
			return true;
		}
		return false;
	}

	public void inputValueOption(String valueEnter) {
		enterInputOption(Common_DrapDrop_UI.FIRST_INPUT_OPTION_CF303_MENU, valueEnter);
	}

	public void inputValueOptionCF306(String valueEnter) {
		enterInputOption(Common_DrapDrop_UI.INPUT_OPTION_MENU, valueEnter);
	}

	public boolean checkValueOptionTextForm(String value) {
		waitForElementVisible(driver, Common_DrapDrop_UI.FIRST_OPTION_COLUMN_CF303_FORM);
		String valueText = getElementText(driver, Common_DrapDrop_UI.FIRST_OPTION_COLUMN_CF303_FORM);
		if (valueText.equals(value)) {
			return true;
		}
		return false;
	}

	public boolean checkFormatCheckbox() {
		waitForElementVisible(driver, Common_DrapDrop_UI.FORMAT_DEFAULT_RADIOBUTTON);
		String valueFormat = getElementAttribute(driver, Common_DrapDrop_UI.FORMAT_DEFAULT_RADIOBUTTON, "class");
		if (valueFormat.contains("rounded-sm")) {
			return true;
		}
		return false;
	}

	public boolean checkFormatCheckboxCF306() {
		waitForElementVisible(driver, CF306_ImageUI.ICON_FORMAT_FORM);
		String valueFormat = getElementAttribute(driver, CF306_ImageUI.ICON_FORMAT_FORM, "class");
		if (valueFormat.contains("rounded-sm")) {
			return true;
		}
		return false;
	}

	public boolean checkFormatCheckboxCF306Form() {
		waitForElementVisible(driver, Common_DrapDrop_UI.FORMAT_DEFAULT_RADIOBUTTON);
		String valueFormat = getElementAttribute(driver, Common_DrapDrop_UI.FORMAT_DEFAULT_RADIOBUTTON, "class");
		if (valueFormat.contains("rounded-sm")) {
			return true;
		}
		return false;
	}

	public void clickButtonCreateInput(String locator, String value, int times) {
		waitForElementVisible(driver, locator, value);
		for (int i = 0; i < times; i++) {
			clickToElement(driver, locator, value);
		}
	}

	public void clickButtonCreateInputField(String value, int times) {
		clickButtonCreateInput(Common_DrapDrop_UI.DYNAMIC_TITLE_TEXTLABEL_MENU, value, times);
	}

	public boolean checkCountInput(String locator, int n) {
		int countExpect = n + 3;
		int countInput = getListWebElement(driver, locator).size();
		System.out.println("So luong input: " + countInput);
		if (countInput == countExpect) {
			return true;
		}
		return false;
	}

	public boolean checkNumberInputField(int n) {
		return checkCountInput(Common_DrapDrop_UI.INPUT_FIELD_MENU, n);
	}

	public boolean checkNumberInputOptionCF303(int n) {
		return checkCountInput(Common_DrapDrop_UI.INPUT_FIELD_MENU, n);
	}

	public boolean checkNumberOptionCF306Form(int n) {
		return checkCountInput(CF306_ImageUI.PHOTO_FRAME_FORM, n);
	}

	public boolean numberForm(String locator, int numberExpect) {
		int countActual = getListWebElement(driver, locator).size();
		if (countActual == numberExpect) {
			return true;
		}
		return false;
	}

	public boolean numberPhotoFrame(int n) {
		return numberForm(CF306_ImageUI.PHOTO_FRAME_FORM, n);
	}

	public boolean numberValueOptionForm(int n) {
		return numberForm(CF306_ImageUI.OPTION_FORM, n);

	}

	public boolean compareOptionText(String locator, String value) {
		waitForElementVisible(driver, locator);
		String valueText = getElementText(driver, locator);
		if (valueText.equals(value)) {
			return true;
		}
		return false;
	}

	public boolean isCompareValueCF306Form(String valueEnter) {
		return compareOptionText(CF306_ImageUI.OPTION_FORM, valueEnter);
	}

	public boolean isCompareValueCF306Menu(String valueEnter) {
		return checkValueAtribute(Common_DrapDrop_UI.FIRST_INPUT_OPTION_MENU, valueEnter);
	}

	public void inputValueCF306Form(String valueEnter) {
		enterOptionForm(CF306_ImageUI.FIRST_OPTION_FORM, valueEnter);
	}

	public void clickOptionForm() {
		waitForElementClickable(driver, CF306_ImageUI.FIRST_OPTION_FORM);
		clickToElement(driver, CF306_ImageUI.FIRST_OPTION_FORM);
	}

	public void enterOptionForm(String locator, String valueEnter) {
		waitForElementVisible(driver, locator);
		sendkeyToElement(driver, locator, valueEnter);
	}

	public void clickImage() {
		waitForElementClickable(driver, CF306_ImageUI.PHOTO_FRAME_FORM);
		clickToElement(driver, CF306_ImageUI.PHOTO_FRAME_FORM);
	}

	public void uploadImg(String value) {
		sendkeyValueFirstToElement(driver, CF306_ImageUI.FIRST_INPUT_IMAGE, value);

	}

	public boolean isDisplayImage() {
		waitForElementVisible(driver, CF306_ImageUI.FIRST_IMAGE_FORM);
		return isElementDisplayed(driver, CF306_ImageUI.FIRST_IMAGE_FORM);
	}

	public void clickDelteFirstInput(String nameIcon) {
		waitForElementClickable(driver, Common_DrapDrop_UI.FIRST_DYNAMIC_ICON_FUNCTION, nameIcon);
		clickToElement(driver, Common_DrapDrop_UI.FIRST_DYNAMIC_ICON_FUNCTION, nameIcon);
	}

	public int countInput(String locator) {
		int countInput = getListWebElement(driver, locator).size();
		System.out.println("So luong input: " + countInput);
		return countInput;
	}

	public int countInputCF306() {
		return countInput(CF306_ImageUI.INPUT_MENU);
	}

	public boolean checkNumberInputOptionCF306(int n) {
		return checkCountInput(CF306_ImageUI.INPUT_MENU, n);
	}

	public int countInputAfterDeleteCF306() {
		return countInput(CF306_ImageUI.INPUT_MENU);
	}
//	public void isCheckInputAfterDelete() {
//		int numberInputActual = getListWebElement(driver, CF306_ImageUI.INPUT_MENU).size();
//		if (numberInputActual==countInput(getColorAdditionalExForm(), numberInputActual)) {
//			
//			
//		}
//		
//	}

	public boolean isDisplayToasError() {
		waitForElementVisible(driver, CF306_ImageUI.ERROR_TOAST_FILE_IMAGE);
		return isElementDisplayed(driver, CF306_ImageUI.ERROR_TOAST_FILE_IMAGE);
	}

	public boolean isSelectFormat() {
		waitForElementVisible(driver, CF307_SelectOptionUI.CHECKBOX_FORM);
		String valueFormat = getElementAttribute(driver, CF307_SelectOptionUI.CHECKBOX_FORM, "class");
		if (valueFormat.contains("rounded-sm")) {
			return true;
		}
		return false;
	}

	public void clickIconMove(String valueIcon, String valueComponent) {
//		clickToElement(driver, Common_DrapDrop_UI.ONE_COMPONENT_FORM,valueComponent);
		waitForElementClickable(driver, Common_DrapDrop_UI.DYNAMIC_ICON_FUNCTION,valueIcon);
		clickToElement(driver, Common_DrapDrop_UI.DYNAMIC_ICON_FUNCTION,valueIcon);
		
	}

	public boolean checkPositionAfterMove(String valueTitle, String valueIcon, String valueComponent) {
		clickToElement(driver, Common_DrapDrop_UI.ONE_COMPONENT_FORM,valueComponent);
		WebElement elementToMove = getWebElement(driver,Common_DrapDrop_UI.DYNAMIC_TITLE_COMPONENT_FORM, valueTitle);
		// Lưu vị trí ban đầu của phần tử
        int initialX = elementToMove.getLocation().getX();
        int initialY = elementToMove.getLocation().getY();
        System.out.println("X truoc: "+ initialX);
        System.out.println("Y truoc: "+initialY);

        // Di chuyển phần tử đến một vị trí mới không xác định trước
        clickIconMove(valueIcon, valueComponent);
        // Lưu vị trí mới của phần tử
        int newX = elementToMove.getLocation().getX();
        int newY = elementToMove.getLocation().getY();
        System.out.println("X sau: "+ newX);
        System.out.println("Y sau: "+newY);

        // Xác nhận rằng phần tử đã di chuyển (ít nhất một hướng)
        if(newY != initialY) {
        	return true;
        }
        return false;
	}

}
