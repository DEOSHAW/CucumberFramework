package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JarDigiGoldStepDefinition extends BaseStepDefinition
{
	@Given("JarDigiGold portal is open")
	public void jar_digi_gold_portal_is_open() 
	{
	    driver.get("https://www.myjar.app/");
	}
	@When("User navigates to teams page")
	public void user_navigates_to_teams_page()
	{
	    Actions actions=new Actions(driver);
	    actions.moveToElement(driver.findElement(By.xpath("//div[text()='About us']"))).perform();
	    WebElement careersLink=driver.findElement(By.xpath("(//a[@href='/careers-at-jar'])[1]"));
	    driver.findElement(RelativeLocator.with(By.tagName("a")).above(careersLink)).click();
	    
	}
	@Then("Teams page is displayed")
	public void teams_page_is_displayed()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Meet the')]")));
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.myjar.app/about-jar-app#leaders");
	    
	}


}
