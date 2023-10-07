package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuidewireStepDefinition extends BaseStepDefinition
{
	
	@Given("Guidewire portal is open")
	public void guidewire_portal_is_open() {
	    driver.get("https://www.guidewire.com/");
	}
	@When("User navigates to Proven experience section")
	public void user_navigates_to_proven_experience_section() throws InterruptedException {
	    WebElement provenExperienceLabel=driver.findElement(By.xpath("//h2[contains(text(),'Proven experience')]"));
	    js.executeScript("arguments[0].scrollIntoView();", provenExperienceLabel);
	    Thread.sleep(2500);
	    
	}
	@Then("insights are displayed")
	public void insights_are_displayed() throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+File.separator+"Guidewire.png");
		FileHandler.copy(src, dest);
	    
	}




}
