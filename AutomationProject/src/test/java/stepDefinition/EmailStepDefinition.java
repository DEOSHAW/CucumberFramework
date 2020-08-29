package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilitiesSelenium.UtilitiesClass;

public class EmailStepDefinition extends BaseStepDefinition {
	
	@Given("^Gmail URL is Launched$")
	public void gmail_URL_is_Launched() throws Throwable {
		LaunchBrowser();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		System.out.println("URL is launched");
	}
	
	@Then("^Error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {
	    String errorMessage=driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).getText();
	    Assert.assertEquals(errorMessage,"Wrong password. Try again or click Forgot password to reset it.");
	    driver.close();
	}

}
