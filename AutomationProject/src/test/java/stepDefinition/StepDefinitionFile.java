package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilitiesSelenium.UtilitiesClass;

public class StepDefinitionFile {
	WebDriver driver=null;
	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable {
		driver=UtilitiesClass.LaunchBrowser(driver,"https://www.gmail.com");
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
	   System.out.println("You are on Homepage, please login");
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" Credentials$")
	public void user_enters_and_Credentials(String username, String password) throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		 Thread.sleep(5000);
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		
		driver.findElement(By.xpath("//*[@placeholder='Search mail']")).isDisplayed();
	    
	}
	@Then("^close the Browser$")
	public void close_the_Browser() throws Throwable {
	    driver.close();
	}





}
