package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormulaEStepDefinition extends BaseStepDefinition
{
	static String menuName;
	@Given("Formula-E portal is open")
	public void formula_e_portal_is_open() 
	{
	    driver.get("https://www.fiaformulae.com/en");
	    WebElement cookiesButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#onetrust-accept-btn-handler")));
        js.executeScript("arguments[0].click();", cookiesButton);	
	}
	@When("User provides below menu to highlight")
	public void user_provides_below_menu_to_highlight(DataTable dataTable)
	{
	    List<Map<String,String>> dataList=dataTable.asMaps(String.class,String.class);
	    menuName= dataList.get(1).get("Menu");
	}
	@Then("menu is highlighted on Formula-E portal")
	public void menu_is_highlighted_on_formula_e_portal() throws InterruptedException
	{
		WebElement menuElement=driver.findElement(By.xpath("//a[text()='"+menuName+"']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", menuElement);
		Thread.sleep(3000);
		
	    
	}


}
