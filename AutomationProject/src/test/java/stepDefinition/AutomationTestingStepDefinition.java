package stepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationTestingStepDefinition extends BaseStepDefinition
{
	@Given("User navigates to Automation Testing portal")
	public void user_navigates_to_automation_testing_portal()
	{
	    driver.get("https://www.automationtesting.co.uk/index.html");
	}
	@When("User is on homepage of Automation Testing portal")
	public void user_is_on_homepage_of_automation_testing_portal() 
	{
		String homePageHeader=driver.findElement(By.tagName("h1")).getText();
	    Assert.assertEquals(homePageHeader, "Testing Arena");
	}
	@Then("menu has below links")
	public void menu_has_below_links(io.cucumber.datatable.DataTable dataTable)
	{
	    List<WebElement> allMenuOptions=driver.findElements(By.xpath("//nav[@id='menu']//li/a"));
	    List<List<String>> menuOptions=dataTable.asLists(String.class);
	    Assert.assertEquals(allMenuOptions.get(3).getText(), menuOptions.get(0).get(1));
	}
	
	@Given("User navigates to accordion page on Automation Testing portal")
	public void user_navigates_to_accordion_page_on_automation_testing_portal() 
	{
	    driver.findElement(By.xpath("//a[text()='Accordion']")).click();
	    String pageHeader=driver.findElement(By.cssSelector("h2#content")).getText();
	    Assert.assertEquals(pageHeader, "Accordion Test");
	}
	
	@Then("below accordion title is present {string}")
	public void below_accordion_title_is_present(String accordionTitle)
	{
	    boolean accordionPresent=driver.findElement(By.xpath("//div[text()='"+accordionTitle+"']")).isDisplayed();
	    Assert.assertTrue(accordionPresent,accordionTitle+" is not present");
	}
	
	@When("user navigates to Actions page")
	public void user_navigates_to_actions_page() 
	{
	    driver.get("https://www.automationtesting.co.uk/actions.html");
	}
	@When("user performs the drag and drop action")
	public void user_performs_the_drag_and_drop_action() throws InterruptedException 
	{
		WebElement draggable=driver.findElement(By.cssSelector("p#dragtarget"));
		WebElement dropTarget = driver.findElement(By.xpath("(//div[@class='droptarget'])[2]"));
	    actions.dragAndDrop(draggable, dropTarget).perform();
	    Thread.sleep(3000);
	}
	@Then("success message for drag and drop is displayed")
	public void success_message_for_drag_and_drop_is_displayed() 
	{
		String successMsg=driver.findElement(By.cssSelector("p#demo")).getText();
		Assert.assertEquals(successMsg, "The p element was dropped into an accepted rectangle");
	    
	}
	
	@When("user navigates to Date picker page")
	public void user_navigates_to_date_picker_page() 
	{
	    driver.findElement(By.xpath("//a[text()='Date Picker']")).click();
	}
	@When("user selects the date on date picker")
	public void user_selects_the_date_on_date_picker() throws InterruptedException
	{
	    driver.findElement(By.cssSelector("input#rangeDate")).click();
	    Thread.sleep(1000);
	}
	@Then("the date is selected on date picker")
	public void the_date_is_selected_on_date_picker() throws InterruptedException 
	{
	    driver.findElement(By.xpath("(//span[@class='flatpickr-day today'])[2]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//span[contains(@class,'flatpickr-day today')])[2]/following-sibling::span[1]")).click();
	    Thread.sleep(3000);
	}
	
	@When("user navigates to browser tabs page")
	public void user_navigates_to_browser_tabs_page() 
	{
	    driver.findElement(By.xpath("//a[text()='Browser Tabs']")).click();
	}
	@When("user clicks on open tab link")
	public void user_clicks_on_open_tab_link() {
	    driver.findElement(By.xpath("//input[@value='Open Tab']")).click();
	}
	@Then("the new tab gets opened")
	public void the_new_tab_gets_opened() {
	    String parentWin=driver.getWindowHandle();
	    Set<String> allWindows=driver.getWindowHandles();
	    Iterator<String> itr=allWindows.iterator();
	    String currentWin=null;
	    while(itr.hasNext())
	    {
	    	currentWin=itr.next();
	    	if(!parentWin.equalsIgnoreCase(currentWin))
	    	{
	    		driver.switchTo().window(currentWin);
	    		break;
	    	}
	    }
	    
	    Assert.assertEquals(driver.getTitle(), "Google");
	    
	}
	
	@When("user navigates to login page on AutomationTesting portal")
	public void user_navigates_to_login_page_on_automation_testing_portal() 
	{
	    WebElement loginPortalLink=driver.findElement(RelativeLocator.with(By.xpath("//a[text()='Login Portal Test']")).below(By.xpath("//a[text()='Loader Two']")));
	    js.executeScript("arguments[0].scrollIntoView();", loginPortalLink);
	    loginPortalLink.click();
	}
	@When("user enter below credentials on AutomationTesting portal login page")
	public void user_enter_below_credentials_on_automation_testing_portal_login_page(io.cucumber.datatable.DataTable dataTable) 
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(dataList.get(0).get(0));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(dataList.get(0).get(1));
		driver.findElement(By.id("login_btn")).click();
	    
	}
	@Then("the login is successful on AutomationTesting portal")
	public void the_login_is_successful_on_automation_testing_portal() throws InterruptedException 
	{
	   Alert successAlert= driver.switchTo().alert();
	   Assert.assertEquals(successAlert.getText(), "validation succeeded");
	   Thread.sleep(1000);
	   successAlert.accept();
	}
	
	@When("user navigates to about me page on AutomationTesting portal")
	public void user_navigates_to_about_me_page_on_automation_testing_portal()
	{
	  WebElement aboutMeLink=driver.findElement(By.xpath("//a[text()='About Me']")); 
	  js.executeScript("arguments[0].scrollIntoView();", aboutMeLink);
	  aboutMeLink.click();
	}
	@Then("the about me information is displayed on AutomationTesting portal")
	public void the_about_me_information_is_displayed_on_automation_testing_portal() 
	{
	    Assert.assertEquals("Our background, interests and goals.", driver.findElement(By.cssSelector("div.content>h2+h4")).getText());
	}

}
