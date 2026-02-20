package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IcmaiStepDefinition extends BaseStepDefinition
{
	
	@Given("User is on ICMAI portal")
	public void user_is_on_icmai_portal() {
	    driver.get("https://www.icmai.in/icmai/");
	}
	@When("User clicks on placements menu link on ICMAI portal")
	public void user_clicks_on_placements_menu_link_on_icmai_portal() {
	    driver.findElement(RelativeLocator.with(By.xpath("//a[contains(@href,'https://icmai.in/CPT/')]"))
	    		.toRightOf(By.xpath("//a[contains(@href,'Student-index.php')]"))).click();
	}
	@Then("the user is navigated to placements page of ICMAI")
	public void the_user_is_navigated_to_placements_page_of_icmai() 
	{
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		String currentWindow="";
		while(itr.hasNext())
		{
			currentWindow=itr.next();
			if(!currentWindow.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(currentWindow);
				break;
				
			}
		}
		Assert.assertEquals(driver.getCurrentUrl(), "https://icmai.in/CPT/");
	    
	}

}
