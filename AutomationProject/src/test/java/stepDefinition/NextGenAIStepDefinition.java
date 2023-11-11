package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NextGenAIStepDefinition extends BaseStepDefinition {
	String alertText,confirmAlertText,promptText,pageText;
	
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
	
	@When("User navigates to iframes page")
	public void user_navigates_to_iframes_page() {
		driver.findElement(By.xpath("(//a[text()='Demo Sites'])[2]")).click();
		driver.findElement(By.xpath("(//a[text()='Practice Automation'])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'iFrames')])[2]")).click();
	    
	}
	@When("User switches to Forms section and fills the form")
	public void user_switches_to_forms_section_and_fills_the_form() {
		driver.switchTo().frame("formpage");
		driver.findElement(By.xpath("//label[normalize-space(text())='First Name']/following-sibling::input")).sendKeys("iFrame");
		driver.findElement(By.xpath("//label[normalize-space(text())='Last Name']/following-sibling::input")).sendKeys("Test");
	}
	@When("User extracts main page text")
	public void user_extracts_main_page_text() {
		driver.switchTo().defaultContent();
		WebElement pageTitle=driver.findElement(By.xpath("//h2/center"));
		pageText=(String) js.executeScript("return arguments[0].innerHTML;", pageTitle);
	   
	}
	@Then("Page text validation is successful")
	public void page_text_validation_is_successful() {
	    Assert.assertEquals(pageText, "I Frame Demo Page");
	}







}
