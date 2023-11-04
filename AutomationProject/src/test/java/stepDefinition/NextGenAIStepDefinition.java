package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NextGenAIStepDefinition extends BaseStepDefinition {
	String alertText,confirmAlertText,promptText;
	
	@Given("NextGenAI portal is open")
	public void next_gen_ai_portal_is_open() {
	    driver.get("https://nxtgenaiacademy.com");
	    
	    }
	
	@When("User navigates to alerts page")
	public void user_navigates_to_alerts_page() {
		
		//Navigating to NextGen Alert demo site
		driver.findElement(By.xpath("(//a[text()='Demo Sites'])[2]")).click();
		driver.findElement(By.xpath("(//a[text()='Practice Automation'])[2]")).click();
		driver.findElement(By.xpath("(//a[text()='Demo Site – Alert and Popup'])[2]")).click();
		
	}
	@When("User clicks on buttons to generate portals and handles them")
	public void user_clicks_on_buttons_to_generate_portals_and_handles_them() throws InterruptedException {
		
		
		//Handle alert
		driver.findElement(By.xpath("//button[@name='alertbox']")).click();
		Alert alert=driver.switchTo().alert();
		alertText=alert.getText();
		Thread.sleep(2000);
		alert.accept();
		
		//Handle confirm alert
		driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
		Alert alertConfirm=driver.switchTo().alert();
		confirmAlertText=alertConfirm.getText();
		Thread.sleep(2000);
		alertConfirm.accept();
		
		//Handle Prompt
		driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
		Alert prompt=driver.switchTo().alert();
		promptText=prompt.getText();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Yes");
		Thread.sleep(2000);
		prompt.accept();
		
	    
	}
	@Then("the texts on the popup is captured")
	public void the_texts_on_the_popup_is_captured() {
	    System.out.println("Alert box text: "+alertText);
	    System.out.println("Confirm alert text: "+confirmAlertText);
	    System.out.println("Prompt text: "+promptText);
	}
	
	@When("User navigates to Web table page")
	public void user_navigates_to_web_table_page() {
		//Navigating to NextGen Alert demo site
	    driver.findElement(By.xpath("(//a[text()='Demo Sites'])[2]")).click();
		driver.findElement(By.xpath("(//a[text()='Practice Automation'])[2]")).click();
		driver.findElement(By.xpath("(//a[text()='Demo Site – WebTable'])[2]")).click();
	}
	@Then("the web table values are printed")
	public void the_web_table_values_are_printed() {
	    int rowNum=driver.findElements(By.xpath("//table//tr")).size();
	    int colNum=driver.findElements(By.xpath("//table//tr[1]//td")).size();
	    
	    for(int i=1;i<=rowNum;i++)
	    {
	    	for(int j=1;j<=colNum;j++)
	    	{
	    		System.out.print(driver.findElement(By.xpath("//table//tr["+i+"]//td["+j+"]")).getText()+" ");
	    		
	    	}
	    	System.out.println();
	    }
	}




}
