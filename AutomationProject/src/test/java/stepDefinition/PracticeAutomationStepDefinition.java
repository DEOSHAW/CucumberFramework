package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeAutomationStepDefinition extends BaseStepDefinition
{
	@Given("User is on Practice Automation portal")
	public void user_is_on_practice_automation_portal() 
	{
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	@When("User logs in with below")
	public void user_logs_in_with_below(io.cucumber.datatable.DataTable dataTable) 
	{
		List<Map<String, String>> dataList=dataTable.asMaps(String.class, String.class);
		driver.findElement(By.cssSelector("input#username")).sendKeys(dataList.get(0).get("userName"));
		driver.findElement(By.cssSelector("input#password")).sendKeys(dataList.get(0).get("password"));
		driver.findElement(RelativeLocator.with(By.cssSelector("button#submit")).below(By.cssSelector("input#password"))).click();
	}
	@Then("login is successful on practice automation portal")
	public void login_is_successful_on_practice_automation_portal() 
	{
	    Assert.assertEquals(driver.findElement(By.cssSelector("h1.post-title")).getText(), "Logged In Successfully");
	}

}
