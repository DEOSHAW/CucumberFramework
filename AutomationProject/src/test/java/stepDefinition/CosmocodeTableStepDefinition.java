package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CosmocodeTableStepDefinition extends BaseStepDefinition
{
	static String country;
	@Given("CosmoCode table page is open")
	public void cosmo_code_table_page_is_open() 
	{
	    driver.get("https://cosmocode.io/automation-practice-webtable/");
	}
	@When("User finds below country")
	public void user_finds_below_country(io.cucumber.datatable.DataTable dataTable) 
	{
	    List<List<String>> dataList=dataTable.asLists(String.class);
	    country=dataList.get(1).get(0);
	}
	@Then("the checkbox is selected on Cosmocode table")
	public void the_checkbox_is_selected_on_cosmocode_table() throws InterruptedException 
	{
		int rowNum=driver.findElements(By.xpath("//table//tbody//tr")).size();
		String countryText="";
		WebElement countryElement;
		for(int i=2;i<=rowNum;i++)
		{
			countryElement=driver.findElement(By.xpath("//table//tbody//tr["+i+"]/td[2]/strong"));
			countryText=countryElement.getText();
			if(countryText.equalsIgnoreCase(country))
			{
				js.executeScript("arguments[0].scrollIntoView();", countryElement);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//table//tbody//tr["+i+"]/td[1]/input")).click();
				Thread.sleep(3000);
				break;
			}
		}
	    
	}

}
