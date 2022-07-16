package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AFLStepDefinition extends BaseStepDefinition {
	
	@Given("^AFL portal is open$")
	public void afl_portal_is_open() throws Exception {
	    driver.get("https://www.afl.com.au/");
	}

	@When("^user navigates to Teams' rankings page$")
	public void user_navigates_to_Teams_rankings_page() throws Exception {
	    WebElement statsLink=driver.findElement(By.xpath("(//*[contains(@class,'navigation__drop-down')])[3]"));
	    WebElement teamRankings=driver.findElement(By.xpath("//*[contains(@href,'/stats/team-rankings')]"));
	    actions.moveToElement(statsLink).click(teamRankings).perform();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='static-header static-header--rankings']")));
	}

	@Then("^the rankings is displayed$")
	public void the_rankings_is_displayed() throws Exception {
	    int rowNum=driver.findElements(By.xpath("//*[@class='team-rankings__table']//tbody//tr")).size();
	    int colNum=driver.findElements(By.xpath("//*[@class='team-rankings__table']//tbody//tr[2]//td")).size();
	    js.executeScript("return document.readyState").equals("complete");
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(1500);
	    js.executeScript("window.scrollBy(200,0)");
	    Thread.sleep(1500);
	    
	    for(int i=2;i<=rowNum;i++)
	    {
	    	for(int j=1;j<=colNum;j++)
	    	{
	    		System.out.print(driver.findElement(By.xpath("//*[@class='team-rankings__table']//tbody//tr["+i+"]//td["+j+"]")).getText().trim()+"  ");
	    	}
	    	System.out.println();
	    }
	}



}
