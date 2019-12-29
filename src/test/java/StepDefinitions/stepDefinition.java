package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import pageObjects.HomePortalLogin;
import pageObjects.loginDetails;
import pageObjects.qaclickLoginPage;
import resources.Base;

import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefinition extends Base{

    @Given("^Intialize the driver with chrome$")
    public void intialize_the_driver_with_chrome() throws Throwable {
    	driver= initializeDriver();
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^Click on login link to land on secure sign in page$")
    public void click_on_login_link_to_land_on_secure_sign_in_page() throws Throwable {
    	qaclickLoginPage pg=new qaclickLoginPage(driver);
    	if(pg.getpopUpSize().size()>0)
    	{
    		pg.getpopUp().click();
    	}
	
    	pg.Login().click();
    }

    @When("^user enters (.+) and (.+)$")
    public void user_enters_and(String username, String password) throws Throwable {
    	loginDetails lg=new loginDetails(driver);
    	lg.Email().sendKeys(username);
		lg.Password().sendKeys(password);
		lg.Submit().click();
    }

    @Then("^Verify user is succesfully logged on$")
    public void verify_user_is_succesfully_logged_on() throws Throwable {
       HomePortalLogin hp=new HomePortalLogin(driver);
       Assert.assertTrue(hp.getSearchBox().isDisplayed());
    }

    @And("^close browsers$")
    public void close_browsers() throws Throwable {
       driver.quit();
    }
   

}