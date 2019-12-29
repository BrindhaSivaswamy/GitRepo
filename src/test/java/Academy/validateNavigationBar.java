package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.qaclickLoginPage;
import resources.Base;

public class validateNavigationBar extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	

	@BeforeTest
	public void initialize() throws IOException {
	driver= initializeDriver();
	log.info("Driver initialized");
	driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavigation() throws IOException
	{
	
	qaclickLoginPage pg=new qaclickLoginPage(driver);
	Assert.assertTrue(pg.navigateBar().isDisplayed());
	log.info("Page Navigated");
	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
