package stepDefinition;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EBCStepDefinition extends BaseStepDefinition
{
	
	@Given("EBC portal is open")
	public void ebc_portal_is_open()
	{
	    driver.get("https://www.ebcflex.com/");
	}
	@When("User navigates to customer satisfaction section")
	public void user_navigates_to_customer_satisfaction_section() 
	{
	    WebElement customerSatisfactionLabel=driver.findElement(By.xpath("//h2[text()='Customer Satisfaction']"));
	    js.executeScript("arguments[0].scrollIntoView();", customerSatisfactionLabel);
	}
	@Then("customer satisfaction statistics are shown")
	public void customer_satisfaction_statistics_are_shown() throws InterruptedException 
	{
	    List<WebElement> percentages=driver.findElements(By.xpath("//div[contains(@class,'et_pb_number_counter')]//span[@class='percent-value']"));
	    List<WebElement> satisfactionMetrics=driver.findElements(By.xpath("//div[contains(@class,'et_pb_number_counter')]//h3"));
	    LinkedHashMap<String,String> satisfactionMap=new LinkedHashMap<>();
	    Thread.sleep(5000);
	    for(int i=0;i<satisfactionMetrics.size();i++)
	    {
	    	satisfactionMap.put(satisfactionMetrics.get(i).getText(), percentages.get(i).getText());
	    }
	    Assert.assertEquals(satisfactionMap.get("Customer Service Satisfaction Rate"), "99");
	    Assert.assertEquals(satisfactionMap.get("Professionalism Satisfaction Rate"), "99");
	    Assert.assertEquals(satisfactionMap.get("Knowledge of Products Satisfaction Rate"), "97");
	    Assert.assertEquals(satisfactionMap.get("Response Time Satisfaction Rate"), "97");
	    Assert.assertEquals(satisfactionMap.get("Implementation Satisfaction Rate"), "96");
	}


}
