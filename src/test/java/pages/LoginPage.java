package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//locators
	private By btn_navigate_login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By login_header = By.xpath("//h2[normalize-space()='Login to your account']");
    private By txt_login = By.xpath("//input[@data-qa='login-email']");
    private By txt_pass = By.xpath("//input[@placeholder='Password']");
    private By btn_login = By.xpath("//button[normalize-space()='Login']");
    private By btn_username = By.xpath("//li[10]//a[1]");
	private By btn_logout = By.xpath("//a[normalize-space()='Logout']");
    
    //actions
	public boolean IsHomePageVisible(String title) {
		return driver.getTitle().equalsIgnoreCase(title);
	}
    
    public void navigateToLogin() {
    	driver.findElement(btn_navigate_login).click();
    }
    
    public boolean isLoginheaderVisible(String txt) {
    	return driver.findElement(login_header).getText().equalsIgnoreCase(txt);
    }
    
    public void enterEmail(String email) {
    	driver.findElement(txt_login).sendKeys(email);
    }
    
    public void enterPassword(String pass) {
    	driver.findElement(txt_pass).sendKeys(pass);
    }
    
    public void clickLogin() {
    	driver.findElement(btn_login).submit();
    }
    
    public boolean isLoginAsUsernameVisible() {
    	return driver.findElement(btn_username).isDisplayed();
    }
    
    public void clickLogOut() {
    	driver.findElement(btn_logout).click();
    }
    
    public boolean verifyNavigateToLogin(String url) {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
    }
    

}
