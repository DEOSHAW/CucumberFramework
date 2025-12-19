package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrookfieldStepDefinition extends BaseStepDefinition
{
	String parentWindow;
	@Given("Brookfield portal is open")
	public void brookfield_portal_is_open() 
	{
	    driver.get("https://www.brookfield.com/");
	    driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	}
	@When("User clicks on login link on Brookfield portal")
	public void user_clicks_on_login_link_on_brookfield_portal() 
	{
		parentWindow=driver.getWindowHandle();
	    driver.findElement(By.xpath("(//a[text()='LP Login'])[1]")).click();
	}
	@Then("User is redirected to Brookfield login page")
	public void user_is_redirected_to_brookfield_login_page() 
	{
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		String currentWindow=null;
		while(itr.hasNext())
		{
			currentWindow=itr.next();
			if(!currentWindow.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(currentWindow);
				break;
			}
		}
		
		String loginLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Client Login']"))).getText();
		Assert.assertEquals(loginLabel, "Client Login");
	    
	}




}
