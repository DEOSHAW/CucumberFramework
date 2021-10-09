package stepDefinition;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JavaTpointHighlightStepDefinition extends BaseStepDefinition {
	List<WebElement> Courses;
	@Given("^Javatpoint is launched$")
	public void javatpoint_is_launched() throws Exception {
	    driver.get("https://www.javatpoint.com");
	}

	@When("^User checks for the java tutorial element$")
	public void user_checks_for_the_java_tutorial_element() throws Exception {
	Courses=driver.findElements(By.xpath("//*[@class='ddsmoothmenu']/child::ul/child::li/child::a[contains(@href,'java')]"));
	}

	@Then("^user highlights the elements$")
	public void user_highlights_the_elements() throws Exception {
	   
		
		
		for(WebElement course:Courses)
		{
		js.executeScript("arguments[0].setAttribute('style', 'border:3px solid blue; background:Red')", course);
	    Thread.sleep(800);
		}
	}


}
