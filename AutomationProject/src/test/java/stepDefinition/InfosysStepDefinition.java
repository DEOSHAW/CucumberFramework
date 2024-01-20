package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InfosysStepDefinition extends BaseStepDefinition
{
	List<WebElement> Links;
	
	@Given("Infosys portal is open")
	public void infosys_portal_is_open() 
	{
	   driver.get("https://www.infosys.com/"); 
	}
	@When("User identifies the main links")
	public void user_identifies_the_main_links()
	{
	    Links=driver.findElements(By.cssSelector("ul.navbar-right.pos-right a"));
	}
	@Then("the links get highlighted")
	public void the_links_get_highlighted() throws InterruptedException
	{
		Iterator<WebElement> itr=Links.iterator();
		while(itr.hasNext())
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
			Thread.sleep(800);
			
		}
	    
	}


}
