package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZooStepDefinition extends BaseStepDefinition {
	
	@Given("^Zoo portal is launched$")
	public void zoo_portal_is_launched() throws Exception {
	    driver.get("https://kolkatazoo.in/alipore/");
	}

	@When("^user clicks on Birds$")
	public void user_clicks_on_Birds() throws Exception {
	   WebElement Menu=driver.findElement(By.xpath("//*[contains(text(),'Animals & Enclosure')]"));
	   WebElement Birds=driver.findElement(By.xpath("//a[text()='Birds']"));
	   actions.moveToElement(Menu).click(Birds).perform();
	}

	@Then("^the list of birds is displayed$")
	public void the_list_of_birds_is_displayed() throws Exception {
	    List<WebElement> allBirds=driver.findElements(By.xpath("//h4[@class='py-3 m-0']"));
	    for(WebElement Bird:allBirds)
	    {
	    	System.out.println(Bird.getText());
	    }
	    
	}



}
