package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	
	private WebDriver driver;
	private By profileName = By.cssSelector(".text-align-left"); 
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProfileName() {
		return driver.findElement(profileName).getText();
	}

}
