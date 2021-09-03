package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikiStepDefinition extends BaseStepDefinition {
	List<WebElement> categoryList;
	
	@Given("^Wikipedia portal is open$")
	public void wikipedia_portal_is_open() throws Exception {
	    driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}

	@When("^user extracts the categories$")
	public void user_extracts_the_categories() throws Exception {
	    categoryList=driver.findElements(By.xpath("//*[contains(@title,'Portal:')]"));
	}

	@Then("^the categories are displayed$")
	public void the_categories_are_displayed() throws Exception {
		
		System.out.println("The categories are: ");
	    for(int i=0;i<categoryList.size();i++)
	    {
	    	System.out.println(categoryList.get(i).getText());
	    	
	    }
	}



}
