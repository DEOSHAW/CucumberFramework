package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumBaseIoStepDefinition extends BaseStepDefinition
{
	static String colourAttribute;
	static WebElement paragraphText;
	
	@Given("User is on SeleniumBaseIO portal is open")
	public void user_is_on_selenium_base_io_portal_is_open() 
	{
	    driver.get("https://seleniumbase.io/demo_page/");
	}
	@When("User navigates to iframe text")
	public void user_navigates_to_iframe_text() 
	{
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()='Image in iFrame:']")));
	}
	@Then("iframe text is highlighted")
	public void iframe_text_is_highlighted() throws InterruptedException 
	{
		driver.switchTo().frame("frameName2");
		WebElement iframeText=driver.findElement(By.tagName("h4"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", iframeText);
		Thread.sleep(300);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("myFrame3");
		driver.findElement(By.id("checkBox6")).click();
		Thread.sleep(1000);    
	}
	
	@When("User extracts the colour")
	public void user_extracts_the_colour()
	{
	    colourAttribute=driver.findElement(By.xpath("//*[local-name()='rect']")).getAttribute("fill");
	}
	@Then("Colour is displayed")
	public void colour_is_displayed()
	{
		System.out.println("Attribute of the colour: "+colourAttribute);
	    Assert.assertEquals(colourAttribute, "#4CA0A0");
	}
	
	@When("User is navigated to corresponding portal")
	public void user_is_navigated_to_corresponding_portal(io.cucumber.datatable.DataTable dataTable) 
	{
	    List<List<String>> allLinks=dataTable.asLists(String.class);
	    driver.findElement(By.linkText(allLinks.get(0).get(0))).click();
	    Assert.assertTrue(driver.getCurrentUrl().contains(allLinks.get(0).get(0)));
	}
	
	@When("User navigates paragraph text")
	public void user_navigates_paragraph_text()
	{
		paragraphText=driver.findElement(RelativeLocator.with(By.cssSelector("#pText")).toRightOf(By.xpath("//p[text()='Paragraph with Text:']")));
	}
	@Then("the text is highlighted")
	public void the_text_is_highlighted() throws InterruptedException
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Green')", paragraphText);
		Thread.sleep(3000);
	}


}
