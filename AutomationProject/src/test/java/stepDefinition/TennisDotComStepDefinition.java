package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.TennisDotCom;

public class TennisDotComStepDefinition extends BaseStepDefinition
{
	static String actualErrorMessage;
	TennisDotCom ob=new TennisDotCom(driver);
	@Given("User is on tennisdotcom portal")
	public void user_is_on_tennisdotcom_portal() 
	{
	    driver.get("https://www.tennis.com/");
	}
	@When("User clicks on user icon link")
	public void user_clicks_on_user_icon_link() 
	{
	  ob.clickOnUserIcon();
	}
	
	@Then("error message {string} is displayed")
	public void error_message_is_displayed(String expectedErrorMessage)
	{
	    Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	
	@When("User logs in with {string} and {string}")
	public void user_logs_in_with_and(String user, String pwd)
    {
		actualErrorMessage=ob.login(user, pwd);
	    
	}

}
