package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KECStepDefinition extends BaseStepDefinition
{
	@Given("KEC portal is open")
	public void kec_portal_is_open() 
	{
		driver.get("https://www.kecrpg.com/");
	    
	}
	@When("User hovers over Business units menu option")
	public void user_hovers_over_business_units_menu_option() 
	{
		WebElement businessUnitOption=driver.findElement(By.xpath("//a[text()='Business Units']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(businessUnitOption).perform();    
	}
	
	@Then("business units are displayed")
	public void business_units_are_displayed() throws InterruptedException
	{
		List<WebElement> businessUnits=driver.findElements(By.xpath("//a[string()='Business Units']/../child::ul//a"));
		StringBuilder units=new StringBuilder();
		for(WebElement businessUnit:businessUnits)
		{
			units.append(businessUnit.getText());
			units.append("\n");
		}
		js.executeScript("alert(arguments[0])",units.toString());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();    
	}
}
