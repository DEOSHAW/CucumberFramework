package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SixNationsStepDefinition extends BaseStepDefinition
{
	@Given("User is on six nations portal")
	public void user_is_on_six_nations_portal() 
	{
	    driver.get("https://www.sixnationsrugby.com/en");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#onetrust-accept-btn-handler"))).click();
	}
	@When("User clicks on {string}")
	public void user_clicks_on(String championship)
	{
	    driver.findElement(By.xpath("//a[contains(@title,'"+championship+"')]")).click();
	}
	@Then("User is redirected to the {string}")
	public void user_is_redirected_to_the(String pageUrl)
	{
	    Assert.assertTrue(driver.getCurrentUrl().contains(pageUrl));
	}




}
