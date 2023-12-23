package commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	private String projectPath = System.getProperty("user.dir");
	String authenFirefox = projectPath + "\\autoITScripts\\authen_firefox.exe";
	String authenChrome = projectPath + "\\autoITScripts\\authen_chrome.exe";
	String username = "admin";
	String password = "@2023Enas";
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}


	protected WebDriver getBrowserDriver(String browserName) throws IOException {
		System.out.println("Run on " + browserName);
		if (browserName.equals("firefox")) {
			
			//Add extension to Firefox
			FirefoxProfile profile = new FirefoxProfile();
			File translate = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\to_google_translate-4.2.0.xpi");
			profile.addExtension(translate);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			options.setProfile(profile);
			
			driver = new FirefoxDriver(options);
			
		} else if (browserName.equals("h_firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			//Add extension to Chrome
			
//			  String pathToExtension = ".\\libAdBlock\\AdBlock-best-ad-blocker.crx";
			File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\google-translate.crx");
			ChromeOptions options = new ChromeOptions();
//			options.addExtensions(new File(pathToExtension));
			driver = new ChromeDriver(options);
		} else if (browserName.equals("h_chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invaid");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.manage().window().maximize();
		//Method 1: User Auto Authen
//		if (driver.toString().contains("firefox")) {
//			// Runtime.getRuntime().exec: thuc thi 1 file exe trong code Java
//			Runtime.getRuntime().exec(new String[] { authenFirefox, username, password });
//		} else if (driver.toString().contains("chrome")) {
//			Runtime.getRuntime().exec(new String[] { authenChrome, username, password });
//		}
//		driver.get(GlobalConstants.PORTAL_DEV_URL);
		
		//Method 2: User pass Auto
		driver.get(passUserAndPassToUrl(GlobalConstants.PORTAL_DEV_URL, username, password));
		
		return driver;

	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		System.out.println("Run on " + browserName);
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invaid");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
//		driver.get(getEnvironmentUrl(environmentName));
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;

	}
	public String passUserAndPassToUrl(String url,String userName, String password) {
		String[] arrayUrl = url.split("//");
		return arrayUrl[0] + "//" + userName + ":" + password + "@" + arrayUrl[1];
	}
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}

	protected String getEnvironmentUrl(String environmentName) {
		String url = null;
		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());
		switch (environment) {
		case DEV:
			url = GlobalConstants.PORTAL_DEV_URL;
			break;
		case TESTING:
			url = GlobalConstants.PORTAL_TESTING_URL;
			break;
		}
		return url;
	}

	protected int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("------------True------------");
		} catch (Throwable e) {
			log.info("------------Failed----------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("------------True------------");
		} catch (Throwable e) {
			log.info("------------Failed----------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("------------True------------");
		} catch (Throwable e) {
			log.info("------------Failed----------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getToday() {
		return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
}