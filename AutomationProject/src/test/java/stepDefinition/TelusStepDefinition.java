package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TelusStepDefinition extends BaseStepDefinition
{
	@Given("Telus portal is open")
	public void telus_portal_is_open() 
	{
	   driver.get("https://www.telusinternational.com/");	
	}
	@When("User clicks on Careers link")
	public void user_clicks_on_careers_link() throws InterruptedException 
	{
		driver.findElement(By.xpath("//span[text()='Careers']")).click();
		Thread.sleep(2000);
	    
	}
	@Then("User navigates to Careers page on Telus portal")
	public void user_navigates_to_careers_page_on_telus_portal() 
	{
		String currentPage=driver.getTitle();
		System.out.println(currentPage);
		Assert.assertTrue(currentPage.contains("Just a moment"));
	}




}
