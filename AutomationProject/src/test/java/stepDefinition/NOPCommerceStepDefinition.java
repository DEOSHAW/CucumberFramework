package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NOPCommerceStepDefinition extends BaseStepDefinition {
	
	@Given("^NOPCommerce portal is open$")
	public void nopcommerce_portal_is_open() throws Exception {
	    driver.get("https://demo.nopcommerce.com/");
	}

	@When("^User searches for below on NOPCommerce portal$")
	public void user_searches_for_below_on_NOPCommerce_portal(DataTable data) throws Exception {
		List<List<String>> dataList=data.asLists(String.class);
		
	    driver.findElement(By.xpath("//input[@placeholder='Search store']")).sendKeys(dataList.get(1).get(1));
	    driver.findElement(By.xpath("//button[text()='Search']")).click();
	}

	@Then("^the product is displayed NOPCommerce portal$")
	public void the_product_is_displayed_NOPCommerce_portal() throws Exception {
	  String searchResult= driver.findElement(By.xpath("//div[@class='no-result']")).getText();
	  Assert.assertEquals(searchResult, "No products were found that matched your criteria.");
	}


}
