package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OxfordStepDefinition extends BaseStepDefinition {
	
	@Given("^Oxford portal is open$")
	public void oxford_portal_is_open() throws Exception {
	   driver.get("https://www.ox.ac.uk/");
	   List<WebElement> acceptAllLink=driver.findElements(By.xpath("//span[contains(text(),'Accept all')]"));
	   if(acceptAllLink.size()>0)
	   {
		   acceptAllLink.get(0).click();
	   }
	}

	@When("^User navigates to quick link section$")
	public void user_navigates_to_quick_link_section() throws Exception {
	   WebElement quickLinksSection=driver.findElement(By.xpath("//h2[contains(text(),'Quick Links')]"));
	   js.executeScript("arguments[0].scrollIntoView();", quickLinksSection);
	}

	@Then("^all the quick links are displayed$")
	public void all_the_quick_links_are_displayed() throws Exception {
		
		
		List<WebElement> allQuickLinks=driver.findElements(By.xpath("//h2[contains(text(),'Quick Links')]/parent::div//ul//li/a"));
		
		Iterator<WebElement> itr=allQuickLinks.iterator();
		String keysToPress=Keys.chord(Keys.CONTROL,Keys.ENTER);
		while(itr.hasNext())
		{
			itr.next().sendKeys(keysToPress);
			Thread.sleep(500);
			
		}
		Thread.sleep(2500);
	
	}

}
