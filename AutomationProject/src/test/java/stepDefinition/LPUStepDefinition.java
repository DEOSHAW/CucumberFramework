package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LPUStepDefinition extends BaseStepDefinition
{
	WebElement particularCourse;
	@Given("LPU portal is open")
	public void lpu_portal_is_open()
	{
	    driver.get("https://www.lpu.in/");
	}
	@When("user Searches for {string}")
	public void user_searches_for(String course) 
	{
		actions.moveToElement(driver.findElement(By.xpath("//a[@class='menu-link']//div[text()='Academics']"))).perform();
	   particularCourse= driver.findElement(By.xpath("//a[@class='menu-link' and contains(@href,'https://www.lpu.in/schools/"+course.toLowerCase()+"')]"));
	   
	}
	@Then("the course is highlighted")
	public void the_course_is_highlighted() throws InterruptedException 
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", particularCourse);
		Thread.sleep(3000);
	}




}
