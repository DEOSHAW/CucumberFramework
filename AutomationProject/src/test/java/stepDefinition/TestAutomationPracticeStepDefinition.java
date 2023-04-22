package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestAutomationPracticeStepDefinition extends BaseStepDefinition
{
	
	@Given("^TestAutomationPractice portal is open$")
	public void testautomationpractice_portal_is_open() throws Exception {
	    driver.get("https://testautomationpractice.blogspot.com/");
	}

	@When("^User types below text in Field1")
	public void user_types_below_text_in_Field(DataTable data) throws Exception {
	    
		
		List<Map<String,String>> dataList=data.asMaps(String.class, String.class);
		WebElement field1TextBox=driver.findElement(By.cssSelector("#field1"));
		field1TextBox.clear();
		field1TextBox.sendKeys(dataList.get(0).get("Text"));
	}

	@When("^User double clicks on the copy text button$")
	public void user_double_clicks_on_the_copy_text_button() throws Exception {
	   WebElement copyButton= driver.findElement(By.xpath("//button[string()='Copy Text']"));
	   actions.doubleClick(copyButton).perform();
	}

	@Then("^the text is copied to Field2")
	public void the_text_is_copied_to_Field() throws Exception {
		WebElement field2TextBox=driver.findElement(By.cssSelector("#field2"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", field2TextBox); 
		Thread.sleep(3000);
	}

}
