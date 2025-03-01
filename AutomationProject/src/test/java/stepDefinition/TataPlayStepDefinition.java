package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TataPlayStepDefinition extends BaseStepDefinition
{
	static List<Map<String,String>> dataList;
	
	@Given("Tata Play portal is open")
	public void tata_play_portal_is_open() 
	{
	  driver.get("https://www.tataplay.com/");  
	}
	@When("User selects below link")
	public void user_selects_below_link(io.cucumber.datatable.DataTable dataTable)
	{
		dataList=dataTable.asMaps(String.class,String.class);
	    
	}
	@Then("the selected link is highlighted on Tataplay portal")
	public void the_selected_link_is_highlighted_on_tataplay_portal() throws InterruptedException 
	{
		WebElement linkElement=driver.findElement(By.xpath("//a[text()='"+dataList.get(1).get("Link")+"']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", linkElement);
		System.out.println("The link text is: "+linkElement.getText());
		Thread.sleep(2500);
		
	    
	}




}
