package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Formula1StepDefinition extends BaseStepDefinition
{
	@Given("Formula1 portal is open")
	public void formula1_portal_is_open() 
	{
	    driver.get("https://www.formula1.com/");
	    driver.switchTo().frame("sp_message_iframe_1033523");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='ACCEPT ALL']"))).click();
		driver.switchTo().defaultContent();
	}
	@When("User hovers over teams menu")
	public void user_hovers_over_teams_menu()
	{
	   WebElement teamsLink= driver.findElement(By.xpath("(//span[text()='Teams'])[1]"));
	   actions.click(teamsLink).perform();
	}
	@Then("Team names are displayed")
	public void team_names_are_displayed() throws InterruptedException 
	{
	    List<WebElement> allTeams=driver.findElements(By.cssSelector("span.f1-color--black"));
	    for(WebElement team:allTeams)
	    {
	    	System.out.println(js.executeScript("return arguments[0].innerHTML;", team));
	    	Thread.sleep(1000);
	    }
	    
	}




}
