package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OnlyTestingStepDefinition extends BaseStepDefinition
{
	
	@Given("Only Testing site is open")
	public void only_testing_site_is_open()
	{
	    driver.get("https://only-testing-blog.blogspot.com/");
	}
	@When("User navigates to Tooltip examples section")
	public void user_navigates_to_tooltip_examples_section() 
	{
	  WebElement tooltipLabel=driver.findElement(By.xpath("//h3[normalize-space(text())='Tooltip Example']"));
	  js.executeScript("arguments[0].scrollIntoView();", tooltipLabel);
	}
	@When("User enters below details")
	public void user_enters_below_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException 
	{
		List<Map<String,String>> dataList=dataTable.asMaps(String.class,String.class);
	    driver.findElement(By.xpath("//label[@for='name']/following-sibling::input[1]")).sendKeys(dataList.get(1).get("Name"));
	    driver.findElement(By.xpath("//label[@for='name']/following-sibling::input[2]")).sendKeys(dataList.get(0).get("Surname"));
	    driver.findElement(By.xpath("//label[@for='name']/following-sibling::input[3]")).sendKeys(dataList.get(0).get("Address"));
	    Thread.sleep(3000);
	}
	
	@When("User enters details {string},{string} and {string}")
	public void user_enters_details_and(String Name, String Surname, String Address) throws InterruptedException {
		driver.findElement(By.xpath("//label[@for='name']/following-sibling::input[1]")).sendKeys(Name);
	    driver.findElement(By.xpath("//label[@for='name']/following-sibling::input[2]")).sendKeys(Surname);
	    driver.findElement(By.xpath("//label[@for='name']/following-sibling::input[3]")).sendKeys(Address);
	    Thread.sleep(3000);
	}


}
