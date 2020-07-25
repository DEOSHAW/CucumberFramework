package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilitiesSelenium.UtilitiesClass;

public class seleniumEasyDefinition {
	WebDriver driver=null;
	
	@Given("^seleniumEasy portal is launched$")
	public void seleniumeasy_portal_is_launched() throws Throwable {
		driver=UtilitiesClass.LaunchBrowser(driver,"https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
	}

	@When("^select first two items from the list$")
	public void select_first_two_items_from_the_list() throws Throwable {
	    WebElement List=driver.findElement(By.xpath("//select[@class='form-control pickListSelect pickData']"));
	    Select jqueryList=new Select(List);
	    if(jqueryList.isMultiple())
	    {
	    	jqueryList.selectByVisibleText("Isis");
	    	jqueryList.selectByVisibleText("Manuela");
	    	driver.findElement(By.xpath("//button[normalize-space(text())='Add']")).click();
	    }
	    
	}

	@When("^Validate the items from the list$")
	public void validate_the_items_from_the_list() throws Throwable {
	  WebElement secondList=driver.findElement(By.xpath("//*[@class='form-control pickListSelect pickListResult']"));
	  Select destList=new Select(secondList);
	  List<WebElement> list=destList.getOptions();
	  Iterator<WebElement> itr=list.iterator();
	  while(itr.hasNext())
	  {
		 String text=itr.next().getText();
		 System.out.println(text);
	  }
	}
	
	@Then("^Site is closed$")
	public void site_is_closed() throws Throwable {
	    driver.close();
	}




}
