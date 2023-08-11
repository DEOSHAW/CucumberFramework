package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HYRTutorialStepDefinition extends BaseStepDefinition {
	
	@Given("^HYR tutorial portal is open$")
	public void hyr_tutorial_portal_is_open() throws Exception {
	   driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	}
	
	@When("^User fills in \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_fills_in_and(String firstName, String lastName, String email) throws Exception {
		driver.switchTo().frame("frm3");
		driver.switchTo().frame("frm2");
		driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		Thread.sleep(3000);
	  
	}



	@Then("^registration is completed$")
	public void registration_is_completed() throws Exception {
		
		driver.switchTo().parentFrame();
		WebElement textBox=driver.findElement(By.cssSelector("input.frmTextBox"));
		js.executeScript("arguments[0].scrollIntoView();", textBox);
		textBox.sendKeys("Back to Main");
		Thread.sleep(3000);
	    
	}



}
