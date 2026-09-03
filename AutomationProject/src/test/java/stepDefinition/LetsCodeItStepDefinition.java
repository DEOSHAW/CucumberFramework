package stepDefinition;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LetsCodeItStepDefinition extends BaseStepDefinition
{
	static String textToType=null;
	@Given("Lets code it portal is open")
	public void lets_code_it_portal_is_open() 
	{
	    driver.get("https://www.letskodeit.com/practice");
	}
	@When("User types below")
	public void user_types_below(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		textToType=dataList.get(1).get(0);
	    driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(dataList.get(1).get(0));
	}
	@When("clicks on confirm button")
	public void clicks_on_confirm_button()
	{
	    driver.findElement(By.id("confirmbtn")).click();
	}
	@Then("confirm pop up is displayed")
	public void confirm_pop_up_is_displayed() throws InterruptedException 
	{
	    Alert alert=driver.switchTo().alert();
	    Assert.assertEquals(alert.getText(), "Hello "+textToType+", Are you sure you want to confirm?");
	    Thread.sleep(3000);
	    alert.accept();
	    Thread.sleep(2000);
	}


}
