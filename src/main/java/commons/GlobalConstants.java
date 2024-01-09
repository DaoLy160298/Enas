package commons;

import java.io.File;

public class GlobalConstants {
	//DEV
	public static final String PORTAL_DEV_URL = "https://form-build.dev.stack-product.com/auth/login/";
	public static final String STG_URL = "https://form-build.stg.stack-product.com/auth/login/";
	
	//TESTING
	public static final String PORTAL_TESTING_URL = "";
	public static final String ADMIN_TESTING_URL = "";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	
	
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoITScripts";
	
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "screenshotPath" + File.separator;
	
	
	public static final String DB_DEV_URL ="32.18.252.185:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "P@ssw0rld1!";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL= 3;
	public static final String DEV_FORM_EDIT = "https://form-build.dev.stack-product.com/survey/form-edit";
	public static final String STG_FORM_EDIT = "https://form-build.stg.stack-product.com/survey/form-edit/";
  }
