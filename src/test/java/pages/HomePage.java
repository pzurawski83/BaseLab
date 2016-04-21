package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	public LoginPage login() {

		clickLogin();

		return new LoginPage(driver);
	}

	public void clickLogin() {

		driver.findElement(By.className("show-for-large-up")).click();

	}

}
