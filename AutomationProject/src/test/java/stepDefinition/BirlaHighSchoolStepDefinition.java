package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BirlaHighSchoolStepDefinition extends BaseStepDefinition
{
	
	@Given("Birla High School portal is open")
	public void birla_high_school_portal_is_open() 
	{
	    driver.get("https://birlahighschool.com/");
	}
	@Then("all the school campuses are highlighted")
	public void all_the_school_campuses_are_highlighted() throws InterruptedException 
	{
	    List<WebElement> allLinks=driver.findElements(By.cssSelector("a.body-innr-hld"));
	    Iterator<WebElement> itr=allLinks.iterator();
	    while(itr.hasNext())
	    {
	    	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:Yellow')", itr.next());
	    	Thread.sleep(800);
	    }   
	    
	}

}
