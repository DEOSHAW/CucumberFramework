package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CricbuzzStepDefinition extends BaseStepDefinition
{
	
	@Given("Cricbuzz portal is open")
	public void cricbuzz_portal_is_open() 
	{
	    driver.get("https://www.cricbuzz.com/");
	}
	@When("User hovers over Teams menu")
	public void user_hovers_over_teams_menu() 
	{
	    actions.moveToElement(driver.findElement(By.xpath("//a[@title='Cricket Teams']"))).perform();
	}
	@Then("all the test teams are displayed")
	public void all_the_test_teams_are_displayed() 
	{
	    List<WebElement> testTeams=driver.findElements(By.xpath("//a[text()='Test Teams']/../child::div/a"));
	    Assert.assertEquals(testTeams.size(), 12);
	    Assert.assertEquals(testTeams.get(4).getText(), "Australia");
	}
}
