package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SymbiosisUniversityStepDefinition extends BaseStepDefinition
{
	@Given("Symbiosis University portal is open")
	public void symbiosis_university_portal_is_open() 
	{
	    driver.get("https://www.siu.edu.in/");
	}
	@When("User is on homepage of SMU portal")
	public void user_is_on_homepage_of_smu_portal() 
	{
	    String logoText=driver.findElement(By.cssSelector("div.two-logo>img")).getAttribute("alt");
	    Assert.assertEquals(logoText, "Symbiosis International");
	}
	@Then("menu options are highlighted on SMU portal")
	public void menu_options_are_highlighted_on_smu_portal() 
	{
		List<WebElement> allMenuOptions=driver.findElements(By.cssSelector("span.menu-link"));
		for(WebElement ele : allMenuOptions)
		{
		   js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", ele);
		} 
	}
}
