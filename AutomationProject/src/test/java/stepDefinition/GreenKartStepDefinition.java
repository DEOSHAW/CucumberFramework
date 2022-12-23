package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GreenKartStepDefinition extends BaseStepDefinition {
	static int count=0;
	
	@Given("^Green Kart portal is launched$")
	public void green_Kart_portal_is_launched() throws Exception {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
	}
	
	@When("^User searches for below vegetables$")
	public void user_searches_for_below_vegetables(DataTable table) throws Exception {
	   List<Map<String,String>> vegList=table.asMaps(String.class, String.class);
	   String vegetable=vegList.get(1).get("Vegetable");
	   driver.findElement(By.xpath("//*[@type='search']")).sendKeys(vegetable);
	}

	@When("^User adds products to the cart$")
	public void user_adds_products_to_the_cart() throws Exception {
		
		Thread.sleep(1500);
	    List<WebElement> availableVegetables=driver.findElements(By.xpath("//*[text()='ADD TO CART']"));
	    for(WebElement veg:availableVegetables)
	    {
	    	js.executeScript("arguments[0].click();", veg);
	    	count++;
	    	Thread.sleep(1000);
	    }
	}

	@Then("^the products are displayed in the cart$")
	public void the_products_are_displayed_in_the_cart() throws Exception {
	    String noOfItemsInCart=driver.findElement(By.xpath("//td[text()='Items']/parent::tr//td/strong")).getText();
	    
	    int noOfItems=Integer.parseInt(noOfItemsInCart);
	    if(noOfItems==count)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false,"All items not added to the cart");
	    }
	}



}
