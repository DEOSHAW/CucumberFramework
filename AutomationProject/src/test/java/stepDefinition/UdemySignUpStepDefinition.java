package stepDefinition;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UdemySignUpStepDefinition extends BaseStepDefinition {
	
	@Given("^Udemy Sign Up page is open$")
	public void udemy_Sign_Up_page_is_open() throws Exception {
	    driver.get("https://www.udemy.com/join/signup-popup/");
	}

	@When("^user enters below details on the page$")
	public void user_enters_below_details_on_the_page(DataTable table) throws Exception {
	    
		List<List<String>> list=table.asLists(String.class);
		driver.findElement(By.xpath("//*[@name='fullname']")).sendKeys(list.get(0).get(0));
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(list.get(0).get(1));
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(list.get(0).get(2));
		Thread.sleep(500);
	}

	@Then("^the deatils are displayed on the signUp page$")
	public void the_deatils_are_displayed_on_the_signUp_page() throws Exception {
		File src=driver.findElement(By.xpath("//*[@for='checkbox--7']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+File.separator+"UdemySignup.png"));
	    System.out.println("All details entered and screenshot Captured");
	}

	

}
