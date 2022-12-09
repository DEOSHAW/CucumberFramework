package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NationalLeagueStepDefinition extends BaseStepDefinition 
{
	
	@Given("^National League portal is open$")
	public void national_League_portal_is_open() throws Exception {
	    driver.get("https://www.thenationalleague.org.uk/");
	}

	@When("^User navigates to the news section$")
	public void user_navigates_to_the_news_section() throws Exception {
	    driver.findElement(By.xpath("(//*[@data-key='news_events' and contains(text(),'News')])[1]")).click();
	}

	@Then("^latest news regarding National League is displayed$")
	public void latest_news_regarding_National_League_is_displayed() throws Exception {
	    System.out.println(driver.findElement(By.xpath("(//*[normalize-space(@class)='news-tile__tagline'])[1]")).getText());
	}

	
	

}
