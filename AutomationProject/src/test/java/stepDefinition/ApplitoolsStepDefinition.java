package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplitoolsStepDefinition extends BaseStepDefinition
{
	@Given("Applitools portal is open")
	public void applitools_portal_is_open() 
	{
	    driver.get("https://applitools.com/");
	}
	@When("User clicks on Free Trial link")
	public void user_clicks_on_free_trial_link()
	{
		
		
		driver.findElement(RelativeLocator.with(By.xpath("//a[text()='Free Trial']"))
				.toRightOf(By.xpath("//ul[@id='utility-menu']//a[text()='Login']"))).click();
	}
	@Then("User lands on the sign up page")
	public void user_lands_on_the_sign_up_page() 
	{
	    WebElement signUpHeader=driver.findElement(By.tagName("h1"));
	    String signUpHeaderText=wait.until(ExpectedConditions.visibilityOf(signUpHeader)).getText();
	    Assert.assertEquals(signUpHeaderText, "Sign up for a free account today!");
	}




}
