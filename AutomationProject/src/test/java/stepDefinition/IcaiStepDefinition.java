package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class IcaiStepDefinition extends BaseStepDefinition
{
	@Given("ICAI portal is open")
	public void icai_portal_is_open() 
	{
	    driver.get("https://www.icai.org/");
	}
	@Then("all the quick links are highligted")
	public void all_the_quick_links_are_highligted() throws InterruptedException 
	{
	    List<WebElement> allQuickLinks=driver.findElements(By.xpath("(//div[@class='container'])[4]//img"));
	    js.executeScript("arguments[0].scrollIntoView();", allQuickLinks.get(0));
	    for(WebElement quickLink:allQuickLinks)
	    {
	    	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid Red; background:Blue')", quickLink);
	    	Thread.sleep(1000);
	    }
	}

}
