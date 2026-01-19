package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Constants;
import pages.ContactUsForm;

public class ContactUsFormTest {

	private WebDriver driver;
	private ContactUsForm obj;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().window().maximize();
		obj = new ContactUsForm(driver);
	}
	
	@Test
	public void contactUsFormTest() {
		Assert.assertTrue(obj.isHomePageVisible(Constants.HOME_PAGE_TITLE), "Home page in not visible - test failed");
		obj.clickOnContactUs();
		Assert.assertTrue(obj.isGetInTouchVisible(Constants.GETINTOUCH_HEADER), "GET IN TOUCH in not visible - test failed");
		obj.enterName(Constants.NAME);
		obj.enterEmail(Constants.EMAIL);
		obj.enterSubject(Constants.SUBJECT);
		obj.enterMessage(Constants.MESSAGE);
		obj.uploadFile(Constants.FILE);
		obj.clickSubmit();
		obj.clickOnAlert(Constants.ALERT);
		Assert.assertTrue(obj.isSuccessMessageVisible(), "Success message in not visible - test failed");
		obj.clickOnHome();
		Assert.assertTrue(obj.isHomePageVisible(Constants.HOME_PAGE_TITLE), "Navigation to home page is Unsuccessful - test failed");
	}
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
