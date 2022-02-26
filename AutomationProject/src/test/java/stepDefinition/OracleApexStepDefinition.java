package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OracleApexStepDefinition extends BaseStepDefinition {
	WebElement infoText;
	@Given("^Oracle Apex portal is launched$")
	public void oracle_Apex_portal_is_launched() throws Exception {
	    driver.navigate().to("https://apex.oracle.com/en/");
	}

	@When("^user scrolls down the page$")
	public void user_scrolls_down_the_page() throws Exception {
		infoText=driver.findElement(By.xpath("//*[contains(text(),'Oracle Application Express (APEX)')]"));
	    js.executeScript("arguments[0].scrollIntoView();", infoText);
	}

	@Then("^the information about oracle apex is displayed$")
	public void the_information_about_oracle_apex_is_displayed() throws Exception {
		String info=(String) js.executeScript("return arguments[0].innerHTML;", infoText);
	    js.executeScript("alert(arguments[0])", info);
	    Thread.sleep(2500);
	    driver.switchTo().alert().accept();
	    Thread.sleep(3000);
	}


}
