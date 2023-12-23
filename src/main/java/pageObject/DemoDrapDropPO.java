package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Demo_DrapDrpp_UI;

public class DemoDrapDropPO extends BasePage{
	private WebDriver driver;

	public DemoDrapDropPO(WebDriver driver) {
		this.driver = driver;
	}

	public void drapAndDropPosition(String nameComponent) {
		//waitForElementClickable(driver, Demo_DrapDrpp_UI.DYNAMIC_DRAP_OR_ADD_COMPONENT_MENU,nameComponent);
		drapAndDropComponent(driver, Demo_DrapDrpp_UI.DYNAMIC_DRAP_OR_ADD_COMPONENT_MENU, Demo_DrapDrpp_UI.DROP_POSITION, nameComponent);
		
	}
	
}
