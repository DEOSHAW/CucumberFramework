package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AxisStepDefinition extends BaseStepDefinition
{
	@Given("Axis Bank portal is open")
	public void axis_bank_portal_is_open() 
	{
	    driver.get("https://www.axis.bank.in/");
	}
	@When("User is on homepage")
	public void user_is_on_homepage() 
	{
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.axis.bank.in/");
	}
	@Then("menu options are highlighted")
	public void menu_options_are_highlighted() throws InterruptedException 
	{
	    List<WebElement> menuOptions=driver.findElements(By.xpath("(//ul[@class='nav-list'])[1]/li/a"));
	    Iterator<WebElement> itr=menuOptions.iterator();
	    while(itr.hasNext())
	    {
	    	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
	    	Thread.sleep(1500);
	    }    
	}

}
