package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViaBenefitsStepDefinition extends BaseStepDefinition
{
	@Given("Via Benefits portal is open")
	public void via_benefits_portal_is_open() 
	{
		driver.get("https://www.viabenefits.com/");
	    
	}
	@When("User navigates to login page of Via Benefits")
	public void user_navigates_to_login_page_of_via_benefits() {
	    driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
	}
	@Then("Login page of Via Benefits is loaded with below message")
	public void login_page_of_via_benefits_is_loaded_with_below_message(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists();
		String text=dataList.get(0).get(1);
		String textMessage=driver.findElement(By.xpath("//*[text()='"+text+"']")).getText();
		Assert.assertEquals(textMessage, text);
	    
	}


}
