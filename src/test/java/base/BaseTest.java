package base;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import pages.RegisterPage;

public class BaseTest {

	private WebDriver driver;
	protected RegisterPage registerPage;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\user\\Desktop\\Automation "
		+ "Testing\\SDET_TASK\\SDET_Task\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		goRegisterPage();
		
		registerPage = new RegisterPage(driver);
	}
	
	@AfterMethod
	public void takeScreenShots(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.move(screenShot,new File("C:\\Users\\user\\Desktop\\Automation Testing\\SDET_TASK\\SDET_Task\\resources\\ScreenShot\\test.png"));
			} catch (IOException e) {	
				e.printStackTrace();
			}		
		}
	
	}
	
	@BeforeMethod
	public void goRegisterPage() {
		driver.get("https://www.phptravels.net/register");
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

