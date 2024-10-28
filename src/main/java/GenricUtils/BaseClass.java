package GenricUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}// end of afterClass
}