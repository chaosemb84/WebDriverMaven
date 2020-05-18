import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void doLogin() {
		driver.get("http://dbankdemo.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("ratish.jayemb@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ratish@123");
		driver.findElement(By.id("submit")).click();
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
