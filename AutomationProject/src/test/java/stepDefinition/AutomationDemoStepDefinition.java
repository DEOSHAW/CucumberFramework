package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationDemoStepDefinition extends BaseStepDefinition
{
	@Given("Automation Demo site is open")
	public void automation_demo_site_is_open() {
	    driver.get("https://demo.automationtesting.in/Index.html");
	}
	@When("User clicks on Skip Sign In link")
	public void user_clicks_on_skip_sign_in_link() {
	    driver.findElement(By.cssSelector("#btn2")).click();
	}
	
	@When("User navigates to frames switching page")
	public void user_navigates_to_frames_switching_page() 
	{
	    driver.findElement(By.xpath("//a[text()='SwitchTo']")).click();
	    driver.findElement(By.xpath("//a[text()='Frames']")).click();
	}
	
	@When("user switches to frame")
	public void user_switches_to_frame() {
	    driver.findElement(By.xpath("//a[text()='SwitchTo']")).click();
	    driver.findElement(By.xpath("//a[text()='Frames']")).click();
	    driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html' and @style='float: left;height: 250px;width: 400px']")));
	}
	@When("User types in the inputbox")
	public void user_types_in_the_inputbox() {
	    driver.findElement(By.xpath("//input")).sendKeys("Nested frames");
	}
	@When("User switches back to parent frame")
	public void user_switches_back_to_parent_frame() {
	    driver.switchTo().parentFrame();
	    }
	@Then("label of parent frame is displayed")
	public void label_of_parent_frame_is_displayed() throws IOException {
		System.out.println(driver.findElement(By.xpath("//h5[text()='Nested iFrames']")).getText());
		
		File src=driver.findElement(By.xpath("//h5[text()='Nested iFrames']")).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(src, new File(System.getProperty("user.dir")+File.separator+"Frames.png"));
	}
	
	@When("User navigates to Accordion page")
	public void user_navigates_to_accordion_page() 
	{
	    driver.findElement(By.xpath("//a[text()='Widgets']")).click();
	    driver.findElement(By.xpath("//a[normalize-space(text())='Accordion']")).click();
	}
	@When("User clicks on an accordion")
	public void user_clicks_on_an_accordion() 
	{
	    driver.findElement(By.xpath("//b[contains(text(),'Methhod Chaining')]/..")).click();
	}
	@Then("accordion text is displayed")
	public void accordion_text_is_displayed() 
	{
	    String accordionText=driver.findElement(By.cssSelector("div#collapse3>div")).getText();
	    if(accordionText.contains("chain the methods without breaking the code"))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}







}
