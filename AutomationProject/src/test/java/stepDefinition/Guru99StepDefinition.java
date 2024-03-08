package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Guru99StepDefinition extends BaseStepDefinition
{
	@Given("Guru99 portal is open")
	public void guru99_portal_is_open() 
	{
	   driver.get("https://demo.guru99.com/test/newtours/support.php"); 
	}
	@When("User navigates to tooltip page")
	public void user_navigates_to_tooltip_page() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'Selenium') and @class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[text()='Tooltip']")).click();
	   
	}
	@When("User hovers over tooltip of Download link")
	public void user_hovers_over_tooltip_of_download_link() 
	{
	   WebElement downloadLink= driver.findElement(By.xpath("//a[text()='Download now']"));
	   actions.moveToElement(downloadLink).perform();
	}
	@Then("Content of tooltip is displayed")
	public void content_of_tooltip_is_displayed()
	{
	   List<WebElement> tooltipInformation= driver.findElements(By.xpath("//table[contains(@style,'margin:0')]//tr//td"));
	   StringBuilder tooltipInfo=new StringBuilder();
	   Iterator<WebElement> itr=tooltipInformation.iterator();
	   WebElement eachElement;
	   String elementText = "";
	   while(itr.hasNext())
	   {
		   eachElement=itr.next();
		   if(eachElement.getAttribute("class").equalsIgnoreCase("label"))
		   {
		   elementText=eachElement.getText()+": ";
		   }
		   else
		   {
			   elementText=eachElement.getText()+"\n";
		   }
		   tooltipInfo.append(elementText);
	   }
	   System.out.println(tooltipInfo);
	}


}
