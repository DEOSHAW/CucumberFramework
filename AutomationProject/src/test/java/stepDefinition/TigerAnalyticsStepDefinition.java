package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TigerAnalyticsStepDefinition extends BaseStepDefinition
{
	@Given("User is on Tiger Analytics website")
	public void user_is_on_tiger_analytics_website() 
	{
	    driver.get("https://www.tigeranalytics.com/");
	}
	@When("User hovers over industries menu link")
	public void user_hovers_over_industries_menu_link() 
	{
	    WebElement industriesMenuLink=driver.findElement(By.xpath("//a[@href='/impact/industries/' and @class='mega-menu-link']"));
	    actions.moveToElement(industriesMenuLink).perform();
	}
	@Then("industry domain Tiger Analytics works on get listed")
	public void industry_domain_tiger_analytics_works_on_get_listed() 
	{
	    List<WebElement> ISUs=driver.findElements(By.xpath("//div[@class='impact-sub-link']//a[contains(@href,'/impact/industries')]"));
	    Assert.assertEquals(ISUs.get(3).getText(), "Insurance");
	}

}
