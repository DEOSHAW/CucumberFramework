package stepDefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RKMVUStepDefinition extends BaseStepDefinition
{
	static String parentWindow;
	@Given("RKMVU portal is open")
	public void rkmvu_portal_is_open()
	{
	    driver.get("https://rkmvu.ac.in/");
	}
	@When("User clicks on Central Library link")
	public void user_clicks_on_central_library_link()
	{
		WebElement portalLink=driver.findElement(By.cssSelector("a[title='University’s internal portals']"));
		WebElement libraryPortalLink=driver.findElement(By.cssSelector("a[title='Browse the Catalog online']"));
		parentWindow=driver.getWindowHandle();
		actions.moveToElement(portalLink).pause(Duration.ofMillis(500)).click(libraryPortalLink).perform();
	   
	}
	@Then("User is redirected to library portal")
	public void user_is_redirected_to_library_portal() 
	{
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows)
		{
			if(!window.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		String libraryPortalUrl=driver.getCurrentUrl();
		System.out.println(libraryPortalUrl);
		Assert.assertTrue(libraryPortalUrl.contains("lib"),"User not redirected to library portal");
		
	    
	}




}
