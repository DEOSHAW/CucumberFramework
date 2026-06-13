package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MahindraUniversityStepDefinition extends BaseStepDefinition
{
	@Given("User is on Mahindra University portal")
	public void user_is_on_mahindra_university_portal() 
	{
	    driver.get("https://www.mahindrauniversity.edu.in/");
	}
	@When("User is on homepage of Mahindra University portal")
	public void user_is_on_homepage_of_mahindra_university_portal() 
	{
	    WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Mahindra University']")));
	    Assert.assertEquals(logo.getAttribute("title"), "Mahindra University");
	}
	@Then("menu options are highlighted on mahindra university portal")
	public void menu_options_are_highlighted_on_mahindra_university_portal() throws InterruptedException 
	{
		for(WebElement menu:driver.findElements(By.cssSelector("a.mega-menu-link")))
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", menu);
			Thread.sleep(500);
		}
		
	}

}
