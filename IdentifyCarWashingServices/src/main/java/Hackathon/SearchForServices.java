package Hackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForServices {

	WebDriver driver;
	public void setup_open_url() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.justdial.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	public void search_for_car_washing_services() throws InterruptedException {
		
		WebElement searchBox = driver.findElement(By.id("srchbx"));
		searchBox.sendKeys("Car Washing Services");
		Thread.sleep(2000);
	}
	public void click_on_search_button() throws InterruptedException {
		WebElement searchButton = driver.findElement(By.id("srIconwpr"));
		searchButton.click();
		
	}
	public void display_services_on_console() {
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='green-box']"));
		List<WebElement> names = driver.findElements(By.xpath("//span[@class='lng_cont_name']"));
		List<WebElement> contacts = driver.findElements(By.className("shownum"));
		List<WebElement> no = driver.findElements(By.xpath("//p[@class='contact-info ']"));
		List<WebElement> votes =driver.findElements(By.xpath("//ul[contains(@class,'padding')]//child::"
                + "li//p[contains(@class,'new')]//span[contains(@class,'vote')]"));
		for(int j=0;j<contacts.size();j++) {
			
			 contacts.get(j).click();
			 
		}
		for (int i = 0; i < 6; i++) {
			float rate = Float.parseFloat(ratings.get(i).getText());
			String numeric[] = votes.get(i).getText().split(" ");
			int vote = Integer.parseInt(numeric[0]);
			if (rate > 4 && vote>20) {
				
				System.out.println(names.get(i).getText()+ " - " + no.get(i).getText());
				
			}
		}
	}
	public void close_browser() {
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		ExtentHtmlReporter report = new ExtentHtmlReporter("C:\\Users\\Sagar\\eclipse-workspace\\IdentifyCarWashingServices\\target\\ExtentReport\\ExtentReportOfSearchForServices1.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		ExtentTest test1 = extent.createTest("Test Case 1","This is a test Report for SearchForServices Page");
		ExtentTest test2 = extent.createTest("Test Case 2","This is a test Report for SearchForServices Page");
		ExtentTest test3 = extent.createTest("Test Case 3","This is a test Report for SearchForServices Page");
		ExtentTest test4 = extent.createTest("Test Case 4","This is a test Report for SearchForServices Page");
		ExtentTest test5 = extent.createTest("Test Case 5","This is a test Report for SearchForServices Page");
		SearchForServices s =new SearchForServices();
		s.setup_open_url();
		test1.log(Status.INFO, "Opened the page");
		s.search_for_car_washing_services();
		test2.log(Status.INFO, "Searched for services");
		s.click_on_search_button();
		test3.log(Status.INFO, "Clicked on submit Button");
		s.display_services_on_console();
		test4.log(Status.INFO, "Displayed Services on console");
		s.close_browser();
		test5.log(Status.INFO, "Closed the Page");
		extent.flush();
	}

	
}
