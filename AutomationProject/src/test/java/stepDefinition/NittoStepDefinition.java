package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NittoStepDefinition extends BaseStepDefinition
{
	List<Map<String,String>> dataList;
	@Given("User is on Nitto portal")
	public void user_is_on_nitto_portal() {
	    driver.get("https://www.nitto.com/");
	}
	@When("User looks for below on Nitto portal")
	public void user_looks_for_below_on_nitto_portal(io.cucumber.datatable.DataTable dataTable) {
	    dataList=dataTable.asMaps(String.class, String.class);
	    
	}
	@Then("the country is located on the web page")
	public void the_country_is_located_on_the_web_page() throws InterruptedException
	{
		String country=dataList.get(1).get("Country");
	    WebElement countryElement=driver.findElement(By.xpath("//span[text()='"+country+"']"));
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", countryElement);
	    Thread.sleep(3000);
	}




}
