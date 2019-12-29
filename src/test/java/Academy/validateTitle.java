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

public class validateTitle extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver= initializeDriver();
	log.info("Driver initialized");
	
	driver.get(prop.getProperty("url"));
	
	
	}
	
	@Test
	public void validateAppTitle() throws IOException
	{
		qaclickLoginPage pg=new qaclickLoginPage(driver);
		Assert.assertEquals(pg.getTitle().getText(),"FEATURED COURSES");
		Assert.assertTrue(pg.navigateBar().isDisplayed());
		log.info("Text Displayed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null; //To avoid the usage of memory
	}
}
