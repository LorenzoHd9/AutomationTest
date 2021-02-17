package HomeDepot.Suites;

import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import HomeDepot.Library.Utilities;

public class TestBase {
	public static WebDriver driver;
	private static String Os = System.getProperty("os.name").toLowerCase();
	
	/*private static WebDriver initWebDriver() throws IOException {
	Properties prop = new Properties();
	WebDriver driverInstace = null;
	FileInputStream fis = new FileInputStream("/data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	if(browserName == "chrome" && isWindows()) {
		driverPath = System.setProperty("webdriver.chrome.driver", "C:\\DRIVER\\chromedriver.exe");
		driverInstace = new ChromeDriver();
		driverInstace.manage().window().maximize();
	}
	else if(browserName =="chrome" && isUnix()) {
		driverPath = System.setProperty("webdriver.chrome.driver","C:\\DRIVER\\chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		driverInstace = new ChromeDriver(option);
	}
	else if(browserName=="firefox" && isWindows() ) {
		driverPath= System.setProperty("webdriver.gecko.driver","C:\\DRIVER\\geckodriver.exe");
		driverInstace = new ChromeDriver();
		driverInstace.manage().window().maximize();
	}
	else if (browserName=="firefox" && isUnix()) {
		driverPath = System.setProperty("webdriver.chrome.driver","C:\\DRIVER\\chromedriver");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions options = new FirefoxOptions();
        driverInstace = new FirefoxDriver(options);
        options.setBinary(firefoxBinary);
	}
	
	driverInstace.get(System.getProperty("Url"));
	return driverInstace;
	WebDriver driverInstace = null;
	return driverInstace;
}*/
	public static WebDriver getBrowser() {
		WebDriver driverInstace = null;
		if(isWindows()) {
			System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
			driverInstace = new ChromeDriver();
		    driverInstace.manage().window().maximize();
		}
		else if(isUnix()) {
			System.setProperty("webdriver.chrome.driver","\\chromedriver");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			driverInstace = new ChromeDriver(option);
		}
	    driverInstace.get("https://www.homedepot.com.mx/");
		return driverInstace;	
	}
	
	@BeforeTest
	public void launchBrowser()throws IOException {
		Utilities.cleanFolder();
	}
	@BeforeSuite
	public void beforeSuite()  {
		
	}
   @BeforeMethod
    public void beforeMethod() {
	   driver= getBrowser(); 
    }
   @AfterMethod
   public void afterMethod() {
	   driver.close();
       //long id = Thread.currentThread().getId();
       //System.out.println("After test-method. Thread id is: " + id);
   }
   public void takePicture(WebDriver driverT, String name, String nameTest) {
	   //File src=((TakesScreenshot)driverT).getScreenshotAs(OutputType.FILE);
	   System.out.println(nameTest);
   }
   
   private static boolean isWindows() {
       return (Os.indexOf("win") >= 0);
   }

   private static boolean isUnix() {
       return (Os.indexOf("nix") >= 0
               || Os.indexOf("nux") >= 0
               || Os.indexOf("aix") > 0);
   }
   
  
}
