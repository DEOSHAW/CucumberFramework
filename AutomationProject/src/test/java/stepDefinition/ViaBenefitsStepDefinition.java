package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViaBenefitsStepDefinition extends BaseStepDefinition
{
	@Given("Via Benefits portal is open")
	public void via_benefits_portal_is_open() 
	{
		driver.get("https://www.viabenefits.com/");
	    
	}
	@When("User navigates to login page of Via Benefits")
	public void user_navigates_to_login_page_of_via_benefits() 
	{
	    driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
	}
	@Then("Login page of Via Benefits is loaded with below message")
	public void login_page_of_via_benefits_is_loaded_with_below_message(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists();
		String text=dataList.get(0).get(1);
		String textMessage=driver.findElement(By.xpath("//*[text()='"+text+"']")).getText();
		Assert.assertEquals(textMessage, text);
	    
	}
	
	@When("User logs in with wrong credentials")
	public void user_logs_in_with_wrong_credentials() 
	{
		driver.findElement(By.cssSelector("input#username")).sendKeys("Test123@gmail.com");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		WebElement passwordInputBox=driver.findElement(By.cssSelector("input#passwordInput"));
		wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]",passwordInputBox,"test1234");
		passwordInputBox.sendKeys("test123");
		passwordInputBox.sendKeys(Keys.ENTER);
	    
	}
	@Then("error message is displayed on the ViaBenefits portal")
	public void error_message_is_displayed_on_the_via_benefits_portal() 
	{
	    Assert.assertEquals(driver.findElement(By.cssSelector("p.err-message:nth-child(2)")).getText(), "Invalid User Credentials");
	}


}
