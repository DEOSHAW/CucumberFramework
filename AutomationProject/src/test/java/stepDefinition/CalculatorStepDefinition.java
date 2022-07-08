package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorStepDefinition extends BaseStepDefinition {
	
	@Given("^Calculator portal is open$")
	public void calculator_portal_is_open() throws Exception {
	    driver.get("https://www.calculator.net/");
	}

	@When("^user enters below two numbers$")
	public void user_enters_below_two_numbers(DataTable table) throws Exception {
	   List<Map<String,Integer>> numList=table.asMaps(String.class, Integer.class);
	   driver.findElement(By.xpath("//*[@class='scinm' and text()='"+numList.get(0).get("number1")+"']")).click();
	   driver.findElement(By.xpath("//*[@class='sciop' and text()='+']")).click();
	   driver.findElement(By.xpath("//*[@class='scinm' and text()='"+numList.get(1).get("number2")+"']")).click();
	}

	@Then("^the result of addition is displayed$")
	public void the_result_of_addition_is_displayed() throws Exception {
		String result=driver.findElement(By.xpath("//*[@id='sciOutPut']")).getText();
		System.out.println("Result is: "+result);
	}



}
