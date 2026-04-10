package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MastersGolfStepDefinition extends BaseStepDefinition
{
	@Given("User is on Masters Golf portal")
	public void user_is_on_masters_golf_portal() 
	{
	    driver.get("https://www.masters.com/index.html");
	}
	@When("User navigates to Sign Up link")
	public void user_navigates_to_sign_up_link() 
	{
	  driver.findElement(By.cssSelector("i.icon-account")).click();
	}
	@Then("Sign up link is enabled")
	public void sign_up_link_is_enabled() 
	{
	   
	    WebElement signUpLink=driver.findElement(RelativeLocator.with(By.cssSelector("div.login-wrapper>a:nth-child(1)"))
	    		.toLeftOf(By.xpath("//a[@href='/login/index.html']")));
	    Assert.assertTrue(signUpLink.isEnabled(),"Sign up link is not enabled");
	}

}
