package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListingPageTest {
WebDriver driver ;
	
	@BeforeClass
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.justdial.com/");
	}
	@Test(priority = 1)
	public void clickOnListing() {
		 WebElement listing = driver.findElement(By.id("h_flist"));
		 listing.click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	@Test(priority = 2)
	public void sendCompanyName() throws InterruptedException {
		WebElement cn = driver.findElement(By.id("fcom"));
		cn.sendKeys("Sai Infra");
		Thread.sleep(2000);
	 }
	@Test(priority = 3)
	public void sendFirstName() throws InterruptedException {
		WebElement fname = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		fname.sendKeys("Sai");
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void sendLastName() throws InterruptedException {
		WebElement lname = driver.findElement(By.xpath("//*[@id=\"lname\"]"));
		lname.sendKeys("Patil");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void sendPhoneNumber() throws InterruptedException {
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"fmb0\"]"));
		phone.sendKeys("252533");
		Thread.sleep(2000);
	}
	@Test(priority = 6)
	public void clickOnSubmitButton() throws InterruptedException {
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"add_div0\"]/div[3]/button"));
		submit.click();
		Thread.sleep(2000);
	}
	@Test(priority = 7)
	public void displayErrorMessage() {
		WebElement error = driver.findElement(By.id("fmb0Err"));
		String a=error.getText();
		System.out.println(a);
	}
	@Test(priority = 8)
	public void ClosePage() {
		driver.close();
	}

}
