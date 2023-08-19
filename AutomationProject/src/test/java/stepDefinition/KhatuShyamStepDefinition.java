package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KhatuShyamStepDefinition extends BaseStepDefinition {
	
	
	@Given("^Khatu Shyam portal is open$")
	public void khatu_Shyam_portal_is_open() throws Exception {
	   driver.get("https://khatushyamdarbar.com/");
	}

	@When("^User navigates to the story page$")
	public void user_navigates_to_the_story_page() throws Exception {
	    driver.findElement(By.xpath("//a[text()='View More']")).click();
	}

	@Then("^the story of Khaatu Shyam Baba ji is displayed$")
	public void the_story_of_Khaatu_Shyam_Baba_ji_is_displayed() throws Exception {
		
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='khatu']")));
	  List<WebElement> allTextElements= driver.findElements(By.xpath("//div[@class='entry-content']//child::p"));
	  
	  Iterator<WebElement> itr=allTextElements.iterator();
	  while(itr.hasNext())
	  {
		  System.out.println(itr.next().getText());
		  System.out.println("\n");
	  }
	}



}
