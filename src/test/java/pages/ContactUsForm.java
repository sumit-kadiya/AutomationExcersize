package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsForm {

WebDriver driver;
	
	//constructor
	public ContactUsForm(WebDriver driver) {
		this.driver = driver;
	}

	//locators
	private By btn_contactUs = By.xpath("//a[normalize-space()='Contact us']");
	private By login_header = By.xpath("//h2[normalize-space()='Get In Touch']");

	private By txt_name = By.xpath("//input[@placeholder='Name']");
	private By txt_email = By.xpath("//input[@placeholder='Email']");
	private By txt_subject = By.xpath("//input[@placeholder='Subject']");
	private By txt_message = By.xpath("//textarea[@id='message']");
	private By upload_file = By.xpath("//input[@name='upload_file']");
	private By btn_submit = By.xpath("//input[@name='submit']");
	private By msg_success = By.xpath("//div[@class='status alert alert-success']");
	private By btn_home = By.xpath("//span[normalize-space()='Home']");
    
    //actions
	public boolean isHomePageVisible(String title) {
		return driver.getTitle().equalsIgnoreCase(title);
	}
	
	public void clickOnContactUs() {
		driver.findElement(btn_contactUs).click();
	}
	
	public boolean isGetInTouchVisible(String title) {
		return driver.findElement(login_header).getText().equalsIgnoreCase(title);
	}
	
	public void enterName(String name) {
    	driver.findElement(txt_name).sendKeys(name);
    }
	
	public void enterEmail(String email) {
    	driver.findElement(txt_email).sendKeys(email);
    }
	
	public void enterSubject(String sub) {
    	driver.findElement(txt_subject).sendKeys(sub);
    }
	
	public void enterMessage(String msg) {
    	driver.findElement(txt_message).sendKeys(msg);
    }
	
	public void uploadFile(String loc) {
		try {
		File file = new File(loc);
		driver.findElement(upload_file).sendKeys(file.getAbsolutePath());
		} catch(Exception e) { e.printStackTrace();}
	}
	
	public void clickSubmit() {
		driver.findElement(btn_submit).submit();
	}
	
	public void clickOnAlert(boolean choice) {
		if(choice) driver.switchTo().alert().accept();
		else driver.switchTo().alert().dismiss();;
	}
	
	public boolean isSuccessMessageVisible() {
		return driver.findElement(msg_success).isDisplayed();
	}
	
	public void clickOnHome() {
		driver.findElement(btn_home).click();
	}
	
	
}
