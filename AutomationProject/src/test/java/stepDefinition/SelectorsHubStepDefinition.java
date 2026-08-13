package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SelectorsHubStepDefinition extends BaseStepDefinition
{
	@Given("Selectors hub portal is open")
	public void selectors_hub_portal_is_open() 
	{
	   driver.get("https://selectorshub.com/iframe-in-shadow-dom/"); 
	}
	@Then("User types destiny inside shadow dom")
	public void user_types_destiny_inside_shadow_dom() throws InterruptedException 
	{
	    WebElement parentFrame=driver.findElement(By.id("userName")).getShadowRoot().findElement(By.id("pact1"));
	    driver.switchTo().frame(parentFrame);
	    driver.switchTo().frame("pact3");
	    driver.findElement(By.cssSelector("#glaf")).sendKeys("Test Destiny");
	    Thread.sleep(3000);
	}
}
