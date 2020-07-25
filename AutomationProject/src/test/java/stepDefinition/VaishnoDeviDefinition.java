package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VaishnoDeviDefinition {
	
	WebDriver driver=null;
	List<WebElement> allLinks;
	
	@Given("^Vaishno Devi portal is launched$")
	public void vaishno_Devi_portal_is_launched() throws Throwable {
		
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.get("https://www.maavaishnodevi.org/index.aspx");
		   
	  
	  
	}

	@When("^Get all the links$")
	public void get_all_the_links() throws Throwable {
		driver.findElement(By.xpath("//*[@id='menu']/li[3]/a")).click();
		allLinks=driver.findElements(By.tagName("a"));
		int count=allLinks.size();
		System.out.println("Total links found: "+count);
	    
	}

	

	@Then("^The Shrine board portal is closed$")
	public void the_Shrine_board_portal_is_closed() throws Throwable {
	    driver.quit();
	}



}
