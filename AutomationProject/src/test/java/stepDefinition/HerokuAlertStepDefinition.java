package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HerokuAlertStepDefinition extends BaseStepDefinition
{
	@Given("User is on Heroku Alert portal")
	public void user_is_on_heroku_alert_portal() 
	{
	    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	@When("User clicks on alert button on Heroku alert portal")
	public void user_clicks_on_alert_button_on_heroku_alert_portal() {
	    driver.findElement(RelativeLocator.with(By.xpath("//button[text()='Click for JS Alert']"))
	    		.above(By.xpath("//button[text()='Click for JS Confirm']"))).click();
	   
	}
	@Then("success alert handling message is displayed on Heroku alert portal")
	public void success_alert_handling_message_is_displayed_on_heroku_alert_portal() throws InterruptedException 
	{
	    Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	    alert.accept();
	    Thread.sleep(500);
	    Assert.assertEquals(driver.findElement(By.cssSelector("#result")).getText(), "You successfully clicked an alert");
	}

}
