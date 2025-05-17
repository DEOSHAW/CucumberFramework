package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NWSStepDefinition extends BaseStepDefinition
{
	@Given("NWS portal is open")
	public void nws_portal_is_open()
	{
	    driver.get("https://www.weather.gov/documentation/services-web-api");
	}
	@Then("user switches to below tab")
	public void user_switches_to_below_tab(io.cucumber.datatable.DataTable dataTable)
	{
	    List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
	    String dataTableValue=dataList.get(3).get("TabName");
	    driver.findElement(By.xpath("//span[text()='"+dataTableValue+"']")).click();
	    WebElement tabHeading=driver.findElement(By.xpath("//h2[contains(text(),'"+dataTableValue+"')]"));
	    Assert.assertTrue(tabHeading.getText().contains(dataTableValue),"Tab heading did not match");
	    
	}


}
