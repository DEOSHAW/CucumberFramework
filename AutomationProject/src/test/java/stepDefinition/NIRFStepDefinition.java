package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NIRFStepDefinition extends BaseStepDefinition
{
	@Given("User is on NIRF portal")
	public void user_is_on_nirf_portal() 
	{
	    driver.get("https://www.nirfindia.org/Home/Index");
	}
	@When("User navigates to NIRF about page")
	public void user_navigates_to_nirf_about_page() 
	{
	    driver.findElement(RelativeLocator.with(By.xpath("//a[string()='About NIRF']")).toRightOf(By.xpath("(//a[string()='Home'])[1]"))).click();
	}
	@Then("overview information is found on NIRF about page")
	public void overview_information_is_found_on_nirf_about_page()
	{
	    Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Overview");
	}

}
