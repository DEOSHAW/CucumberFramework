package stepDefinition;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PgtiStepDefinition extends BaseStepDefinition
{
	@Given("PGTI portal is open")
	public void pgti_portal_is_open()
	{
	    driver.get("https://www.pgtofindia.com/");
	}
	@Then("title of PGTI portal is below")
	public void title_of_pgti_portal_is_below(io.cucumber.datatable.DataTable dataTable)
	{
	    List<List<String>> dataList=dataTable.asLists(String.class);
	    Assert.assertEquals(driver.getTitle(), dataList.get(0).get(0));
	}
	







}
