package Hackathon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListingPage {
	WebDriver driver;
	 public ListingPage(WebDriver driver) {
		 this.driver=driver;
	 }
	
	public void clickOnListing() {
		 WebElement listing = driver.findElement(By.id("h_flist"));
		 listing.click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	
	public void sendCompanyName() throws InterruptedException {
		WebElement cn = driver.findElement(By.id("fcom"));
		cn.sendKeys("Sai Infra");
		Thread.sleep(2000);
	 }
	
	public void sendFirstName() throws InterruptedException {
		WebElement fname = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		fname.sendKeys("Sai");
		Thread.sleep(2000);
	}
	
	public void sendLastName() throws InterruptedException {
		WebElement lname = driver.findElement(By.xpath("//*[@id=\"lname\"]"));
		lname.sendKeys("Patil");
		Thread.sleep(2000);
	}
	
	public void sendPhoneNumber() throws InterruptedException {
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"fmb0\"]"));
		phone.sendKeys("252533");
		Thread.sleep(2000);
	}
	
	public void clickOnSubmitButton() throws InterruptedException {
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"add_div0\"]/div[3]/button"));
		submit.click();
		Thread.sleep(2000);
	}
	
	public void displayErrorMessage() {
		WebElement error = driver.findElement(By.id("fmb0Err"));
		String a=error.getText();
		System.out.println(a);
	}
	public static void main(String[] args) throws InterruptedException {
		ExtentHtmlReporter report = new ExtentHtmlReporter("C:\\Users\\Sagar\\eclipse-workspace\\IdentifyCarWashingServices\\target\\ExtentReport\\ExtentReportOfListingPage.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		ExtentTest test1 = extent.createTest("Test Case 1","This is a test Report for Listing Page");
		ExtentTest test2 = extent.createTest("Test Case 2","This is a test Report for Listing Page");
		ExtentTest test3 = extent.createTest("Test Case 3","This is a test Report for Listing Page");
		ExtentTest test4 = extent.createTest("Test Case 4","This is a test Report for Listing Page");
		ExtentTest test5 = extent.createTest("Test Case 5","This is a test Report for Listing Page");
		ExtentTest test6 = extent.createTest("Test Case 6","This is a test Report for Listing Page");
		ExtentTest test7 = extent.createTest("Test Case 7","This is a test Report for Listing Page");
		ExtentTest test8 = extent.createTest("Test Case 8","This is a test Report for Listing Page");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/");
		test1.log(Status.INFO, "Opened the page");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ListingPage l = new ListingPage(driver);
		l.clickOnListing();
		test2.log(Status.INFO, "Clicked On Listing Menu");
		l.sendCompanyName();
		test3.log(Status.INFO, "Sent the Company name");
		l.sendFirstName();
		test4.log(Status.INFO, "Sent the first name ");
		l.sendLastName();
		test5.log(Status.INFO, "Sent the last name");
		l.sendPhoneNumber();
		test6.log(Status.INFO, "Sent the Phone number");
		l.clickOnSubmitButton();
		test7.log(Status.INFO, "Clicked On Submit Button");
		l.displayErrorMessage();
		test8.log(Status.INFO, "Displayed Error  message On Console");
		
		
		driver.close();
		extent.flush();
	}
	
}
