package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForServicesTest {

	WebDriver driver;
	@Test(priority = 1)
	public void setup_open_url() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.justdial.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void search_for_car_washing_services() throws InterruptedException {
		WebElement searchBox = driver.findElement(By.id("srchbx"));
		searchBox.sendKeys("Car Washing Services");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void click_on_search_button() {
		WebElement searchButton = driver.findElement(By.id("srIconwpr"));
		searchButton.click();
	}
	@Test(priority = 4)
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
	@Test(priority = 5)
	public void close_browser() {
		driver.close();
	}
}
