package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePortalLogin {

	public WebDriver driver;
	public HomePortalLogin(WebDriver driver) {
		
		this.driver=driver;
	}
	
	private By Email =By.xpath("//input[@id='user_email']");
	private By searchBox=By.name("query");

	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	


}
