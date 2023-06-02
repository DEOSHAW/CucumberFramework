package stepDefinition;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RSLoginStepDefinition extends BaseStepDefinition {
	
	@Given("^RS Practice site is open$")
	public void rs_Practice_site_is_open() throws Exception {
	   driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	}

	@When("^User takes the screenshot of the entire page$")
	public void user_takes_the_screenshot_of_the_entire_page() throws Exception {
	    
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+File.separator+"LoginPage.png"));
		
	}

	@When("^the screenshot of the username field$")
	public void the_screenshot_of_the_username_field() throws Exception {
		
		WebElement userName=driver.findElement(By.xpath("//*[@id='username']"));
		userName.sendKeys("rahulshettyacademy");
		File srcFile=userName.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+File.separator+"UserName.png"));
	}


}
