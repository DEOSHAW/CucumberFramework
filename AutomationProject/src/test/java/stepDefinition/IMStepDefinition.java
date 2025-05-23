package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IMStepDefinition extends BaseStepDefinition
{
	@Given("User is on IM portal")
	public void user_is_on_im_portal() {
	    driver.get("https://my.viabenefits.com/");
	}
	@When("User clicks on Sign In link")
	public void user_clicks_on_sign_in_link() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign In']"))).click();
	}
	
	@When("User logs in with {string} and {string} on IM portal")
	public void user_logs_in_with_and_on_im_portal(String user, String pwd) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#wtw-email"))).sendKeys(user);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#wtw-password"))).sendKeys(pwd);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign In']"))).click();
	}

	@Then("error message is displayed")
	public void error_message_is_displayed() {
	    String errorText=driver.findElement(By.xpath("(//div[@role='dialog'])[1]//p")).getText();
	    Assert.assertEquals(errorText, "The email or password you entered was incorrect.");
	}

}
