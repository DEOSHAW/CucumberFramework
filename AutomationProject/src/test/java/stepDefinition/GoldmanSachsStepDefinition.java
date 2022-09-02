package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoldmanSachsStepDefinition extends BaseStepDefinition {
	
	@Given("^Goldman Sachs portal is open$")
	public void goldman_Sachs_portal_is_open() throws Exception {
	    driver.get("https://www.goldmansachs.com/");
	}

	@When("^User navigates to Overview section$")
	public void user_navigates_to_Overview_section() throws Exception {
	    driver.findElement(By.xpath("(//button[@data-type='hamburger'])[1]")).click();
	    driver.findElement(By.xpath("(//a[@aria-label='About Us'])[1]")).click();
	}

	@Then("^Goldman Sachs company overview is displayed$")
	public void goldman_Sachs_company_overview_is_displayed() throws Exception {
	    WebElement overviewTextElement=driver.findElement(By.xpath("//p[starts-with(text(),'The Goldman Sachs Group')]"));
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", overviewTextElement);
	    Thread.sleep(2500);
	    
	}



}
