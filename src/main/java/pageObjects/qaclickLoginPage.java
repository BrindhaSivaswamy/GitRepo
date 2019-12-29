package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class qaclickLoginPage {
	
	WebDriver driver;

	private By Login= By.cssSelector("a[href*='sign_in']");
	private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navigate=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By popUp=By.xpath("//button[text()='NO THANKS']");
	
	public qaclickLoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement Login()
	{
		return	driver.findElement(Login);
		
	}
	
	public WebElement getTitle()
	{
		return	driver.findElement(title);
		
	}
	
	public WebElement navigateBar()
	{
		return	driver.findElement(navigate);
		
	}
	public WebElement getpopUp()
	{
		return driver.findElement(popUp);
	}
	
	public List<WebElement> getpopUpSize()
	{
		return driver.findElements(popUp);
	}
}
