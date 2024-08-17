package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NusStepDefinition extends BaseStepDefinition
{
	
	@Given("NUS portal is open")
	public void nus_portal_is_open() 
	{
	    driver.get("https://nus.edu.sg/");
	}
	@When("User clicks on Research link")
	public void user_clicks_on_research_link() 
	{
		driver.findElement(By.xpath("//a[@href='/research']")).click();
	    
	}
	@Then("User is redireted to NUS research page")
	public void user_is_redireted_to_nus_research_page() throws IOException 
	{
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows)
		{
			if(!window.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(window);
				break;
				
			}
		}
		Assert.assertEquals(driver.getCurrentUrl(), "https://nus.edu.sg/research");
		Assert.assertEquals(driver.getTitle(), "NUS Research");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+File.separator+"NUS_Reserach.jpeg"));
		
	   
	}



	

}
