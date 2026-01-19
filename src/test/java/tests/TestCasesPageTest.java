package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Constants;
import pages.TestCasesPage;

public class TestCasesPageTest {

	private WebDriver driver;
	private TestCasesPage obj;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().window().maximize();
		obj = new TestCasesPage(driver);
	}
	
	@Test
	public void TestCasesTest() {
		Assert.assertTrue(obj.isHomePageVisible(), "Home page in not visible - test failed");
		obj.clickTestCase();
		Assert.assertTrue(obj.isTestCasesPageVisible(Constants.TEST_CASE_HEADER), "Navigation to Test cases page Unsuccessful - test failed");
	}
	
	@AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
