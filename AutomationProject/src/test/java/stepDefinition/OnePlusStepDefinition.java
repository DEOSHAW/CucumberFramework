package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnePlusStepDefinition extends BaseStepDefinition
{
	@When("User is on OnePlus portal")
	public void user_is_on_one_plus_portal() 
	{
	   driver.get("https://www.oneplus.in/");
	}
	@Then("User highlights all the menu options")
	public void user_highlights_all_the_menu_options() throws InterruptedException
	{
	    List<WebElement> menuOptions=driver.findElements(By.xpath("//div[@aria-label='Main Menu']//a[@tabindex!=-1]"));
	    Iterator<WebElement> itr=menuOptions.iterator();
	    while(itr.hasNext())
	    {
	    	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
	    	Thread.sleep(500);
	    }
	    
	}
}
