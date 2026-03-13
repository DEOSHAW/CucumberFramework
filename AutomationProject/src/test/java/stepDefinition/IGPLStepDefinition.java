package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IGPLStepDefinition extends BaseStepDefinition
{
	
	@Given("IGPL portal is open")
	public void igpl_portal_is_open()
	{
	   driver.get("https://theigpl.com/"); 
	}
	@When("User clicks on standings link")
	public void user_clicks_on_standings_link() 
	{
	    driver.findElement(RelativeLocator.with(By.xpath("//a[contains(@href,'standings')]"))
	    		.toLeftOf(By.xpath("//nav[@id='navLinksDesktop']//a[contains(@href,'/leaderboard')]"))).click();
	}
	@Then("User is navigated to the standings page")
	public void user_is_navigated_to_the_standings_page() 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("standings"));
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
	    Assert.assertTrue(currentUrl.contains("standings"));
	}

}
