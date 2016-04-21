package pages;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public DashboardPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void createLead(){
		
		driver.findElement(By.id("nav-leads")).click();
		driver.findElement(By.id("leads-new")).click();
		driver.findElement(By.id("lead-first-name")).sendKeys("Pawel");
		driver.findElement(By.id("lead-last-name")).sendKeys(UUID.randomUUID().toString().replaceAll("-", ""));
		driver.findElement(By.cssSelector(".save.btn.btn-large.btn-primary")).click();
		
	}
	
	
	public boolean verifyStatus(String s){
		 
			
		boolean b;
		if(driver.findElement(By.className("lead-status")).getText().equals(s)){
			b=true;
		}else{
			b=false;
		}
			
		return b;
	}
	
	public void changeStatus(String s){
		
		driver.findElement(By.className("user-avatar")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("icon-cog")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Lead Statuses")).click();
		driver.findElement(By.xpath("//*[@id=\"lead-status\"]/div[1]/span[1]/div/div/div/div/button")).click();
		
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/div[4]/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/div[4]/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input")).sendKeys(s);
		driver.findElement(By.xpath("//*[@id=\"lead-status\"]/div[1]/span[1]/div/div/form/fieldset/div[3]/div/button")).click();
		
		driver.findElement(By.id("nav-leads")).click();
		
		driver.findElement(By.className("lead-name")).click();
		
		
	}
	
	
	
	
	
	
	

}
