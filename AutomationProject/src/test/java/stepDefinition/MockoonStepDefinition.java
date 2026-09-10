package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MockoonStepDefinition extends BaseStepDefinition
{
	@Given("Mockoon portal is open")
	public void mockoon_portal_is_open() 
	{
	    driver.get("https://mockoon.com/");
	}
	@When("User clicks on {string} link")
	public void user_clicks_on_link(String string) throws InterruptedException 
	{
		WebElement viewTutorialsLink=driver.findElement(By.xpath("//a[@href='/tutorials/' and text()='View all tutorials']"));
		js.executeScript("arguments[0].scrollIntoView();", viewTutorialsLink);
		js.executeScript("arguments[0].click();", viewTutorialsLink);
		wait.until(ExpectedConditions.urlContains("/tutorials/"));
	}
	@Then("User is navigated to Mockoon tutorial page")
	public void user_is_navigated_to_mockoon_tutorial_page()
	{
	    Assert.assertEquals(driver.getCurrentUrl(), "https://mockoon.com/tutorials/");
	}

}
