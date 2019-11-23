package winiumTest;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {
	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Throwable {
		
		System.out.println("Verify that the user is on homepage");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
	}
	
	    

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		System.out.println("Verify that the user navigates to Login Page");
		
	    
	}

	@When("^user enters Credentials$")
	public void user_enters_Credentials(DataTable usercredentials) throws Throwable {
		for(Map<String, String> data : usercredentials.asMaps(String.class, String.class))
		{
			System.out.println("Username is"+data.get("Username"));
			System.out.println("Username is"+data.get("Password"));
			
		}
	    
	    
	}


	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		System.out.println("Verify that the success message is displayed");
	    
	}
	
	@And("^success message is displayed in pretty format$")
	public void success_message_is_displayed_in_pretty_format() throws Throwable {
		System.out.println("Verify that the success message is displayed in pretty format");
	    
	}



}
