package commons;

import org.openqa.selenium.WebDriver;

import pageObject.CommonPO;
import pageObject.CommonPO2;
import pageObject.CommonDrapDropPO;
import pageObject.Login_ThirdPO;
import pageObject.UserRestPWCA300PO;
import pageObject.UserRestPWCA302PO;
import pageObject.UserLoginPO;
import pageObject.UserHomePO;
import pageObject.UserRegisterCA200PO;
import pageObject.UserRegisterCA201PO;
import pageObject.UserRegisterCA203PO;

public class PageGeneratorManager {
	public static UserLoginPO getUserLogin(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	public static UserHomePO getHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	public static UserRegisterCA200PO getUserRegisterCA200Page(WebDriver driver) {
		return new UserRegisterCA200PO(driver);
	}
	public static CommonPO getCommonPO(WebDriver driver) {
		return new CommonPO(driver);
	}
//	public static CommonPO2 getCommonPO2(WebDriver driver) {
//		return new CommonPO2(driver);
//	}
	public static UserRegisterCA201PO getUserRegisterCA201Page(WebDriver driver) {
		return new UserRegisterCA201PO(driver);
	}
	
	public static UserRestPWCA300PO getRestPWCA300Page(WebDriver driver) {
		return new UserRestPWCA300PO(driver);
	}
	
	public static UserRestPWCA302PO getRestPWCA302Page(WebDriver driver) {
		return new UserRestPWCA302PO(driver);
	}
	
	public static Login_ThirdPO login_ThirdPage(WebDriver driver) {
		return new Login_ThirdPO(driver);
	}
	public static UserRegisterCA203PO getUserRegisterCA203Page(WebDriver driver) {
		return new UserRegisterCA203PO(driver);
	}
	public static CommonDrapDropPO getCommonDrapDropPage(WebDriver driver) {
		return new CommonDrapDropPO(driver);
	}
}
