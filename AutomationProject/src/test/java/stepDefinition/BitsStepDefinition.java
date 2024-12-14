package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BitsStepDefinition extends BaseStepDefinition
{
	@Given("Bits portal is open")
	public void bits_portal_is_open() {
		driver.get("https://www.bits-pilani.ac.in/");
	    
	}
	@When("User clicks on about link")
	public void user_clicks_on_about_link() {
		driver.findElement(RelativeLocator.with(By.xpath("//a[text()='ABOUT']")).near(By.xpath("(//a[text()='WILP'])[1]"))).click();
	    
	}
	@Then("Bits information is displayed")
	public void bits_information_is_displayed() throws InterruptedException {
	    js.executeScript("alert(arguments[0])", driver.findElement(By.xpath("//span[contains(text(),'The Birla Institute of Technology')]")).getText());
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(500);
	}




}
