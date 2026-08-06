package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UefaStepDefinition extends BaseStepDefinition
{
	@Given("User is on Uefa portal")
	public void user_is_on_uefa_portal() 
	{
	    driver.get("https://www.uefa.com/");
	    driver.findElement(By.cssSelector("span#cmpbntnotxt")).click();
	}
	@When("User clicks on national associations link")
	public void user_clicks_on_national_associations_link() 
	{
	    driver.findElement(By.xpath("//span[text()='National associations']")).click();
	}
	@Then("all the national associations are listed")
	public void all_the_national_associations_are_listed() 
	{
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.uefa.com/nationalassociations/");
	    Assert.assertEquals(driver.findElements(By.cssSelector("a.team-wrap")).size(), 55);
	}

}
