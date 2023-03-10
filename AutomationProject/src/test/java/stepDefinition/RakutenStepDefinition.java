package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RakutenStepDefinition extends BaseStepDefinition {
	WebElement purpose;
	@Given("^Rakuten portal is launched$")
	public void rakuten_portal_is_launched() throws Exception {
	    driver.get("https://global.rakuten.com/corp/");
	}

	@When("^User navigates to purpose section$")
	public void user_navigates_to_purpose_section() throws Exception {
		
		purpose=driver.findElement(By.xpath("//span[contains(text(),'Rakuten')]/parent::p"));
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[contains(text(),'Rakuten')]/parent::p")));
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0,-200)");
	    Thread.sleep(3000);
	}

	@Then("^Rakuten contribution is displayed$")
	public void rakuten_contribution_is_displayed() throws Exception {
		
		System.out.println(purpose.getText());
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", purpose);
		
		Thread.sleep(3000);
		
	    
	}



}
