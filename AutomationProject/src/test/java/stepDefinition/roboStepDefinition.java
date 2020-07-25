package stepDefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class roboStepDefinition {
	WebDriver driver;
	JavascriptExecutor js;
	String parentWin;
	
	@Given("^Robo portal is launched$")
	public void robo_portal_is_launched() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.navigate().to("https://robotframework.org/");
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    parentWin=driver.getWindowHandle();
	}

	@When("^open Libraries link in a new tab$")
	public void open_Libraries_link_in_a_new_tab() throws Throwable {
	    js=(JavascriptExecutor)driver;
	    WebElement libLink=driver.findElement(By.xpath("(//a[text()='libraries'])[2]"));
	    js.executeScript("arguments[0].scrollIntoView(true);", libLink);
	    String input=Keys.chord(Keys.CONTROL,Keys.ENTER);
	    libLink.sendKeys(input);
	    
	}

	@When("^Validate the Libraries text on page$")
	public void validate_the_Libraries_text_on_page() throws Throwable {
		Set<String> windows=driver.getWindowHandles();
		for(String win:windows)
		{
			if(!win.equals("parentWin"))
			{
				driver.switchTo().window(win);
				
			}
		}
		
		String libText=driver.findElement(By.xpath("//h1[text()='Libraries']")).getText();
		System.out.println("Text is: "+libText);
		
	    Assert.assertTrue(libText.contains("LIBRARIES"),"Validation unsuccessful");
	}

@Then("^robo Site is closed$")
public void robo_Site_is_closed() throws Throwable {
    driver.quit();
}
	



}
