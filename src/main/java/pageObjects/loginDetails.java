package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginDetails {

	public WebDriver driver;
	public loginDetails(WebDriver driver) {
		
		this.driver=driver;
	}
	
	private By Email =By.xpath("//input[@id='user_email']");
	private By Password=By.xpath("//input[@id='user_password']");
	private By Submit= By.xpath("//input[@name='commit']");
	
	
	
	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(Submit);
	}
	

}
