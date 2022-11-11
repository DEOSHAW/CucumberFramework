package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QatarWorldCupStepDefinition extends BaseStepDefinition {
	
	@Given("^FIFA world cup portal is open$")
	public void fifa_world_cup_portal_is_open() throws Exception {
	   driver.get("https://www.qatar2022.qa/en");
	}

	@When("^User navigates to the new page$")
	public void user_navigates_to_the_new_page() throws Exception {
	   driver.findElement(By.xpath("(//a[contains(text(),'News Hub')])[1]")).click();
	}

	@Then("^the trending news is displayed$")
	public void the_trending_news_is_displayed() throws Exception {
	   String newsText= driver.findElement(By.xpath("(//div[@class='card-image__description'])[1]/child::p")).getText();
	   System.out.println(newsText);
	}



}
