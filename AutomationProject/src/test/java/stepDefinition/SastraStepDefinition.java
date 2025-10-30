package stepDefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SastraStepDefinition extends BaseStepDefinition
{
	String pageTitle;
	@Given("Sastra university portal is open")
	public void sastra_university_portal_is_open()
	{
	    driver.get("https://www.sastra.edu/");
	}
	@When("user is on schools page")
	public void user_is_on_schools_page() 
	{
	    WebElement academicsMenuLink=driver.findElement(By.xpath("(//a[text()='Academics'])[1]"));
	    WebElement schoolsLink=driver.findElement(By.xpath("(//a[text()='Schools'])[1]"));
	    actions.moveToElement(academicsMenuLink).pause(Duration.ofSeconds(1)).click(schoolsLink).perform();
	    wait.until(ExpectedConditions.urlToBe("https://www.sastra.edu/academics/schools.html"));
	}
	@When("User clicks on {string} on sastra home page")
	public void user_clicks_on_on_sastra_home_page(String schoolName) throws InterruptedException 
	{
		WebElement schoolLink=driver.findElement(By.xpath("(//a[contains(@title,'"+schoolName+"')])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", schoolLink);
		js.executeScript("arguments[0].click();", schoolLink);
		Thread.sleep(1000);
		WebElement innerSchoolLink=driver.findElement(By.xpath("(//a[contains(text(),'"+schoolName+"')])[1]"));
		js.executeScript("arguments[0].click();", innerSchoolLink);
		pageTitle=schoolName;
		
	    
	}
	@Then("User is switched to the school webpage")
	public void user_is_switched_to_the_school_webpage() throws InterruptedException 
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
	    Thread.sleep(1000);
	    Assert.assertTrue(driver.getTitle().contains(pageTitle),"Did not navigate to correct school page");
	}

}
