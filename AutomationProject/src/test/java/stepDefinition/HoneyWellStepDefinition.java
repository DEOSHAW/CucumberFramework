package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HoneyWellStepDefinition extends BaseStepDefinition {
	
	@Given("^Honeywell portal is launched$")
	public void honeywell_portal_is_launched() throws Exception {
	    driver.get("https://www.honeywell.com/us/en");
	}

	@When("^user navigates to the history page$")
	public void user_navigates_to_the_history_page() throws Exception {
	   driver.findElement(By.xpath("//a[text()='Company']")).click();
	   driver.findElement(By.xpath("//span[text()='History']")).click();
	   
	   
	}

	@Then("^the History is displayed$")
	public void the_History_is_displayed() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='The History of']")));
		WebElement historyText=driver.findElement(By.xpath("//p[contains(text(),'Considered the official')]"));
		js.executeScript("arguments[0].scrollIntoView();", historyText);
		js.executeScript("alert(arguments[0])", historyText.getText());
		Thread.sleep(3500);
		
		
	}



}
