package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HackerRankSignupStepDefinition extends BaseStepDefinition {
	
	@Given("^Hacker Rank sign up page is open$")
	public void hacker_Rank_sign_up_page_is_open() throws Exception {
	    driver.get("https://www.hackerrank.com/");
	}

	@When("^user clicks on signup button$")
	public void user_clicks_on_signup_button() throws Exception {
	    driver.findElement(By.xpath("(//*[@class='fl-button'])[2]")).click();
	}

	@When("^user enters folowing details on the page$")
	public void user_enters_folowing_details_on_the_page(DataTable table) throws Exception {
	    
	   List<List<String>> data=table.asLists(String.class);
	   driver.findElement(By.xpath("//*[@aria-label='First & Last name']")).sendKeys(data.get(1).get(0));
	   driver.findElement(By.xpath("//*[@aria-label='Email']")).sendKeys(data.get(0).get(1));
	   driver.findElement(RelativeLocator.with(By.xpath("//*[@aria-label='Your password']")).below(By.xpath("//*[@aria-label='Email']"))).sendKeys(data.get(0).get(2));
	   //driver.findElement(By.xpath("//*[@aria-label='Your password']")).sendKeys(data.get(0).get(2));
	   
	 
	    
	}
	
	@When("^user enters folowing details on the web page$")
	public void user_enters_folowing_details_on_the_web_page(DataTable table) throws Exception {
	    List<Map<String,String>> map=table.asMaps(String.class, String.class);
	    driver.findElement(By.xpath("//*[@aria-label='First & Last name']")).sendKeys(map.get(0).get("Name"));
		   driver.findElement(By.xpath("//*[@aria-label='Email']")).sendKeys(map.get(1).get("Email"));
		   driver.findElement(RelativeLocator.with(By.xpath("//*[@aria-label='Your password']")).below(By.xpath("//*[@aria-label='Email']")))
		   .sendKeys(map.get(0).get("Password"));
	    
	}

	@Then("^the signup is completed$")
	public void the_signup_is_completed() throws Exception {
	    Thread.sleep(2500);
	}


	
	

}
