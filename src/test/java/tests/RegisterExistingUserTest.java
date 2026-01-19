package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Constants;
import pages.RegisterExistingUser;

public class RegisterExistingUserTest {

	private WebDriver driver;
	private RegisterExistingUser obj;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().window().maximize();
		obj = new RegisterExistingUser(driver);
	}
	
	@Test
	public void registerExistingUser() {
		Assert.assertTrue(obj.IsHomePageVisible(Constants.HOME_PAGE_TITLE), "Home page in not visible - test failed");
		obj.navigateToSignup();
		obj.enterName(Constants.NAME);
		obj.enterEmail(Constants.EMAIL);
		obj.clickSignup();
		Assert.assertTrue(obj.isErrorMessageVisible(Constants.ERROR_MESSAGE), "Error message in not visible - test failed");
	}
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
