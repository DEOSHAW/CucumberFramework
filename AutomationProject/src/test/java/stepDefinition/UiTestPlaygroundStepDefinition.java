package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UiTestPlaygroundStepDefinition extends BaseStepDefinition {
	WebElement nbspButton;
	@Given("^UI Testing Playground NBSP portal is open$")
	public void ui_Testing_Playground_NBSP_portal_is_open() throws Exception {
		
		driver.get("http://uitestingplayground.com/nbsp");
	    
	}

	@When("^User clicks on nbsp element$")
	public void user_clicks_on_nbsp_element() throws Exception {
		nbspButton=driver.findElement(By.xpath("//button[contains(text(),'Button')]"));
		Thread.sleep(1000);
	}

	@Then("^the button gets clicked$")
	public void the_button_gets_clicked() throws Exception {
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", nbspButton);
		Thread.sleep(1500);
	    
	}




}
