package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterExistingUser {

WebDriver driver;
	
	public RegisterExistingUser(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	By btn_navigate_signup = By.xpath("//a[normalize-space()='Signup / Login']");
    By txt_name = By.xpath("//input[@placeholder='Name']");
    By txt_email = By.xpath("//input[@data-qa='signup-email']");
    By btn_signup = By.xpath("//button[normalize-space()='Signup']");
    
    //actions
    public boolean IsHomePageVisible(String title) {
		return driver.getTitle().equalsIgnoreCase(title);
	}
    
    public void navigateToSignup() {
    	driver.findElement(btn_navigate_signup).click();
    }
    
    public void enterName(String name) {
    	driver.findElement(txt_name).sendKeys(name);
    }
    
    public void enterEmail(String email) {
    	driver.findElement(txt_email).sendKeys(email);
    }
    
    public void clickSignup() {
    	driver.findElement(btn_signup).submit();
    }
    
    public boolean isErrorMessageVisible(String msg) {
    	return driver.getPageSource().contains(msg);
    }
}
