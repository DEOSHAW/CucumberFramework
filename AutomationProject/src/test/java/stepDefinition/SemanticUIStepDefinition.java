package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SemanticUIStepDefinition extends BaseStepDefinition
{
	static WebElement standardInputBox;
	@Given("SemanticUI portal is open")
	public void semantic_ui_portal_is_open() 
	{
	    driver.get("https://semantic-ui.com/");
	}
	@When("User types below in the input box")
	public void user_types_below_in_the_input_box(io.cucumber.datatable.DataTable dataTable)
	{
	   driver.findElement(By.cssSelector("a.ui.huge.inverted.download.button")).click();
	   driver.findElement(By.xpath("(//a[normalize-space(text())='Input'])[2]")).click();
	   standardInputBox=driver.findElement(By.xpath("(//div[@class='example'])[1]//input"));
	   js.executeScript("arguments[0].scrollIntoView();", standardInputBox);
	   List<List<String>> dataList=dataTable.asLists(String.class);
	   standardInputBox.sendKeys(dataList.get(1).get(0));
	   
	}
	@Then("the input box is highlighted")
	public void the_input_box_is_highlighted() throws InterruptedException 
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", standardInputBox);
		Thread.sleep(3000);
	}




}
