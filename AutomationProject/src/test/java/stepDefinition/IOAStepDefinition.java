package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IOAStepDefinition extends BaseStepDefinition
{
	@Given("IOA portal is open")
	public void ioa_portal_is_open() 
	{
	    driver.get("https://olympics.com/ioc/overview");
	}
	@When("User navigates to terms and conditions page on IOA site")
	public void user_navigates_to_terms_and_conditions_page_on_ioa_site() 
	{
		WebElement termsOfService=driver.findElement(By.xpath("(//a[text()='Terms of Service'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", termsOfService);
		termsOfService.click();
	    
	}
	@Then("Terms and conditions is displayed")
	public void terms_and_conditions_is_displayed() 
	{
	    String actualTitle=driver.findElement(By.cssSelector("h1.section--title")).getText();
	    Assert.assertEquals(actualTitle, "TERMS OF SERVICE");
	}




}
