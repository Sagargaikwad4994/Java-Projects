package Hackathon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitnessPage {

	
		WebDriver driver;
		 public FitnessPage(WebDriver driver) {
			 this.driver=driver;
		 }
		
		 public void fitness() throws InterruptedException {
			 WebElement fitness = driver.findElement(By.id("hotkeys_text_26"));
				fitness.click();
				Thread.sleep(5000);
		 }
		 public void gym() throws InterruptedException {
			 WebElement gym = driver.findElement(By.linkText("Gym"));
				gym.click();
				Thread.sleep(2000);
		 }
		 public void DisplaySubMenu() throws InterruptedException {
			 List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"mnintrnlbnr\"]/ul[1]"));
				for(int i=0;i<ele.size();i++) {
					WebElement ele1 = ele.get(i);
					String s1 = ele1.getText();
					System.out.println(s1);
				}
				Thread.sleep(2000);
		 }
		 public static void main(String[] args) throws InterruptedException {
				
				ExtentHtmlReporter report = new ExtentHtmlReporter("C:\\Users\\Sagar\\eclipse-workspace\\IdentifyCarWashingServices\\target\\ExtentReport\\ExtentReportOfFitnessPage.html");
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(report);
				ExtentTest test1 = extent.createTest("Test Case 1","This is a test Report for Fitness Page");
				ExtentTest test2 = extent.createTest("Test Case 2","This is a test Report for Fitness Page");
				ExtentTest test3 = extent.createTest("Test Case 3","This is a test Report for Fitness Page");
				ExtentTest test4 = extent.createTest("Test Case 4","This is a test Report for Fitness Page");
				ExtentTest test5 = extent.createTest("Test Case 5","This is a test Report for Fitness Page");
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.justdial.com/");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				test1.log(Status.INFO, "Opened the page");
				FitnessPage f = new FitnessPage(driver);
				
				f.fitness();
				test2.log(Status.INFO, "Clicked on Fitness Menu");
				f.gym();
				test3.log(Status.INFO, "Clicked on Gym Menu");
				f.DisplaySubMenu();
				test4.log(Status.INFO, "Displayed Sub Menu Items On Console");
				driver.close();
				test5.log(Status.INFO, "Closed the Page");
				extent.flush();
			}
}
