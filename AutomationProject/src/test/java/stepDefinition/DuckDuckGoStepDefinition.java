package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DuckDuckGoStepDefinition extends BaseStepDefinition {
	
	@Given("^DuckDuckGo is open$")
	public void duckduckgo_is_open() throws Exception {
	   driver.get("https://duckduckgo.com/");
	}

	@When("^user searches for \"([^\"]*)\" on the DuckDuckGo site$")
	public void user_searches_for_on_the_DuckDuckGo_site(String Term) throws Exception {
		WebElement searchBox=driver.findElement(By.xpath("//*[@name='q']"));
		searchBox.sendKeys(Term);
	    actions.sendKeys(Keys.ENTER).perform();
	    Thread.sleep(2500);
	}

	@Then("^the results are displayed on DuckDuckGo$")
	public void the_results_are_displayed_on_DuckDuckGo() throws Exception {
	   List<WebElement> topResults=driver.findElements(By.xpath("//*[@target='_self']"));
	   Iterator<WebElement> itr=topResults.iterator();
	   while(itr.hasNext())
	   {
		   System.out.println(itr.next().getText());
	   }
	   
	}



}
