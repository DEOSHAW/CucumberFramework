package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BundesligaStepDefinition extends BaseStepDefinition{
	
	@Given("^Bundesliga portal is launched$")
	public void bundesliga_portal_is_launched() throws Exception {
	    driver.get("https://www.bundesliga.com/en/bundesliga");
	}

	@When("^User navigates to FAQ page$")
	public void user_navigates_to_FAQ_page() throws Exception {
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	    driver.findElement(By.xpath("//*[normalize-space(text())='FAQ']")).click();
	}

	@Then("^FAQ is displayed$")
	public void faq_is_displayed() throws Exception {
	   System.out.println(driver.findElement(By.xpath("//p[contains(text(),'What is soccer')]")).getText()); 
	}


}
