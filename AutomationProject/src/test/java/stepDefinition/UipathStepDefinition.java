package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UipathStepDefinition extends BaseStepDefinition {
	
	@When("^UIPath site is open$")
	public void uipath_site_is_open() throws Throwable {
		
		driver.get("https://www.uipath.com/");
	}
	
	@Then("^Validate UIPath motto$")
	public void validate_UIPath_motto() throws Throwable {
    String Text=(String) js.executeScript("return arguments[0].innerHTML", driver.findElement(By.xpath("//*[@class='HomepageRebooted-promoItemDesc']/span")));
    js.executeScript("alert(arguments[0])", Text);
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    Thread.sleep(2000);
    driver.close();
	}

	



}
