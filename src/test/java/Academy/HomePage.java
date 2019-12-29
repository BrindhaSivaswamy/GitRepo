package Academy;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.loginDetails;
import pageObjects.qaclickLoginPage;
import resources.Base;	

public class HomePage extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver= initializeDriver();
	log.info("Driver initialized");

	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		qaclickLoginPage pg=new qaclickLoginPage(driver);
		pg.Login().click();
		loginDetails lg=new loginDetails(driver);
		lg.Email().sendKeys(username);
		lg.Password().sendKeys(password);
		lg.Submit().click();
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		//Rows stands for how many different data
		//Columns stand for how many values for each test
		Object[][] data=new Object[2][2];
		
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="12345";
		//data[0][2]="nonrestricted user";
		
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="89556";
		//data[1][2]="restricted user";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
