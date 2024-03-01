package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MercuryTourStepDefinition extends BaseStepDefinition
{
	
	@Given("Mercury tour portal is open")
	public void mercury_tour_portal_is_open()
	{
	    driver.get("https://demo.guru99.com/test/newtours/index.php");
	}
	@When("User navigates to flights page")
	public void user_navigates_to_flights_page() throws InterruptedException 
	{
		driver.findElement(By.xpath("//a[text()='Flights']")).click();
		Thread.sleep(2000);
	   
	}
	@When("User searches for flights on Mercury tour portal")
	public void user_searches_for_flights_on_mercury_tour_portal() 
	{
		//driver.switchTo().frame("ad_iframe");
		//driver.findElements(By.xpath("//*[local-name()='svg']")).get(0).click();
		driver.switchTo().defaultContent();
		Select sourceLocationDropdown=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		sourceLocationDropdown.selectByValue("London");
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	  
	}
	@Then("the search result for flights is displayed")
	public void the_search_result_for_flights_is_displayed() 
	{
		System.out.println(driver.findElement(By.xpath("(//font[@size=4])[1]")).getText());
	   
	}

}
