package stepDefinition;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwaggerStepDefinition extends BaseStepDefinition {
	
	@Given("^Swagger portal is open$")
	public void swagger_portal_is_open() throws Exception {
		
		driver.get("https://swagger.io/");
	    
	}

	@When("^user gets the list of open source tools$")
	public void user_gets_the_list_of_open_source_tools() throws Exception {
	    driver.findElement(By.xpath("//*[text()='Tools']")).click();
	}

	@Then("^Open Source tools are displayed$")
	public void open_Source_tools_are_displayed() throws Exception {
	   Iterator<WebElement> itr=driver.findElements(By.xpath("//*[@id='openSource']//span")).iterator();
	   System.out.println("Open Source tools: ");
	   while(itr.hasNext())
	   {
		   System.out.println(itr.next().getText());
	   }
	   
	   System.out.println("*******************************");
	}



}
