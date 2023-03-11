package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitnessPageTest {
	WebDriver driver ;
	
	@BeforeClass
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.justdial.com/");
	}
	@Test(priority = 1)
	public void fitness() throws InterruptedException {
		 WebElement fitness = driver.findElement(By.id("hotkeys_text_26"));
			fitness.click();
			Thread.sleep(5000);
	 }
	@Test(priority = 2)
	 public void gym() throws InterruptedException {
		 WebElement gym = driver.findElement(By.linkText("Gym"));
			gym.click();
			Thread.sleep(2000);
	 }
	@Test(priority = 3)
	 public void DisplaySubMenu() throws InterruptedException {
		 List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"mnintrnlbnr\"]/ul[1]"));
			for(int i=0;i<ele.size();i++) {
				WebElement ele1 = ele.get(i);
				String s1 = ele1.getText();
				System.out.println(s1);
			}
			Thread.sleep(2000);
	 }
	@Test(priority = 4)
	public void ClosePage() {
		driver.close();
	}
	

}
