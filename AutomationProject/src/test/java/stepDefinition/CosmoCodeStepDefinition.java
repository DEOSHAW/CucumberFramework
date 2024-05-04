package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CosmoCodeStepDefinition extends BaseStepDefinition
{
	@Given("CosmoCode portal is open")
	public void cosmo_code_portal_is_open() 
	{
	    driver.get("https://cosmocode.io/");
	}
	@When("User is on the home page")
	public void user_is_on_the_home_page()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space(text())='What do you want to learn today?']")));
	}
	@Then("list of tutorials is displayed")
	public void list_of_tutorials_is_displayed() {
		List<WebElement> tutorialList=driver.findElements(By.cssSelector("div.hero-buttons>a"));
		System.out.println("Tutorials: ");
		System.out.println(tutorialList.get(0).getText());
		System.out.println(tutorialList.get(1).getText());
	    
	}

}
