package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VitStepDefinition extends BaseStepDefinition
{
	@Given("VIT portal is open")
	public void vit_portal_is_open() 
	{
	    driver.get("https://vit.ac.in/");
	}
	@When("User clicks on VIT campuses menu")
	public void user_clicks_on_vit_campuses_menu() 
	{
	    driver.findElement(By.xpath("//span[contains(text(),'VIT - Campuses')]")).click();
	}
	@Then("list of campuses is displayed")
	public void list_of_campuses_is_displayed() {
	    List<WebElement> campusList=driver.findElements(RelativeLocator.with(By.xpath("//span[contains(text(),'VIT - ') and @class='elementor-icon-list-text']"))
	    		.below(By.xpath("//i[@class='eicon-close']")));
	    System.out.println("Total number of campuses: "+campusList.size());
	    for(int i=0;i<campusList.size();i++)
	    {
	    	System.out.println(campusList.get(i).getText());
	    }
	    
	}

}
