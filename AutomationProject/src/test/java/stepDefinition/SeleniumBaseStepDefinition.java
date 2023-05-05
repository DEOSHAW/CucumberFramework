package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeleniumBaseStepDefinition extends BaseStepDefinition
{
	WebElement svgElement;
	
	@Given("^Selenium Base portal is open$")
	public void selenium_Base_portal_is_open() throws Exception {
	    driver.get("https://seleniumbase.io/demo_page");
	    
	}

	@When("^User checks the checkboxes$")
	public void user_checks_the_checkboxes() throws Exception {
		
		
	    List<WebElement> allCheckBoxes=driver.findElements(By.xpath("//*[contains(@name,'checkBoxName')]"));
	    
	    System.out.println("Total checkboxes: "+allCheckBoxes.size());
	    
	    for(WebElement ele:allCheckBoxes)
	    {
	    	if(!ele.isSelected())
	    	{
	    		ele.click();
	    		Thread.sleep(1000);
	    	}
	    }
	    
	    driver.switchTo().frame("frameName3");
	    driver.findElement(By.id("checkBox6")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.id("radioButton2")).click();
	    Thread.sleep(2000);
	    
	}

	@Then("^boxes should get checked$")
	public void boxes_should_get_checked() throws Exception {
	    System.out.println(driver.findElement(By.id("radioButton2")).isSelected());
	}
	
	@When("^User clicks on SVG Element$")
	public void user_clicks_on_SVG_Element() throws Exception {
	    svgElement=driver.findElement(By.xpath("//*[local-name()='rect']"));
	    svgElement.click();
	    Thread.sleep(2000);
	}

	@Then("^SVG Element is highlighted$")
	public void svg_Element_is_highlighted() throws Exception {
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid green; background:Red')", svgElement);
		Thread.sleep(3000);
	}





}
