package suites;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

public class BaseLabSuiteTest {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();

	}

	@AfterClass
	public static void tearDown() {
		driver.close();

	}

	@Test
	public void ExecuteTestSteps() {

		driver.get("https://getbase.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		HomePage hp = new HomePage(driver);

		LoginPage lp = hp.login();

		DashboardPage dp = lp.dashboard();
		dp.createLead();
		assertTrue(dp.verifyStatus("New"));

		dp.changeStatus("newStatus");

		assertTrue(dp.verifyStatus("newStatus"));

		dp.changeStatus("New");

	}

}
