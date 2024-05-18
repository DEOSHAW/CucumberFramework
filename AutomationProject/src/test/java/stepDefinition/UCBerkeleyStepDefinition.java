package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UCBerkeleyStepDefinition extends BaseStepDefinition
{
	
	@Given("UC Berkeley portal is open")
	public void uc_berkeley_portal_is_open() 
	{
	   driver.get("https://vcresearch.berkeley.edu/"); 
	}
	@When("User navigates to footer section")
	public void user_navigates_to_footer_section()
	{
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("div.footer-logo-wrapper")));
	    
	}
	@Then("all the links in the footer are highlighted")
	public void all_the_links_in_the_footer_are_highlighted() throws InterruptedException 
	{
		List<WebElement> allFooterLinks=driver.findElements(By.xpath("//div[@class='menu--footer__wrapper']//a"));
		for(WebElement link:allFooterLinks)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", link);
			Thread.sleep(500);
		}
	   
	}


}
