package stepDefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaloAltoStepDefinition extends BaseStepDefinition {
	
	@Given("^Palo alto portal is open$")
	public void palo_alto_portal_is_open() throws Exception {
	    driver.get("https://www.paloaltonetworks.com/");
	}

	@When("^User navigates to careers page$")
	public void user_navigates_to_careers_page() throws Exception {
		String parentWindow=driver.getWindowHandle();
	   WebElement company= driver.findElement(By.id("nav_company"));
	   actions.moveToElement(company).pause(Duration.ofSeconds(1)).click(driver.findElement(By.xpath("//a[text()='Overview']"))).perform();
	   Set<String> allWindows=driver.getWindowHandles();
	   for(String window:allWindows)
	   {
		   if(!parentWindow.equalsIgnoreCase(window))
		   {
			   driver.switchTo().window(window);
			   break;
			   
		   }
	   }
	}

	@Then("^Career overview is displayed$")
	public void career_overview_is_displayed() throws Exception {
	    
		String text=driver.findElement(By.tagName("h1")).getText();
		System.out.println(text);
	}



}
