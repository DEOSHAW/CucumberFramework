package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OptumStepDefinition extends BaseStepDefinition {
	
	@Given("^Optum portal is open$")
	public void optum_portal_is_open() throws Exception {
	    driver.get("https://www.optum.com/");
	}

	@When("^user searches on Optum for \"([^\"]*)\"$")
	public void user_searches_on_Optum_for(String Term) throws Exception {
	    driver.findElement(By.xpath("(//*[@placeholder='Search'])[2]")).sendKeys(Term);
	    driver.findElement(By.xpath("(//*[@class='Icon Icon--magnifying_glass '])[1]")).click();
	}

	@Then("^the result is displayed on Optum portal$")
	public void the_result_is_displayed_on_Optum_portal() throws Exception {
		driver.switchTo().frame(0);
	    wait.until(ExpectedConditions.
	    		visibilityOfElementLocated(By.xpath("//*[normalize-space(text())='Optum Pay™ (formerly EPS)']")));
	}


}
