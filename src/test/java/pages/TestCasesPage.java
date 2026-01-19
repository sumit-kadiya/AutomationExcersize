package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

WebDriver driver;
	
	//constructor
	public TestCasesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//a[contains(text(),'Test Cases')]") 
	WebElement btn_testCase;
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	WebElement headElement;
	@FindBy(xpath="//b[normalize-space()='Test Cases']") 
	WebElement testCasesHeader;
	
	
	//actions
	public boolean isHomePageVisible() {
		return headElement.isDisplayed();
	}
    
    public void clickTestCase() {
    	btn_testCase.click();
    }
    
    public boolean isTestCasesPageVisible(String title) {
		return testCasesHeader.getText().equalsIgnoreCase(title);
	}
	
}
