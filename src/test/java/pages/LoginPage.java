package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public DashboardPage dashboard() {

		doLogin();
		return new DashboardPage(driver);

	}

	public void doLogin() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("user[email]")).sendKeys(
				"paw.zurawski@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("tempPassword1@");
		driver.findElement(By.className("icon-lock")).click();

	}

}
