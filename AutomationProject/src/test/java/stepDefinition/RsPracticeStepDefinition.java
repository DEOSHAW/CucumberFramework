package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RsPracticeStepDefinition extends BaseStepDefinition {
	
	@Given("^RS Practice portal is open$")
	public void rs_Practice_portal_is_open() throws Exception {
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@When("^User clicks on open window$")
	public void user_clicks_on_open_window() throws Exception {
	    driver.findElement(By.cssSelector("#openwindow")).click();
	}

	@Then("^a new window is opened$")
	public void a_new_window_is_opened() throws Exception {
		
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("Window title before switching: "+driver.getTitle());
		
		Iterator<String> itr=allWindows.iterator();
		while(itr.hasNext())
		{
			String currentWindow=itr.next();
			if(!currentWindow.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(currentWindow);
				break;
			}
		}
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Window title after switching: "+driver.getTitle());
		
	    
	}

}
