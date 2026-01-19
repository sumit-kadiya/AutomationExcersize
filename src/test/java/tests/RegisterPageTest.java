package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Constants;
import pages.RegisterPage;

public class RegisterPageTest {

	private WebDriver driver;
	private RegisterPage obj;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().window().maximize();
		obj = new RegisterPage(driver);
	}
	
	@Test
	public void signUpTestCase() {
		Assert.assertTrue(obj.isHomePageVisible(Constants.HOME_PAGE_TITLE), "Home page in not visible - test failed");
		obj.navigateToSignup();
		obj.enterName(Constants.NAME);
		obj.enterEmail(Constants.EMAIL);
		obj.clickSignup();
	}
	
	@Test(dependsOnMethods = "signUpTestCase")
	public void signUpTestCaseTwo() {
		Assert.assertTrue(obj.isAccountInfoVisible(Constants.ENTER_ACC_INFO_HEADER), "ENTER ACCOUNT INFORMATION is not visible - test failed");
		obj.genderCheck(Constants.GENDER);
		obj.setPassword(Constants.PASSWORD);
		obj.setDOB(Constants.DOB);
		obj.checkNewsLetters(Constants.NEWS_LETTERS);
		obj.checkOffers(Constants.OFFERS);
		obj.setFirstName(Constants.FIRSTNAME);
		obj.setLastName(Constants.LASTNAME);
		obj.setCompany(Constants.COMPANY);
		obj.setAddress(Constants.ADDRESS_1, Constants.ADDRESS_2);
		obj.setCountry(Constants.COUNTRY);
		obj.setstate(Constants.STATE);
		obj.setCity(Constants.CITY);
		obj.setZipCode(Constants.ZIPCODE);
		obj.setMobile(Constants.MOBILE_NO);
		obj.clickCreateAccountButton();
	}
	
	@Test(dependsOnMethods = "signUpTestCaseTwo")
	public void signupTestcaseThree() {
		Assert.assertTrue(obj.isAccountCreatedVisible(Constants.ACC_CREATED_HEADER), "ACCOUNT CREATED! is NOT visible - test failed");
		obj.clickContinueButton();
		Assert.assertTrue(obj.isLoginAsUsernameVisible(Constants.LOGGED_IN_AS_USERNAME), "LOGGED IN AS USERNAME is not visible - test failed");
		obj.clickDeleteAccount();
		Assert.assertTrue(obj.isAccountDeletedVisible(Constants.ACC_DELETED_HEADER), "ACCOUNT DELETED! is not visible - test failed");
		obj.clickContinueButtonTwo();
	}
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
