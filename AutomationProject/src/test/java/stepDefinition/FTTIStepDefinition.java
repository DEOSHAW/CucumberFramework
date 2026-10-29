package stepDefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FTTIStepDefinition extends BaseStepDefinition
{
	
	@Given("FTTI portal is open")
	public void ftti_portal_is_open() {
	    driver.get("https://ftii.ac.in/");
	}
	@When("User clicks on Fee Structure")
	public void user_clicks_on_fee_structure() {
	    driver.findElement(By.cssSelector("a.btn-admision")).click();
	    driver.findElement(By.xpath("(//a[text()='Fee Structure'])[2]")).click();
	}
	@Then("User is navigated to Fee Structure page")
	public void user_is_navigated_to_fee_structure_page() throws InterruptedException 
	{
		String mainWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window: allWindows)
		{
			if(!window.equalsIgnoreCase(mainWindow))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(5000);
		String currentPageUrl=driver.getCurrentUrl();
		System.out.println(currentPageUrl);
		Assert.assertTrue(currentPageUrl.contains("Admission_Prospectus_FTII"),"User not on Fee Structure page "); 
	}

}
