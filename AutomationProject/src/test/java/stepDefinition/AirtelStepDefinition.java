package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AirtelStepDefinition extends BaseStepDefinition
{
	@Given("Airtel portal is open")
	public void airtel_portal_is_open()
	{
	    driver.get("https://www.airtel.in/");
	}
	@When("User Navigates to Products section")
	public void user_navigates_to_products_section() 
	{
	   driver.findElement(By.xpath("//label[text()='BUSINESS']/parent::a")).click();
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Products']")))).click();
	}
	@Then("list of products for Airtel is displayed")
	public void list_of_products_for_airtel_is_displayed() throws InterruptedException
	{
	    List<WebElement> productsList=driver.findElements(By.xpath("//li[@class='focus']//div[@class='sidebar_nav_wrapper_scroller']//a"));
	    Iterator<WebElement> itr=productsList.iterator();
	    StringBuilder sb=new StringBuilder();
	    while(itr.hasNext())
	    {
	    	sb.append(itr.next().getText());
	    	sb.append("\n");
	    	
	    }
	    
	    js.executeScript("alert(arguments[0])", sb.toString());
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
	}




}
