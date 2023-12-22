package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CiscoStepDefinition extends BaseStepDefinition
{
	
	@Given("Cisco portal is open")
	public void cisco_portal_is_open() 
	{
	   driver.get("https://www.cisco.com/site/in/en/index.html");
	}
	@When("User clicks on Site map link")
	public void user_clicks_on_site_map_link() 
	{
	   WebElement sitemapLink=driver.findElement(By.xpath("//a[text()='Sitemap']"));
	   js.executeScript("arguments[0].scrollIntoView();", sitemapLink);
		js.executeScript("arguments[0].click();", sitemapLink);
		
	}
	@Then("Site map page is displayed")
	public void site_map_page_is_displayed()
	{
		
		WebElement sitemapHeading=driver.findElement(By.tagName("h1"));
        wait.until(ExpectedConditions.visibilityOf(sitemapHeading));
		Assert.assertEquals( sitemapHeading.getText(), "Explore Cisco");
		
	}

}
