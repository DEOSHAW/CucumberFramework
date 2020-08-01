package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class webTableDefinition {
	WebDriver driver=null;
	
	
	
	@Given("^Web table portal is launched$")
	public void web_table_portal_is_launched() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.get("http://demo.guru99.com/test/web-table-element.php");
	    
	}

	@When("^Page title is verified$")
	public void page_title_is_verified() throws Throwable {
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Web Table Elements");
	   
	}

	@Then("^Print all the values$")
	public void print_all_the_values() throws Throwable {
		
		int col=driver.findElements(By.xpath("//*[@class='dataTable']//tr[1]//td")).size();
		int row=driver.findElements(By.xpath("//*[@class='dataTable']//tr")).size();
		System.out.println("Number of rows: "+row);
		System.out.println("values in the Table are: ");
		for(int i=1;i<row;i++)
		{
			
			for(int j=1;j<=col;j++)
			{
				String value=driver.findElement(By.xpath("//*[@class='dataTable']//tr["+i+"]/td["+j+"]")).getText();
				System.out.print(value+" ");
			}
			System.out.println();
				
	   
	    }
		driver.close();



   }
}
