package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage  {
	
	private WebDriver driver;
	private By fisrtName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By phoneNumber = By.name("phone");
	private By emailField = By.name("email");
	private By passwordField = By.name("password");
	private By confirmPasswordField = By.name("confirmpassword");
	private By signupButton = By.cssSelector(".form-group button");
	private By ValidationMessage = By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void setFristName(String text) {
		driver.findElement(fisrtName).sendKeys(text);
	}
	
	public void setLastName(String text) {
		driver.findElement(lastName).sendKeys(text);
	}
	
	public void setPhoneNumber(String number) {
		driver.findElement(phoneNumber).sendKeys(number);
	}

	public void setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}
	
	public ProfilePage clickSignUpButton() {
		driver.findElement(signupButton).click();
		implicitWaitforSuccessfull();
		return new ProfilePage(driver);
	}
	
	public ProfilePage clickSignUpButtonForValidation() {
		driver.findElement(signupButton).click();
		return new ProfilePage(driver);
	}
	
	public void implicitWaitValidation() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(ValidationMessage));
	}
	
	private void implicitWaitforSuccessfull(){
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(fisrtName));
		
	}
	
	public String getValidationMessageText() {
		return driver.findElement(ValidationMessage).getText();
	}
}
