package stepDefinition;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QSpiderStepDefinition extends BaseStepDefinition
{
	@Given("QSpider portal is open")
	public void q_spider_portal_is_open() 
	{
	    driver.get("https://demoapps.qspiders.com/");
	}
	@When("user navigates to modal")
	public void user_navigates_to_modal()
	{
	    driver.findElement(By.xpath("(//div[text()='Explore more'])[1]")).click();
	    driver.findElement(By.xpath("//section[text()='Popups']/..")).click();
	    driver.findElement(By.xpath("//a[@href='/ui/modal']")).click();
	    
	}
	@When("user clicks on open modal button")
	public void user_clicks_on_open_modal_button() 
	{
		driver.findElement(By.xpath("//button[text()='Open Modal']")).click();
	    
	}
	@Then("modal pop up is displayed")
	public void modal_pop_up_is_displayed() throws InterruptedException 
	{
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]//p")).getText(), "This is a custom Modal");
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("button#closeModal")).click();
	    Thread.sleep(1000);
	}
	
	@When("User navigates to new login window")
	public void user_navigates_to_new_login_window() {
		 driver.findElement(By.xpath("(//div[text()='Explore more'])[1]")).click();
		 driver.findElement(By.xpath("//section[text()='Popups']/..")).click();
		 driver.findElement(By.xpath("//a[@href='/ui/browser']")).click();
		 driver.findElement(By.cssSelector("a#browserLink1")).click();
	}
	@When("User switches to the new login window")
	public void user_switches_to_the_new_login_window() {
	    
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		String currentWindow;
		while(itr.hasNext())
		{
			currentWindow=itr.next();
			if(!currentWindow.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(currentWindow);
			}
		}
	}
	@Then("User is on new login window")
	public void user_is_on_new_login_window() 
	{
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Sign Up']")));
	   Assert.assertTrue(driver.getCurrentUrl().contains("/ui/browser/"));
	}




}
