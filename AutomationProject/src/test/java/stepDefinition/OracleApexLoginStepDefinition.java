package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OracleApexLoginStepDefinition extends BaseStepDefinition {
	
	@Given("^Oracle Apex Application is open$")
	public void oracle_Apex_Application_is_open() throws Exception {
	    driver.get("https://apex.oracle.com/en/");
	}

	@When("^user logs in with below details$")
	public void user_logs_in_with_below_details(DataTable table) throws Exception {
		List<List<String>> list=table.asLists(String.class);
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Workspace']")).sendKeys(list.get(1).get(0));
		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(list.get(1).get(1));
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(list.get(1).get(2));
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		Thread.sleep(2500);
	    
	}

	@Then("^the login should be unsuccessful$")
	public void the_login_should_be_unsuccessful() throws Exception {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='errorMsg-Message']")));
	}



}
