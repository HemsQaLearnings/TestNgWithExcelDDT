package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import GenricUtils.BaseClass;

public class LoginTest extends BaseClass {
	WebElement homepageDashboard;
	@Test(dataProvider = "class2", dataProviderClass = Dataprovider_Class2.class)
	public void loginTest(String user, String pass, String exp) throws InterruptedException 
	{
		
		WebElement txtUserName = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@placeholder='Username']"))));
		txtUserName.clear();
		txtUserName.sendKeys(user);
	
		WebElement txtPassword = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@placeholder='Password']"))));
		txtPassword.clear();
		txtPassword.sendKeys(pass);

		driver.findElement(By.xpath("//button[@type='submit']")).click(); // loginButton
		Thread.sleep(2000);

	
		String exp_title = "Dashboard";

		if (exp.equalsIgnoreCase("VALID")) 
		{
			WebElement homepageDashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
			
			String act_title = homepageDashboard.getText();
			System.out.println(act_title);
			
			//exp_title = "Dashboard";
			if (exp_title.equalsIgnoreCase(act_title)) {
				
				WebElement profile = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))));
				profile.click();
				WebElement logout_btn = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//a[text()='Logout']"))));
				logout_btn.click();
				Assert.assertTrue(true);
			} 
			else {
				Assert.assertTrue(false);
			}
		} 

		else if (exp.equalsIgnoreCase("InVALID")) 
		{
			String LoginPage_title ="OrangeHRM"; //manually according to crs
			System.out.println(LoginPage_title);
			//exp_title = "Dashboard";
			if (exp_title.equalsIgnoreCase(LoginPage_title))
			{
				
				WebElement profile = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))));
				profile.click();
				WebElement logout_btn = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//a[text()='Logout']"))));
				logout_btn.click();
				Assert.assertTrue(false);
			} 
			else {
				Assert.assertTrue(true);
			}
		} 
	}//end of Test loop
	
}
