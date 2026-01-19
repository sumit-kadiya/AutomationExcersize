package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import config.Constants;
import pages.LoginPage;

public class LoginPageTest {

	private WebDriver driver;
	private LoginPage obj;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().window().maximize();
		obj = new LoginPage(driver);
	}
	
	@Test
	public void loginTest() {
		Assert.assertTrue(obj.IsHomePageVisible(Constants.HOME_PAGE_TITLE), "Home page in not visible - test failed");
		obj.navigateToLogin();
		Assert.assertTrue(obj.isLoginheaderVisible(Constants.LOGIN_HEADER), "LOGIN TO YOUR ACCOUNT is not visible - test failed");
		obj.enterEmail(Constants.EMAIL_LOGIN);
		obj.enterPassword(Constants.PASSWORD_LOGIN);
		obj.clickLogin();
		Assert.assertTrue(obj.isLoginAsUsernameVisible(), "LOGIN AS USERNAME is not visible - test failed");
		obj.clickLogOut();
		Assert.assertTrue(obj.verifyNavigateToLogin(Constants.LOGIN_URL), "Navigation to Login page Unsuccessful - test failed");
	}
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
