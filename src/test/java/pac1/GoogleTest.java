package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    public static void main(String[] args) {

    	WebDriverManager.chromedriver().setup();
    	
    	WebDriver driver=new ChromeDriver();
    	
    	driver.get("https://www.google.com/");
    	
    	WebElement search=driver.findElement(By.id("ti6dpd"));
    	
    	search.sendKeys("Testing Methods");
    	
    	search.submit();
    	
    	String title;
    	title=driver.getTitle();
    	System.out.println("The tilte of the page is:"+title);
    }
}