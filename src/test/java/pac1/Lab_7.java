package pac1;

import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_7 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://letcode.in/window");
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("multi")).click();
		
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("accept")).click();
		
		Thread.sleep(1000);
		
		Alert simplealert=driver.switchTo().alert();
		simplealert.accept();
		
		driver.findElement(By.id("confirm")).click();
		
		Thread.sleep(1000);
		
		Alert confirmalert=driver.switchTo().alert();
		
		System.out.println("confirm alert messge:"+confirmalert.getText());
		confirmalert.accept();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("prompt")).click();
		
		Alert promptalert=driver.switchTo().alert();
		
		Thread.sleep(1000);
		
		System.out.println("prompt alert messge:"+promptalert.getText());
		promptalert.sendKeys("Hi");
		promptalert.accept();
		
		Thread.sleep(1000);
		
		driver.switchTo().window(windows.get(2));
		System.out.println(driver.getTitle());
		
		WebElement fruits = driver.findElement(By.id("fruits"));
		Select s1=new Select(fruits);
		s1.selectByVisibleText("Apple");
		
		WebElement superHerores = driver.findElement(By.id("superheros"));
		Select s2=new Select(superHerores);
		s2.selectByVisibleText("Spider-Man");
		
		WebElement lang = driver.findElement(By.id("lang"));
		Select s3=new Select(lang);
		s3.selectByVisibleText("Java");
		
		WebElement country = driver.findElement(By.id("country"));
		Select s4=new Select(country);
		s4.selectByVisibleText("India");
		
		Thread.sleep(1000);
		
		String values = driver.findElement(By.xpath("//p[@class = 'text-sm font-medium']")).getText();
		System.out.println(values);
		
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
}