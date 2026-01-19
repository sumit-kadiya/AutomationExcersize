package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	By btn_navigate_signup = By.xpath("//a[normalize-space()='Signup / Login']");
    By txt_name = By.xpath("//input[@placeholder='Name']");
    By txt_email = By.xpath("//input[@data-qa='signup-email']");
    By btn_signup = By.xpath("//button[normalize-space()='Signup']");
    
    By msg_accountInfoVisible = By.xpath("//b[normalize-space()='Enter Account Information']");
    By radio_gender_m = By.xpath("//input[@id='id_gender1']");
    By radio_gender_f = By.xpath("//input[@id='id_gender2']");
    By txt_pass = By.xpath("//input[@id='password']");
    By dropdown_date = By.xpath("//select[@id='days']");
    By dropdown_month = By.xpath("//select[@id='months']");
    By dropdown_year = By.xpath("//select[@id='years']");
    By check_newsletter = By.xpath("//input[@id='newsletter']");
    By check_offers = By.xpath("//input[@id='optin']");
    By txt_firstname = By.xpath("//input[@id='first_name']");
    By txt_lastname = By.xpath("//input[@id='last_name']");
    By txt_company = By.xpath("//input[@id='company']");
    By txt_address1 = By.xpath("//input[@id='address1']");
    By txt_address2 = By.xpath("//input[@id='address2']");
    By dropdown_country = By.xpath("//select[@id='country']");
    By txt_state = By.xpath("//input[@id='state']");
    By txt_city = By.xpath("//input[@id='city']");
    By txt_zipcode = By.xpath("//input[@id='zipcode']");
    By txt_mobile = By.xpath("//input[@id='mobile_number']");
    By btn_createAccount = By.xpath("//button[normalize-space()='Create Account']");
    
    By msg_accountCreatedVisible = By.xpath("//b[normalize-space()='Account Created!']");
    By btn_continue = By.xpath("//a[normalize-space()='Continue']");
    By msg_loginAsUsernameVisible = By.xpath("//li[10]//a[1]");
    By btn_deleteAccount = By.xpath("//a[normalize-space()='Delete Account']");
    By btn_continueTwo = By.xpath("//a[normalize-space()='Continue']");
    By msg_accountDeletedVisible = By.xpath("//b[normalize-space()='Account Deleted!']");
    		
    //actions page:1
    public boolean isHomePageVisible(String title) {
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
    
    //actions page:2
    public boolean isAccountInfoVisible(String msg) {
    	return driver.findElement(msg_accountInfoVisible).getText().equalsIgnoreCase(msg);
    }
    
    public void genderCheck(String gender) {
    	WebElement btn_male = driver.findElement(radio_gender_m);
    	WebElement btn_female = driver.findElement(radio_gender_f);
    	if(!btn_male.isSelected() && !btn_female.isSelected()) {
    		if(gender.equalsIgnoreCase("male")) btn_male.click();
    		else if (gender.equalsIgnoreCase("female")) btn_female.click();
    		else Assert.assertFalse(true);
    	}
    	
    }
    
    public void setPassword(String pwd) {
    	driver.findElement(txt_pass).sendKeys(pwd);
    }
    
    public void setDOB(int[] arr) {
    	new Select(driver.findElement(dropdown_date)).selectByValue(String.valueOf(arr[0]));
    	new Select(driver.findElement(dropdown_month)).selectByValue(String.valueOf(arr[1]));
    	new Select(driver.findElement(dropdown_year)).selectByValue(String.valueOf(arr[2]));
    }
    
    public void checkNewsLetters(boolean choice) {
    	if(choice) driver.findElement(check_newsletter).click();
    }
    
    public void checkOffers(boolean choice) {
    	if(choice) driver.findElement(check_offers).click();
    }
    
    public void setFirstName(String fname) {
    	driver.findElement(txt_firstname).sendKeys(fname);
    }
    
    public void setLastName(String lname) {
    	driver.findElement(txt_lastname).sendKeys(lname);
    } 
    
    public void setCompany(String company) {
    	driver.findElement(txt_company).sendKeys(company);
    } 
    
    public void setAddress(String add1, String add2) {
    	driver.findElement(txt_address1).sendKeys(add1);
    	driver.findElement(txt_address2).sendKeys(add2);
    }
    
    public void setCountry(String country) {
    	new Select(driver.findElement(dropdown_country)).selectByValue(country.substring(0, 1).toUpperCase() + country.substring(1).toLowerCase());
    } 
    
    public void setstate(String state) {
    	driver.findElement(txt_state).sendKeys(state);
    } 
    
    public void setCity(String city) {
    	driver.findElement(txt_city).sendKeys(city);
    } 
    
    public void setZipCode(String zip) {
    	driver.findElement(txt_zipcode).sendKeys(zip);
    } 
    
    public void setMobile(String mobile) {
    	driver.findElement(txt_mobile).sendKeys(mobile);
    } 
    
    public void clickCreateAccountButton() {
    	driver.findElement(btn_createAccount).submit();
    }
    
    //action page:3
    public boolean isAccountCreatedVisible (String msg) {
        return driver.findElement(msg_accountCreatedVisible).getText().equalsIgnoreCase(msg);
    }
    
    public void clickContinueButton() {
    	driver.findElement(btn_continue).click();
    }
    
    public boolean isLoginAsUsernameVisible(String msg) {
    	return driver.findElement(msg_loginAsUsernameVisible).getText().equalsIgnoreCase(msg);
    }
    
    public void clickDeleteAccount() {
    	driver.findElement(btn_deleteAccount).click();
    }
    
    public boolean isAccountDeletedVisible (String msg) {
    	return driver.findElement(msg_accountDeletedVisible).getText().equalsIgnoreCase(msg);
    }

    public void clickContinueButtonTwo() {
    	driver.findElement(btn_continueTwo).click();
    }
}
