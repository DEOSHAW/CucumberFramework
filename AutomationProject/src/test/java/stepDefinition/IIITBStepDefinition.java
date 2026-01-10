package stepDefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IIITBStepDefinition extends BaseStepDefinition
{
	@When("User is on IIITB portal")
	public void user_is_on_iiitb_portal()
	{
	    driver.get("https://www.iiitb.ac.in/");
	}
	@When("User clicks on alumni sign up link")
	public void user_clicks_on_alumni_sign_up_link()
	{
	    WebElement clickHereLink=driver.findElement(By.xpath("//span[text()='Click here']"));
//	    js.executeScript(
//	    	    "arguments[0].scrollIntoView({block: 'center', inline: 'center'});", clickHereLink
//	    	);
	    js.executeScript("arguments[0].scrollIntoView();", clickHereLink);
	    wait.until(ExpectedConditions.visibilityOf(clickHereLink));
	    String parentWindow=driver.getWindowHandle();
	    clickHereLink.click();
	    Set<String> allWindows=driver.getWindowHandles();
	    for(String window: allWindows)
	    {
	    	if(!window.equalsIgnoreCase(parentWindow))
	    	{
	    		driver.switchTo().window(window);
	    		break;
	    	}
	    }
	}
	@Then("User is on Alumni page")
	public void user_is_on_alumni_page() 
	{
	    Assert.assertEquals(driver.getCurrentUrl(), "https://alumni.iiitb.ac.in/");
	}

}
;