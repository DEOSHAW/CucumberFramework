package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewFrontStepDefinition extends BaseStepDefinition
{
	@Given("NewFront portal is open")
	public void new_front_portal_is_open() 
	{
	    driver.get("https://www.newfront.com/");
	}
	@When("User is on homepage of NewFront portal")
	public void user_is_on_homepage_of_new_front_portal() 
	{
	   String homePageText=driver.findElement(By.xpath("(//a[@aria-label='Newfront Homepage'])[1]")).getAttribute("aria-label");
	   Assert.assertEquals(homePageText, "Newfront Homepage");
	}
	@Then("the menu items are highlighted")
	public void the_menu_items_are_highlighted() throws InterruptedException 
	{
		List<WebElement> allMenu =driver.findElements(By.xpath("//ul[contains(@class,'Header_menuGroups')]//li//button[contains(@aria-label,'menu')]"));
		for(WebElement ele:allMenu)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", ele);
			Thread.sleep(2000);
		}
	    
	}




}
