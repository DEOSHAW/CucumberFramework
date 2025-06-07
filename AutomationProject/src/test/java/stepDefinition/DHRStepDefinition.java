package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DHRStepDefinition extends BaseStepDefinition
{
	@Given("DHR portal is open")
	public void dhr_portal_is_open() 
	{
	    driver.get("https://dhr.indianrailways.gov.in/index.jsp");
	}
	@When("User clicks on below")
	public void user_clicks_on_below(io.cucumber.datatable.DataTable dataTable) throws InterruptedException
	{
	    List<Map<String,String>> menuList=dataTable.asMaps();
	    String menuName=menuList.get(3).get("MenuName");
	    driver.findElement(By.xpath("//a[contains(text(),'"+menuName+"')]")).click();
	    Thread.sleep(2000);
	}

}
