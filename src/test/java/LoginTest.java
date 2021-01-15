import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void doLogin() throws InterruptedException {
		driver.get("http://dbankdemo.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("ratish.jayemb@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ratish@123");
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(1000);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div[1]/div/a[3]")).click();
		driver.quit();
	}

}
