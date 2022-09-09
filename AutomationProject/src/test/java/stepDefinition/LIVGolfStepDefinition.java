package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LIVGolfStepDefinition extends BaseStepDefinition{
	
	@Given("^LIV Golf portal is open$")
	public void liv_Golf_portal_is_open() throws Exception {
		
		driver.get("https://www.livgolf.com/");
	   
	}

	@When("^User finds the names of teams$")
	public void user_finds_the_names_of_teams() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'Teams And Players')]")).click();
	    
	}

	@Then("^list of Golf teams is displayed$")
	public void list_of_Golf_teams_is_displayed() throws Exception {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[text()='Teams']")));
		List<WebElement> teams=driver.findElements(By.xpath("//*[contains(@class,'TournamentsTeamsDraft_logo')]/following::div[1]"));
		
		for(WebElement team:teams)
		{
			System.out.println(team.getText());
		}
	    
	}

}
