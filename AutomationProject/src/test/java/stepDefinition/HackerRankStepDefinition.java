package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HackerRankStepDefinition extends BaseStepDefinition {
	
	WebDriverWait wait;
	WebElement motto;
	
	@Given("^HackerRank portal is launched$")
	public void hackerrank_portal_is_launched() throws Exception {
	    driver.get("https://www.hackerrank.com/");
	}

	@When("^user validates the presence of Element$")
	public void user_validates_the_presence_of_Element() throws Exception {
	  wait=new WebDriverWait(driver, 5);
	  motto=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='fl-heading-text'])[1]")));
	  
	}

	@Then("^the motto is extracted$")
	public void the_motto_is_extracted() throws Exception {
	    System.out.println(motto.getText());
	}


}
