package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TAPMIStepDefinition extends BaseStepDefinition
{
	@When("User is on TAPMI portal")
	public void user_is_on_tapmi_portal() 
	{
	    driver.get("https://www.tapmi.edu.in/");
	}
	@When("User clicks on hamburger menu")
	public void user_clicks_on_hamburger_menu() 
	{
	    driver.findElement(By.xpath("//img[@src='https://www.tapmi.edu.in/wp-content/uploads/2024/12/bars.webp']/parent::a")).click();
	}
	@Then("Hamburger menu is displayed")
	public void hamburger_menu_is_displayed() 
	{
	    boolean hamurgerCrossPresent=wait
	    		.until(ExpectedConditions
	    				.visibilityOfElementLocated(By
	    						.cssSelector("img[src='https://www.tapmi.edu.in/wp-content/uploads/2024/12/cross.webp']"))).isDisplayed();
	    Assert.assertTrue(hamurgerCrossPresent, "Hamburger menu did not open");
	}

}
