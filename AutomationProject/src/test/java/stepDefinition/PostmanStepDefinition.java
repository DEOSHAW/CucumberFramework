package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostmanStepDefinition extends BaseStepDefinition {
	
	
	@Given("^Postman portal is launched$")
	public void postman_portal_is_launched() throws Throwable {
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		   driver.get("https://www.postman.com/");
		  
	    
	    
	}

	@When("^User handles all the Pop Ups$")
	public void user_handles_all_the_Pop_Ups() throws Throwable {
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement close=driver.findElement(By.xpath("//*[text()='X']"));
		wait.until(ExpectedConditions.visibilityOf(close)).click();
		String text=driver.findElement(By.xpath("//*[contains(text(),'This website uses cookies')]")).getText();
		System.out.println("Text is: "+text);
		driver.findElement(By.xpath("//*[contains(text(),'Close')]")).click();
		Thread.sleep(2000);
		
	    
	}
	
	@And("^Postman Portal is closed$")
	public void portal_is_closed() throws Throwable {
		driver.close();
	   
	}



}
