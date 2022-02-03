package winiumTest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessBrowser {

	@Test
	public void HeadlessBrowserTest() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.google.com");
		String Title=driver.getTitle();
		System.out.println("Browser Title is "+Title);
		Assert.assertTrue(Title.equals("Google"));
		

	}

}
