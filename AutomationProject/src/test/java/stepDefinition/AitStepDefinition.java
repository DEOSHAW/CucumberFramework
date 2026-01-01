package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AitStepDefinition extends BaseStepDefinition
{
	@Given("AIT portal is open")
	public void ait_portal_is_open()
	{
	   driver.get("https://www.aitpune.com/"); 
	}
	@When("User is on homepage of AIT portal")
	public void user_is_on_homepage_of_ait_portal()
	{
	    String header=driver.findElements(By.tagName("h1")).get(1).getText();
	    Assert.assertEquals(header, "Army Institute of Technology");
	}
	@Then("User takes the screenshot")
	public void user_takes_the_screenshot() throws IOException 
	{
	   
	   File dest=new File(System.getProperty("user.dir")+File.separator+"campusView.jpg");
	   if (dest.exists()) {
		    dest.delete();
		}
	   File src=driver.findElement(By.xpath("//img[@alt='Image 1: Campus View']")).getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(src, dest);
	   Assert.assertTrue(dest.exists(),"Screenshot not saved");
	}


}
