package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorksoftStepDefinition extends BaseStepDefinition
{
	 List<List<String>> dataList;
	@Given("Worksoft portal is open")
	public void worksoft_portal_is_open() {
	    driver.get("https://www.worksoft.com/");
	}
	@When("User looks for below product")
	public void user_looks_for_below_product(io.cucumber.datatable.DataTable dataTable) 
	{
	    driver.findElement(By.xpath("//button[normalize-space(text())='Solutions']")).click();
	    dataList=dataTable.asLists(String.class);
	}
	@Then("the product is highlighted")
	public void the_product_is_highlighted() throws InterruptedException 
	{
		WebElement product=driver.findElement(By.xpath("(//span[text()='"+dataList.get(1).get(0)+"'])[2]"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", product);
		Thread.sleep(3000);
	}




}
