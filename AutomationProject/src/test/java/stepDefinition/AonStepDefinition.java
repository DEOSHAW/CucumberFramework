package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AonStepDefinition extends BaseStepDefinition
{
	@Given("AON portal is open")
	public void aon_portal_is_open() 
	{
	    driver.get("https://www.aon.com/en/");
	}
	@When("User navigates to insights page")
	public void user_navigates_to_insights_page() 
	{
		WebElement insightsLink=driver.findElement(By.xpath("//li[@class='global-header__mega-menu-item']/child::a[@href='/en/insights']"));
	    WebElement viewAllInsightsLink=driver.findElement(By.xpath("(//a[@aria-label='View All Insights'])[1]"));
	    actions.moveToElement(insightsLink).pause(Duration.ofSeconds(1)).click(viewAllInsightsLink).perform();
	}
	@Then("the title of the page on AON is {string}")
	public void the_title_of_the_page_on_aon_is(String pageTitle)
	{
		Assert.assertEquals(driver.getTitle(), pageTitle);
	    
	}

}
