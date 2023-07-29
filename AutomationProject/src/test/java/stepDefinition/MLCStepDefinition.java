package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MLCStepDefinition extends BaseStepDefinition{
	
	@Given("^MLC portal is open$")
	public void mlc_portal_is_open() throws Exception {
	    driver.navigate().to("https://www.majorleaguecricket.com/");
	}

	@When("^User navigates to Team standing section$")
	public void user_navigates_to_Team_standing_section() throws Exception {
		WebElement standingsLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".standings__heading")));
	    js.executeScript("arguments[0].scrollIntoView();", standingsLabel);
	}

	@Then("^the team standings is displayed$")
	public void the_team_standings_is_displayed() throws Exception {
	    for(int i=2;i<=7;i++)
	    {
	    	for(int j=1;j<=8;j++)
	    	{
	    		System.out.print(driver.findElement(By.xpath("//*[@class='standings__table']//tr["+i+"]//td["+j+"]")).getText()+"  ");
	    	}
	    	System.out.println();
	    }
	}


}
