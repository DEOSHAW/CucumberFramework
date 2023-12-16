package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UltimateQAStepDefinition extends BaseStepDefinition 
{
	List<WebElement> planNames,planPrices;
	Select carDropdown;
	
	
	@Given("User opens UltimateQA portal")
	public void user_opens_ultimate_qa_portal() 
	{
	   driver.get("https://ultimateqa.com/automation/?ref=hackernoon.com");
	}
	@When("User extracts the pricing")
	public void user_extracts_the_pricing()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Fake Pricing Page')]")).click();
		planNames=driver.findElements(By.cssSelector("div.et_pb_pricing_heading h4"));
		planPrices=driver.findElements(By.cssSelector("span.et_pb_sum"));
	}
	@Then("Pricing is displayed")
	public void pricing_is_displayed() throws InterruptedException 
	{
		StringBuilder Plans=new StringBuilder();
		
		for(int i=0;i<planNames.size();i++)
		{
			Plans.append(planNames.get(i).getText()+"==>"+planPrices.get(i).getText());
			Plans.append("\n");
			
			
		}
		js.executeScript("alert(arguments[0])", Plans.toString());
		Thread.sleep(2500);
		driver.switchTo().alert().dismiss();
	   
	}
	
	@When("User lands on the dropdown page")
	public void user_lands_on_the_dropdown_page() {
	    driver.findElement(By.xpath("//a[contains(text(),'Interactions with simple elements')]")).click();
	}
	@When("User Selects a value from the dropdown")
	public void user_selects_a_value_from_the_dropdown() {
		WebElement carDropdownElement=driver.findElement(By.xpath("//select"));
		carDropdown=new Select(carDropdownElement);
	    
	}
	@Then("Selected value is displayed")
	public void selected_value_is_displayed() {
		carDropdown.selectByValue("audi");
		List<WebElement> selectedElements=carDropdown.getAllSelectedOptions();
		System.out.println("Total Selected options is: "+selectedElements.size());
		for(WebElement ele:selectedElements)
		{
			System.out.println("Selected option is "+ele.getText());
		}
	}





}
