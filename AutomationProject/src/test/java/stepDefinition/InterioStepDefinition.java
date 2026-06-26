package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InterioStepDefinition extends BaseStepDefinition
{
	@Given("Interio portal is open")
	public void interio_portal_is_open()
	{
	    driver.get("https://interio.com/");
	}
	@When("User is on homepage of Interio")
	public void user_is_on_homepage_of_interio() 
	{
	    Assert.assertEquals(driver.getTitle(), "Buy Furniture Online for Home and Office in India | Interio by Godrej");
	}
	@Then("menu options are highlighted on Interio")
	public void menu_options_are_highlighted_on_interio() throws InterruptedException 
	{
		List<WebElement> allMenu=driver.findElements(By.xpath("//a[contains(@id,'ui-id') and contains(@class,'nav-anchor subdynamic ui-menu-item-wrapper')]/span[1]"));
		for(WebElement menu:allMenu)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", menu);
			Thread.sleep(500);
		}
	    
	}
}
