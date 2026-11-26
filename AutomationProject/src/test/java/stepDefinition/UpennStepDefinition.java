package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpennStepDefinition extends BaseStepDefinition
{
	@Given("User is on Upenn portal")
	public void user_is_on_upenn_portal() 
	{
	    driver.get("https://www.upenn.edu/");
	}
	@Given("User takes the screenshot on homepage")
	public void user_takes_the_screenshot_on_homepage() 
	{
	   Assert.assertEquals(driver.getCurrentUrl(), "https://www.upenn.edu/", "Not on Homepage");
	}
	@Then("Image is captured")
	public void image_is_captured() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File imageFile=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(imageFile, new File(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Upenn.png"));
	}
}
