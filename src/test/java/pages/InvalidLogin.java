package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class InvalidLogin {

	WebDriver driver;
	
	public InvalidLogin (WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	private By btn_navigate_login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By login_header = By.xpath("//h2[normalize-space()='Login to your account']");
	private By txt_login = By.xpath("//input[@data-qa='login-email']");
	private By txt_password = By.xpath("//input[@placeholder='Password']");
	private By btn_login = By.xpath("//button[normalize-space()='Login']");

	
	//actions
	public boolean IsHomePageVisible(String title) {
		return driver.getTitle().equalsIgnoreCase(title);
	}
	
	public void navigateToLogin() {
		driver.findElement(btn_navigate_login).click();
    }
    
	public boolean isLoginheaderVisible(String txt) {
    	return driver.findElement(login_header).getText().equals(txt);
    }

    public void enterEmail(String email) {
    	WebElement emailBox = driver.findElement(txt_login);
    	if(emailBox.isEnabled()) driver.findElement(txt_login).sendKeys(email);
    }
    
    public void enterPassword(String pass) {
    	WebElement passBox = driver.findElement(txt_password);
    	if(passBox.isEnabled()) driver.findElement(txt_password).sendKeys(pass);
    }
    
    public void clickLogin() {
    	WebElement loginButton = driver.findElement(btn_login);
    	if(loginButton.isEnabled()) driver.findElement(btn_login).submit();
    }
    
    public boolean isErrorMessageVisible(String msg) {
    	return driver.getPageSource().contains(msg);
    }
	
}
