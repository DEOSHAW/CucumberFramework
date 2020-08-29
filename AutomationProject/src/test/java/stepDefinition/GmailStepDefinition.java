package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GmailStepDefinition extends BaseStepDefinition {
	
	
	@When("^User Logs in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_Logs_in_with_user_and_password(String user, String password) throws Throwable {
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys(user);
		WebElement nextButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']/preceding-sibling::div")));
		js.executeScript("arguments[0].click();", nextButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='password']"))).sendKeys(password);
		js.executeScript("arguments[0].click();", nextButton);
		
		
	    
	}

	@Then("^User name \"([^\"]*)\" should be visible$")
	public void user_name_should_be_visible(String userName) throws Throwable {
		String name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+userName+"']"))).getText();
		Assert.assertEquals(name, userName,"Name did n't match");
		driver.close();
		
	    
	}

	



}
