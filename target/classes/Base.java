package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;


public class Base {
	
	public static WebDriver driver; 
	public Properties prop;
	
	@Test
	public WebDriver initializeDriver() throws IOException
	{
		
		prop=new Properties(); //Create properties object to access the global variables in properties file
		
		//System.getProperty("user.dir") - gives the root path of the current project
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalFile.properties");
		prop.load(fis);
		 
		
		//String browserName=System.getProperty("browserName");
		String browserName =prop.getProperty("browser");
		
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		//options.setHeadless(true); //Headless mode - While running we cant see  the chrome browser, it runs in the background
		}
		 driver = new ChromeDriver(options);

	}
	
	else if (browserName.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		
		 driver = new FirefoxDriver();
	}
		
	else 
	{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\MicrosoftWebDriver.exe");
		
		 driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Wait till 10 seconds before failing, for all applications*/
	return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\haffl\\Desktop\\Brindha\\screenshots\\"+result+" Screenshot1.png"));
	
	}

}
